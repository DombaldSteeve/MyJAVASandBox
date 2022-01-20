package myapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import myapp.entities.Client;
import myapp.services.ICrud;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class TestSpringJpa {
	
	@Autowired
	ICrud<Client> icc;
	
	@Test
	public void testAddClient() {
		Client c = new Client();
		c.setNom("GERMAIN");
		c.setPrenom("Christophe");
		icc.add(c);
	}
}
