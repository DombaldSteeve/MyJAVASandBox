package com.diginamic.bibliorest.bibliorest.controllerRest;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
import com.diginamic.bibliorest.bibliorest.model.Client;
import com.diginamic.bibliorest.bibliorest.repository.JpaClient;
import com.diginamic.bibliorest.bibliorest.repository.JpaEmprunt;
import com.diginamic.bibliorest.bibliorest.repository.JpaLivre;

@RestController
@CrossOrigin
@RequestMapping("api/clients")
public class ClientController
{
	@Autowired
	JpaClient grc;
	@Autowired
	JpaEmprunt gre;
	@Autowired
	JpaLivre grl;
	private String message;

	/**
	 * 
	 * @return Liste des clients (convertis les données Entity en JSON)
	 */
	@GetMapping
	public Iterable<Client> getAll()
	{// renvois la liste des clients
		return grc.findAll();
	}

	private void verifClient(Integer pid) throws ErreurClient
	{
		if(grc.findById(pid).isEmpty())
		{
			throw new ErreurClient("N° Client : " + pid + "non trouvé ! ");
		}
	}

	/**
	 * Créer le client
	 * 
	 * @param client
	 * @return
	 */
	@PostMapping
	public Client create(@Valid @RequestBody
	Client client, BindingResult result) throws ErreurClient
	{
		if(result.hasErrors())
		{
			message = "";
			result.getFieldErrors().forEach(e ->
			{
				message += e.getField() + "-" + e.getDefaultMessage() + "*";
			});
			throw new ErreurClient(message);
		}
		return grc.save(client);
	}

	/**
	 * Dans postman : api/clients/1 (ou un autre ID)
	 * 
	 * @param pid
	 * @return le client trouvé par son ID
	 * @throws ErreurClient
	 */
	@GetMapping("{id}")
	public Optional<Client> getOne(@PathVariable("id")
	Integer pid) throws ErreurClient
	{
		verifClient(pid);
		return grc.findById(pid);
	}

	/**
	 * Dans postman : api/clients/22
	 * 
	 * @param pid supprime le client 22
	 */
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id")
	Integer pid) throws ErreurClient
	{
		verifClient(pid);
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
	 */
	@PutMapping("{id}")
	public Client update(@RequestBody
	Client client, @PathVariable("id")
	Integer pid) throws ErreurClient
	{
		verifClient(pid);
		if(pid != client.getId())
		{
			throw new ErreurClient(
					"N° de client : " + pid + "passé en variable est différent du contenu JSON : " + client.getId());
		}
		return grc.save(client);
	}
}
