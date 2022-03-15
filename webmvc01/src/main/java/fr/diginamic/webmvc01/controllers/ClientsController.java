package fr.diginamic.webmvc01.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.diginamic.webmvc01.entities.Client;
import fr.diginamic.webmvc01.exceptions.ErreurClient;
import fr.diginamic.webmvc01.repository.CrudClientRepo;
import fr.diginamic.webmvc01.repository.CrudEmpruntRepo;
import fr.diginamic.webmvc01.repository.CrudLivreRepo;

@Controller
@RequestMapping("/client")
public class ClientsController
{
	@Autowired
	CrudClientRepo cr;
	@Autowired
	CrudEmpruntRepo er;
	@Autowired
	CrudLivreRepo lr;

	public ClientsController()
	{
	}

	@GetMapping
	public Iterable<Client> getAll()
	{// renvois la liste des clients
		return cr.findAll();
	}

	private void verifClient(Integer pid) throws ErreurClient
	{
		if(cr.findById(pid).isEmpty())
		{
			throw new ErreurClient("N° Client : " + pid + " non trouvé ! ");
		}
	}

	@GetMapping("/clients")
	public String findall(Model model)
	{
		model.addAttribute("clients", (List<Client>) cr.findAll());
		model.addAttribute("Titre", "Liste des clients");
		model.addAttribute("titre", "Gestion Bibliothèque");
		return "clients/listeClients";
	}

	@GetMapping("/add")
	public String addT(Model model)
	{
		model.addAttribute("clientForm", new Client());
		model.addAttribute("Titre", "Ajout client");
		model.addAttribute("titre", "Gestion Bibliothèque");
		return "clients/addClients";
	}

	@PostMapping("/add")
	public String add(Model model, @Valid @ModelAttribute("clientForm")
	Client clientForm)
	{
		cr.save(clientForm);
		return "redirect:/client/clients";
	}

	@GetMapping("/update")
	public String updateT(Model model)
	{
		List<Client> listesClients = (List<Client>) cr.findAll();
		model.addAttribute("clientUpdateForm", new Client());
		model.addAttribute("Titre", "Modifier un client");
		model.addAttribute("titre", "Gestion Bibliothèque");
		model.addAttribute("clients", listesClients);
		return "clients/updateClients";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("clientUpdateForm")
	Client client) throws ErreurClient
	{
		cr.save(client);
		return "redirect:/client/clients";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")
	Integer pid) throws Exception
	{
		Optional<Client> c = cr.findById(pid);
		if(c.isEmpty())
		{
			/**
			 * Je déclenche l'exception ClientError package fr.diginamic.Rest01.exceptions;
			 * Exception Fonctionnelle = métier
			 */
			throw (new Exception("Client id :" + pid + " non trouvé !"));
		}
		cr.deleteById(pid);
		return "redirect:/client/clients";
	}
}
