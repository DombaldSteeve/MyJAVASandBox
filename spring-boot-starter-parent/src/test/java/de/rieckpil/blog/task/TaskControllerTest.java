package de.rieckpil.blog.task;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @WebMvcTest Me permet de faire un lien intrinsÃ¨que entre le controller de
 *             Test et le controller Ã  tester et aussi d'exÃ©cuter la classe
 *             ApplicationTest avec @SpringBootTest
 * 
 * @author chris
 *
 */
@WebMvcTest(TaskController.class)
class TaskControllerTest
{
	/**
	 * On rÃ©cupÃ¨re l'injection de MockMvc -> org.mockito.Mockito Cette APi me
	 * permet de faire du Mock (Bouchonnage) -> VirtualisÃ© les data et les
	 * comportements ->SÃ©curitÃ© -> rÃ´le -> retour des responses HTTP .... Appel
	 * http GET POST DELETE HEADER BODY RESPONSE AJOUTER LA SECURITE (User RÃ´les
	 * CSRF ...)
	 */
	@Autowired
	private MockMvc mockMvc;
	/**
	 * @MockBean Me permet de valoriser un service @Service
	 */
	@MockBean
	private TaskService taskService;

	/**
	 * 1 Normalement je ne peux pas faire un POST si je ne suis pas un User
	 * org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user
	 * ---> UserDetail de SpringBoot
	 * 
	 * 2 .andExpect(status().isUnauthorized()); C'est pour vÃ©rifier qu'on doit
	 * Ãªtre reconnu Si on a un status Ã  200 alors Fail : test KO
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldRejectCreatingReviewsWhenUserIsAnonymous() throws Exception
	{
		this.mockMvc.perform(post("/api/tasks") // appel http POST sur l'uri /api/tacks
				.contentType(MediaType.APPLICATION_JSON)
				// on spÃ©cifie le type de data en JSON
				.content("{\"taskTitle\": \"Learn MockMvc\"}")
				// contenu JSON {"taskTitle":"Learn MockMvc"}
				.with(csrf()) // Je passe le csrf() : token
		).andExpect(status().isUnauthorized()); // test que je ne suis pas autorisÃ© !
	}

	/**
	 * Test du POST avec un user : .with(user("duke"))
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldReturnLocationOfReviewWhenUserIsAuthenticatedAndCreatesReview() throws Exception
	{
		/**
		 * Je positionne une tÃ¢che Ã  42 et je teste si mon controller me retourne
		 * cette valeur lors de mon POST.
		 */
		when(taskService.createTask(anyString())).thenReturn(42L);
		this.mockMvc.perform(post("/api/tasks").contentType(MediaType.APPLICATION_JSON)
				.content("{\"taskTitle\": \"Learn MockMvc\"}").with(csrf()).with(user("duke")) // passe le userDetail
																								// avec username = duke
		).andExpect(status().isCreated()) // Si c'est ok created : 201 car c'est ce que retourne notre controller
				.andExpect(header().exists("Location"))
				// on vÃ©rifie si on nous retourne une Location = path("/api/tasks/{taskId}")
				.andExpect(header().string("Location", Matchers.containsString("42")));
		// path("/api/tasks/{taskId}").build(taskId)
	}

	/**
	 * test de la suppression On doit Ãªtre identifiÃ© :@WithMockUser("duke") mais
	 * aussi avoir le rÃ´le ADMIN :
	 * 
	 * @DeleteMapping @RolesAllowed("ADMIN") @RequestMapping("/{taskId}")
	 * 
	 * @throws Exception
	 */
	@Test
	@WithMockUser("duke")
	public void shouldRejectDeletingReviewsWhenUserLacksAdminRole() throws Exception
	{
		this.mockMvc.perform(delete("/api/tasks/42")) // Appel delete http : API REST
				.andExpect(status().isForbidden());
		// Normalement on doit Ãªtre refusÃ© : 403 car on n'a pas positionnÃ© le rÃ´le
	}

	/**
	 * Delete avec le user et le rÃ´le
	 * 
	 * @throws Exception
	 */
	@Test
	public void shouldAllowDeletingReviewsWhenUserIsAdmin() throws Exception
	{
		this.mockMvc.perform(delete("/api/tasks/42") // Suppression de la tÃ¢che 42
				.with(SecurityMockMvcRequestPostProcessors.user("duke").roles("ADMIN", "SUPER_USER"))
				// le user et ses rÃ´les ne pas oublier
				// @EnableGlobalMethodSecurity(jsr250Enabled = true)
				.with(csrf())).andExpect(status().isOk());// Status : 200
		verify(taskService).deleteTask(42L);
		// VÃ©rification la suppression c'est bien effectuÃ©e avec 42
	}
}