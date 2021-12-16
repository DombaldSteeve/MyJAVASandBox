package fr.diginamic.cge.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.cge.jpa.model.EFournisseur;

/**
 * Hello world!
 *
 */
public class App 
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
	        /**
	        EFounisseur efo = em.find(EFounisseur.class, 1);
	        if(efo!=null) System.out.println(efo.getNom());
	        EFounisseur efo1 = em.find(EFounisseur.class, 6);
	        if(efo1!=null) System.out.println(efo1.getNom());
	        else System.out.println("NON TROUVE !");
	        */
	        //CREATION : INSERT
	        em.getTransaction().begin();
	        EFounisseur efo = new EFounisseur();
	        efo.setNom("MON FOURNISSEUR");
	        em.persist(efo);
	        em.getTransaction().commit();
	        System.out.println(efo.getId());
	        
	        //MODIFICATION : UPDATE
	        int id =efo.getId(); 
	        em.getTransaction().begin();
	        EFounisseur efomod = em.find(EFounisseur.class, id);
	        efomod.setNom("AUTRES");
	        em.merge(efomod);
	        em.getTransaction().commit();
	        
	        //MODIFICATION : DELETE
	        em.getTransaction().begin();
	        EFounisseur efosupp = em.find(EFounisseur.class, id);
	        em.remove(efosupp);
	        em.getTransaction().commit();
	        
	        em.close();
	        
	        
	        
	        	
        
    	}
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(efm != null) efm.close();
    	}
        
    }
}
