package fr.diginamic.cge.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.diginamic.cge.jpa.model.Compo;
import fr.diginamic.cge.jpa.model.EClient;
import fr.diginamic.cge.jpa.model.EEmprunt;
import fr.diginamic.cge.jpa.model.ELivre;


/**
 * Hello world!
 *
 */
public class TestBibliotheque 
{
	
	public static void main( String[] args )
    {
    	EntityManagerFactory efm =null;
    	try 
    	{
    	/**
    	 * Choix de l'unitÃ© de persistence dans le fichier de Persistence.xml
    	 * "bddFILROUGE"
    	 */
    		
	        efm = Persistence.createEntityManagerFactory("bddFILROUGE");
	        EntityManager em = efm.createEntityManager();
	        
	        
	     /*
	        // FIND un livre par rapport à son ID
	        ELivre efo = em.find(ELivre.class, 1);
	        if(efo!=null) System.out.println(efo.getNom());
	        //ELivre efo1 = em.find(ELivre.class, 6);
	        //if(efo1!=null) System.out.println(efo1.getNom());
	        else System.out.println("NON TROUVE !");
	     */
	        
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
	        
	     
	      /*
	        // MODIFICATION il faut absolument le find pour le modifier
	        em.getTransaction().begin();
	        ELivre livre = em.find(ELivre.class, 5);
	        if(livre != null) {
	        livre.setNom("Du plaisir dans la cuisine");
	        em.merge(livre);
	        em.getTransaction().commit();
	        }
	        else 
	        {
	        	em.getTransaction().rollback();
	        }
	      */
	        
	        /*
	        TypedQuery<ELivre> queryLi = em.createQuery("SELECT l FROM ELivre l WHERE l.nom = 'Vingt mille lieues sous les mers'", ELivre.class);
	        ELivre l1 = queryLi.getResultList().get(0);
	       */
	        /*
	        TypedQuery<ELivre> queryLi = em.createQuery("SELECT l FROM ELivre l WHERE l.auteur = 'Sun Tzu'", ELivre.class);
	        ELivre li = queryLi.getResultList().get(0);
	       */
	        
	        
	       /* TypedQuery<ELivre> queryLi = em.createQuery("SELECT l FROM ELivre l ", ELivre.class);
	        
	        List<ELivre> li = queryLi.getResultList();
	        li.stream().forEach(a -> System.out.println(a.getNom() + " de " + a.getAuteur()));
	      */
	        
	       /* 
	        //MODIFICATION : DELETE
	        em.getTransaction().begin();
	        EFounisseur efosupp = em.find(EFounisseur.class, id);
	        em.remove(efosupp);
	        em.getTransaction().commit();
	      */
	        
	        
	        
	        /****     TP03     *****/
	        
	        
	        	/*****     Réalisez une requête qui permet d’extraire un emprunt et tous ses livres associés.     *****/
	        /*
	        TypedQuery<EEmprunt> queryLi = em.createQuery("SELECT e FROM EEmprunt e", EEmprunt.class);
    		List<EEmprunt> li = queryLi.getResultList();
    		li.stream().forEach(a -> System.out.println(a.getEmpruntLivre())); 
    		*/
	        
	        	/*****     Réalisez une requête qui permet d’extraire tous les emprunts d’un client donné.     *****/
    		/*
    		TypedQuery<EClient> queryLi = em.createQuery("SELECT e FROM EClient e", EClient.class);
    		List<EClient> li = queryLi.getResultList();
    		li.stream().forEach(a -> System.out.println(a.getEmprunts()));
  			*/
	        
	     
	        em.close();
	        
    	}
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(efm != null) efm.close();
    	}
        
    }
}


