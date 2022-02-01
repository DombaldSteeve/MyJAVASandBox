package com.diginamic.bibliorest.bibliorest.controllerRest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.bibliorest.bibliorest.exceptions.ErreurClient;
import com.diginamic.bibliorest.bibliorest.exceptions.ErreurEmprunt;
import com.diginamic.bibliorest.bibliorest.model.Client;
import com.diginamic.bibliorest.bibliorest.model.Emprunt;
import com.diginamic.bibliorest.bibliorest.repository.JpaClient;
import com.diginamic.bibliorest.bibliorest.repository.JpaEmprunt;
import com.diginamic.bibliorest.bibliorest.repository.JpaLivre;

@RestController
@CrossOrigin
@RequestMapping("api/emprunts")
public class EmpruntController
{
	@Autowired
	JpaClient grc;
	@Autowired
	JpaEmprunt gre;
	@Autowired
	JpaLivre grl;

	/**
	 * 
	 * @return Liste des emprunts (convertis les données Entity en JSON)
	 */
	@GetMapping
	public Iterable<Emprunt> getAll()
	{// renvois la liste des clients
		return gre.findAll();
	}

	private void verifEmprunt(Integer pid) throws ErreurEmprunt
	{
		if(gre.findById(pid).isEmpty())
		{
			throw new ErreurEmprunt("N° Emprunt : " + pid + "non trouvé ! ");
		}
	}

	/**
	 * Crée l'emprunt
	 * 
	 * @param emprunt
	 * @return
	 */
	@PostMapping
	public Emprunt create(@RequestBody
	Emprunt emprunt)
	{
		return gre.save(emprunt);
	}

	/**
	 * Dans postman : api/clients/1 (ou un autre ID)
	 * 
	 * @param pid
	 * @return le client trouvé par son ID
	 * @throws ErreurClient
	 * @throws ErreurEmprunt
	 */
	@GetMapping("{id}")
	public Optional<Client> getOne(@PathVariable("id")
	Integer pid) throws ErreurClient, ErreurEmprunt
	{
		verifEmprunt(pid);
		return grc.findById(pid);
	}

	/**
	 * Dans postman : api/clients/22
	 * 
	 * @param pid supprime le client 22
	 * @throws ErreurEmprunt
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")
	Integer pid) throws ErreurClient, ErreurEmprunt
	{
		verifEmprunt(pid);
		// Gerer la suppression de façon automatique des emprunts
		grc.getEmpruntByClient(pid).forEach(e ->
		{ // suppression des liens avec compo
			gre.findByLivre(e).forEach(l ->
			{
				l.getEmpruntLivres().remove(e);
				grl.save(l);
			});
			// supp de l'emprunt possible
			gre.delete(e);
		});
		// Supp du client possible
		grc.deleteById(pid);
	}

	/**
	 * Update le client
	 * 
	 * @param client
	 * @param pid
	 * @return
	 * @throws ErreurEmprunt
	 */
	@PutMapping("{id}")
	public Client update(@RequestBody
	Client client, @PathVariable("id")
	Integer pid) throws ErreurClient, ErreurEmprunt
	{
		verifEmprunt(pid);
		if(pid != client.getId())
		{
			throw new ErreurClient(
					"N° de client : " + pid + "passé en variable est différent du contenu JSON : " + client.getId());
		}
		return grc.save(client);
	}
}
