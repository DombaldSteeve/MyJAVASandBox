package de.rieckpil.blog.user;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Classe de test du Controller UserController <a href=
 * "https://docs.spring.io/spring-framework/docs/current/reference/pdf/testing.pdf"
 * target="_blank" > FICHE MOCK PDF</a>
 *
 */
@WebMvcTest(UserController.class)
class UserControllerTest
{
	/**
	 * Utilisation de org.springframework.test.web.servlet.MockMvc pour simuler et
	 * dialoguer avec un Controller WEB SPRING
	 */
	@Autowired
	private MockMvc mockMvc;
	/**
	 * On simule en mÃ©moire l'instance UserService pour notre UserController
	 */
	@MockBean
	private UserService userService;

	/**
	 * MockBean private UserService userService; <br>
	 * On simule en mÃ©moire l'instance UserService pour notre UserController <br>
	 * Autowired private MockMvc mockMvc;<br>
	 * Utilisation de org.springframework.test.web.servlet.MockMvc pour simuler et
	 * dialoguer avec un Controller WEB SPRING<br>
	 *
	 * when(userService.getAllUsers()) .thenReturn(List.of(new User("duke",
	 * "duke@spring.io")));<br>
	 * On charge en mÃ©moire les donnÃ©es userService.getAllUsers() par List.of(new
	 * User("duke", "duke@spring.io")) <br>
	 *
	 * @throws Exception
	 */
	@Test
	public void shouldReturnAllUsersForUnauthenticatedUsers() throws Exception
	{
		/**
		 * On charge en mÃ©moire les donnÃ©es userService.getAllUsers() par List.of(new
		 * User("duke", "duke@spring.io"))
		 */
		when(userService.getAllUsers()).thenReturn(List.of(new User("duke", "duke@spring.io")));
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("duke"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("duke@spring.io"));
	}

	/**
	 * when(userService.getUserByUsername("duke")) .thenThrow(new
	 * UserNotFoundException("duke is not found")); <br>
	 * On simule un comportement pour /api/users/duke <br>
	 * Dans ce cas on doit retourner l'exception : UserNotFoundException("duke is
	 * not found")
	 *
	 *
	 */
	@Test
	public void shouldReturn404WhenUserIsNotFound() throws Exception
	{
		when(userService.getUserByUsername("duke")).thenThrow(new UserNotFoundException("duke is not found"));
		/**
		 * On simule le get : /api/users/duke et on doit avoir l'exception ci-dessus
		 */
		this.mockMvc.perform(get("/api/users/duke")).andExpect(status().isNotFound());
	}

	/**
	 * Simulation du POST : post("/api/users")
	 * 
	 * On vÃ©rifie : verify(userService).storeNewUser(any(User.class));
	 *
	 * @throws Exception
	 */
	@Test
	public void shouldAllowCreationForUnauthenticatedUsers() throws Exception
	{
		this.mockMvc
				.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
						.content("{\"username\": \"duke\", \"email\":\"duke@spring.io\"}").with(csrf()))
				.andExpect(status().isCreated()).andExpect(header().exists("Location"))
				.andExpect(header().string("Location", Matchers.containsString("duke")));
		verify(userService).storeNewUser(any(User.class));
	}

	@Test
	public void shouldAllowCreationForUnauthenticatedUsersBadUser() throws Exception
	{
		this.mockMvc.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
				.content("{\"email\":\"duke@spring.io\"}").with(csrf())).andExpect(status().isBadRequest());
	}

	@Test
	public void shouldAllowCreationForUnauthenticatedUsersBadMail() throws Exception
	{
		this.mockMvc
				.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
						.content("{\"username\": \"duke\", \"email\":\"duke@spring.io\"}").with(csrf()))
				.andExpect(status().isBadRequest());
		this.mockMvc
				.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
						.content("{\"username\": \"duke\", \"email\":\"dukespring.io\"}").with(csrf()))
				.andExpect(status().isBadRequest());
		this.mockMvc
				.perform(post("/api/users").contentType(MediaType.APPLICATION_JSON)
						.content("{\"username\": \"duke\",\"email\":\"duke@sp ring\"}").with(csrf()))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void shouldReturnAllUsersForUnauthenticatedUsersThree() throws Exception
	{
		/**
		 * On charge en mémoire les données userService.getAllUsers() par List.of(new
		 * User("duke", "duke@spring.io"))
		 */
		when(userService.getAllUsers()).thenReturn(List.of(new User("duke", "duke@spring.io"),
				new User("CGE", "cge@spring.io"), new User("TOTO", "TOTO@spring.fr")));
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/users")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].username").value("CGE"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].email").value("cge@spring.io"));
	}
}
