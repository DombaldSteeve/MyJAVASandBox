package fr.diginamic.cge.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.diginamic.cge.jpa.enumeration.Genre;
import fr.diginamic.cge.jpa.model.EArticle;
import fr.diginamic.cge.jpa.model.EFour01;
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
	        
	        /** on crée un four01
	         * 
	         */
	        em.getTransaction().begin();
	        EFour01 ef01 = new EFour01();
	        ef01.setNom("MARTIN");
	        ef01.setGenre(Genre.Mme);
	        em.persist(ef01);
	        EFour01 ef02 = new EFour01();
	        ef02.setNom("GERMAIN");
	        ef02.setGenre(Genre.M);
	        em.persist(ef02);
	        em.getTransaction().commit();
	   
	        /**  FIN  **/
	        /**
	        EFounisseur efo = em.find(EFounisseur.class, 1);
	        if(efo!=null) System.out.println(efo.getNom());
	        EFounisseur efo1 = em.find(EFounisseur.class, 6);
	        if(efo1!=null) System.out.println(efo1.getNom());
	        else System.out.println("NON TROUVE !");
	        */
    		
    		/*
	        //CREATION : INSERT FOURNISSEUR
	        em.getTransaction().begin();
	        EFournisseur efo = new EFournisseur();
	        efo.setNom("FOURNISSEUR LIE 2");
	        em.persist(efo);
	        em.getTransaction().commit();
	        System.out.println(efo.getId());
	        
	        // CREATION : INSERT ARTICLE et on va le lier à un fournisseur : efo
	        em.getTransaction().begin();
	        EArticle art = new EArticle();
	        art.setReference("CGE 02");
	        art.setDesignation("FORMATION JPA 2");
	        art.setPrix(1500.23);
	        art.setFourArticle(efo); // lien entre EArticle et EFournisseur
	        /**
	         * efo doit exister en tant qu'entité persistante
	         * dans la BDD
	         */
	        /*
	        em.persist(art); // PERSIST = INSERT = AJOUT
	        em.getTransaction().commit();
	        
	        /*
	        /**
	         * récuperation de l'id calculé par le SGBBDR
	         */
	        
	        /*
	        int idart = art.getId();
	        EArticle art1 = em.find(EArticle.class, idart);
	        //demande la persistance dans la BDD
	        if(art1 != null) {
	        	System.out.println("Mon fournisseur est :" + art1.getFourArticle().getNom());
	        } else {
	        	System.out.println("Article non trouvé !");
	        }
	        */
	        
	       /**
	        * Lors du commit le JPA vérifie avec le SGBDR l'intégrité des données et donc des liens 
	        * 
	        */
	        
	        
	        /*
	        //MODIFICATION : UPDATE
	        int id =efo.getId(); 
	        em.getTransaction().begin();
	        EFournisseur efomod = em.find(EFournisseur.class, id);
	        efomod.setNom("AUTRES");
	        em.merge(efomod);
	        em.getTransaction().commit();
	        
	        //MODIFICATION : DELETE
	        em.getTransaction().begin();
	        EFournisseur efosupp = em.find(EFournisseur.class, id);
	        em.remove(efosupp);
	        em.getTransaction().commit();
	        */
	        
	        em.close();
 
    	}
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(efm != null) efm.close();
    	}
        
    }
}
