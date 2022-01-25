package com.diginamic.D11.Biblio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diginamic.D11.Biblio.model.Client;
import com.diginamic.D11.Biblio.model.Emprunt;
import com.diginamic.D11.Biblio.model.Livre;
import com.diginamic.D11.Biblio.repository.JpaClient;
import com.diginamic.D11.Biblio.repository.JpaEmprunt;
import com.diginamic.D11.Biblio.repository.JpaLivre;

@SpringBootApplication
public class BiblioApplication implements ApplicationRunner
{
	@Autowired
	JpaClient gestionRepClient;
	@Autowired
	JpaLivre gestionRepLivre;
	@Autowired
	JpaEmprunt gestionRepEmprunt;

	public static void main(String[] args)
	{
		/**
		 * chargement du context Spring avec toutes les configurations par defaut de
		 * SpringBootApplication dépendant du POM.XML et du fichier
		 * application.properties
		 */
		SpringApplication.run(BiblioApplication.class, args);
	}

	/**
	 * Je vais surcharger le comportement par defaut de la méthode run du chargement
	 * de mon application SpringBoot
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		// -----> Entity Client instanciée
		Client c1 = new Client();
		gestionRepClient.delete(c1);
		gestionRepClient.findAll().forEach(c -> System.out.println(c));
		// Delete un client par son ID
		/**
		 * if(!grc.findById(5).isEmpty()) { grc.getListeEmpruntByClient(5).forEach(e ->
		 * gre.delete(e)); grc.deleteById(5); }
		 */
		// ------> Entity Livre instanciée
		Livre l1 = new Livre();
		l1.setAuteur("Grangé");
		l1.setTitre("La ligne noir");
		Livre l2 = new Livre();
		l2.setAuteur("Chattam");
		l2.setTitre("Le 5e règne");
		gestionRepLivre.save(l1);
		gestionRepLivre.save(l2);
		gestionRepLivre.findAll().forEach(l -> System.out.println(l));
		// ------> Entity Emprunt instanciée
		Emprunt e1 = new Emprunt();
		e1.setDelai(40);
		e1.setDatedebut(new Date());
		e1.setDatefin(new Date());
		e1.setClientE(c1);
		gestionRepEmprunt.findAll().forEach(e -> System.out.println(e));
		/**
		 * save me permet de créer ou de modifier une entity Client selon la valeur de
		 * la KP id : dans lotre exemple, id est à null donc on a une création.
		 */
		// -----> COMPO
	}
}
