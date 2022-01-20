package myapp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import myapp.entities.Client;
import myapp.services.ICrud;

@Repository
@Transactional
@PersistenceContext
public abstract class DaoClient implements ICrud<Client>  {
	
	@PersistenceContext
	(type = PersistenceContextType.TRANSACTION )
	EntityManager em;
	
	// add client
		public Client addClient(Client c) throws SQLException {
			em.persist(c);
			System.err.println("addclient avec l\'id = "+c.getId());
			return c;
		}
		
		//read all
		public List<Client> selectAllClient() {
			TypedQuery<Client> query = em.createQuery("SELECT c FROM CLIENT c", Client.class);
			return query.getResultList();
		}	
		
		//read one
		public Client findById(int id) throws SQLException {
			return em.find(Client.class, id);
		}
		
		// update client
		public Client updateClient(Client c) throws SQLException {
			em.merge(c);
			System.err.println("updateClient avec l\'id = " + c.getId());
			return c;
		}
		
		// delete client 
		public Client deleteClient(Client c) throws SQLException {
			em.remove(c);
			System.err.println("updateClient avec l\'id = " + c.getId());
			return c;
		}


}
