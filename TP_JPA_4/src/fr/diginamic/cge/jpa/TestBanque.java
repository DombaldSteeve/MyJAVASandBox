package fr.diginamic.cge.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.cge.jpa.model.EClient;
import fr.diginamic.cge.jpa.model.EBanque;
import fr.diginamic.cge.jpa.model.ECompte;


/**
 * Hello world!
 *
 */
public class TestBanque 
{
	
	private static String DURANT;
	private static String Nicolas;

	public static void main( String[] args )
    {
    	EntityManagerFactory emf =null;
    	try 
    	{
    	/**
    	 * Choix de l'unité de persistence dans le fichier de Persistence.xml
    	 * "bddBanque"
    	 */
    		
	        emf = Persistence.createEntityManagerFactory("bddBanque");
	        EntityManager em = emf.createEntityManager();
	        
	        
	      /*  
	        //CREATION : INSERT
	        em.getTransaction().begin();
	        ELivre eli = new ELivre();
	        eli.setId(6);
	        eli.setNom("L'Art de la guerre");
	        eli.setAuteur("Sun Tzu");
	        em.persist(eli);
	        em.getTransaction().commit();
	        System.out.println(eli.getNom());
	     */ 
	        em.getTransaction().begin();
	        EClient ecl = new EClient();
	        ecl.setNom("DURANT");
	        ecl.setPrenom("Niko");
	        em.persist(ecl);
	        em.getTransaction().commit();
	        System.out.println(ecl.getNom() + " " + ecl.getPrenom());
	        
	        em.getTransaction().begin();
	        EBanque ebq = new EBanque();
	        ebq.setNom("HSBC");
	        em.persist(ebq);
	        em.getTransaction().commit();
	        System.out.println(ebq.getNom());
	        
	     
	        em.close();
	        
    	}
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(emf != null) emf.close();
    	}
        
    }
}


