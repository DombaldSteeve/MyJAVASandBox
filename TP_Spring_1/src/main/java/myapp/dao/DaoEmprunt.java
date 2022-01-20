package myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import myapp.entities.Emprunt;

@Service
@Repository
@Transactional
public class DaoEmprunt {
	
	@PersistenceContext
	(type = PersistenceContextType.TRANSACTION )
	EntityManager em;
	
	// add emprunt
	public Emprunt addEmprunt(Emprunt e) {
		em.persist(e);
		System.err.println("addemprunt avec l\'id = "+ e.getId());
		return e;
	}
	
	//read all
	public List<Emprunt> selectAll() {
		TypedQuery<Emprunt> query = em.createQuery("SELECT e FROM EMPRUNT e", Emprunt.class);
		return query.getResultList();
	}
	
	//read one
	public Emprunt findById(int id) {
		return em.find(Emprunt.class, id);
	}
	
	// update client
	public Emprunt updateEmprunt(Emprunt e) {
		em.merge(e);
		System.err.println("updateEmprunt avec l\'id = " + e.getId());
		return e;
	}
	
	// delete client 
	public Emprunt deleteEmprunt(Emprunt e) {
		em.remove(e);
		System.err.println("updateEmprunt avec l\'id = " + e.getId());
		return e;
	}


}
