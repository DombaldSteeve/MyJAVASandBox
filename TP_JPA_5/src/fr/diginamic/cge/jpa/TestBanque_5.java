package fr.diginamic.cge.jpa;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import fr.diginamic.cge.jpa.model.EClient;
import fr.diginamic.cge.jpa.model.AssuranceVie;
import fr.diginamic.cge.jpa.model.ECompte;
import fr.diginamic.cge.jpa.model.EOperation;
import fr.diginamic.cge.jpa.model.LivretA;
import fr.diginamic.cge.jpa.model.Virement;


/**
 * Hello world!
 *
 */
public class TestBanque_5 
{
	
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
	        EClient ecl1 = new EClient();
	        EClient ecl2 = new EClient();
	        ECompte eco1 = new ECompte();
	        ECompte eco2 = new ECompte();
	        LivretA cla = new LivretA();
	        AssuranceVie asv = new AssuranceVie();
	        Virement vrm = new Virement();
	        EOperation eop = new EOperation();
	        ecl1.setNom("DUPONT");
	        ecl1.setPrenom("Erik");
	        ecl2.setNom("DURAND");
	        ecl2.setPrenom("Niko");
	        eco1.setIdclient(ecl1);
	        eco2.setIdclient(ecl2);
	        eco1.setNumero("1");
	        eco2.setNumero("1");
	        cla.setIdclient(ecl2);
	        cla.setNumero("2");
	        asv.setIdclient(ecl2);
	        asv.setNumero("2");
	        vrm.setMontant(800.20);
	        vrm.setIdcompte(eco1);
	        eop.setMontant(225.33);
	        eop.setMotif("Facture");
	        eop.setIdcompte(eco2);
	        em.persist(ecl1);
	        em.persist(ecl2);
	        em.persist(eco1);
	        em.persist(eco2);
	        em.persist(cla);
	        em.persist(asv);
	        em.persist(vrm);
	        em.persist(eop);
	        em.getTransaction().commit();
	        System.out.println(ecl1.getNom() + " " + ecl1.getPrenom());
	        System.out.println();
	        System.out.println(ecl2.getNom() + " " + ecl2.getPrenom());
	        System.out.println();
	        System.out.println(eco1.getNumero());
	        System.out.println();
	        System.out.println(cla.getId());
	        System.out.println();
	        System.out.println(asv.getId());
	        System.out.println();
	        System.out.println(vrm.getId() + " " + vrm.getMontant());
	        System.out.println();
	        System.out.println(eop.getMotif() + " " + eop.getMontant());
	        
	        em.close();
	        
    	}
    	catch(Exception e) {e.printStackTrace();}
    	finally {
    		if(emf != null) emf.close();
    	}
        
    }
}


