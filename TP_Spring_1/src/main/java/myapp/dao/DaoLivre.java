package myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import myapp.entities.Livre;

public class DaoLivre {
	
	@PersistenceContext
	(type = PersistenceContextType.TRANSACTION )
	EntityManager em;
	
	// add client
		public Livre addLivre(Livre l) {
			em.persist(l);
			System.err.println("addLivre avec l\'id = "+ l.getId());
			return l;
		}
		
		//read all
		public List<Livre> selectAll() {
			TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l", Livre.class);
			return query.getResultList();
		}
		
		//read one
		public Livre findById(int id) {
			return em.find(Livre.class, id);
		}
		
		// update client
		public Livre updateLivre(Livre l) {
			em.merge(l);
			System.err.println("updateLivre avec l\'id = " + l.getId());
			return l;
		}
		
		// delete client 
		public Livre deleteLivre(Livre l) {
			em.remove(l);
			System.err.println("updateLivre avec l\'id = " + l.getId());
			return l;
		}


}
