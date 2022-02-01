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
import fr.diginamic.webmvc01.entities.Emprunt;
import fr.diginamic.webmvc01.entities.Livre;
import fr.diginamic.webmvc01.repository.CrudClientRepo;
import fr.diginamic.webmvc01.repository.CrudEmpruntRepo;
import fr.diginamic.webmvc01.repository.CrudLivreRepo;

@Controller
@RequestMapping("/emprunt")
public class EmpruntsController
{
	@Autowired
	CrudEmpruntRepo er;
	@Autowired
	CrudLivreRepo lr;
	@Autowired
	CrudClientRepo cr;

	public EmpruntsController()
	{
	}

	@GetMapping("/emprunts")
	public String findall(Model model)
	{
		model.addAttribute("emprunts", (List<Emprunt>) er.findAll());
		model.addAttribute("Titre", "Liste des emprunts");
		model.addAttribute("titre", "Gestion Bibliothèque");
		model.addAttribute("er", er);
		return "emprunts/listeEmprunts";
	}

	@GetMapping("/add")
	public String addT(Model model)
	{
		List<Client> listesClients = (List<Client>) cr.findAll();
		List<Livre> listeLivres = (List<Livre>) lr.findAll();
		model.addAttribute("empruntForm", new Emprunt());
		model.addAttribute("Titre", "Ajouter un emprunt");
		model.addAttribute("titre", "Gestion Bibliothèque");
		model.addAttribute("listeClients", listesClients);
		model.addAttribute("listeLivres", listeLivres);
		return "emprunts/addEmprunts";
	}

	@PostMapping("/add")
	public String add(Model model, @Valid @ModelAttribute("empruntForm")
	Emprunt empruntForm)
	{
		er.save(empruntForm);
		empruntForm.getLivresE().forEach(l ->
		{
			l.getEmpruntLivres().add(empruntForm);
			lr.save(l);
		});
		return "redirect:/emprunt/emprunts";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")
	Integer pid) throws Exception
	{
		Optional<Emprunt> e = er.findById(pid);
		if(e.isEmpty())
		{
			/**
			 * Je déclenche l'exception ClientError package fr.diginamic.Rest01.exceptions;
			 * Exception Fonctionnelle = métier
			 */
			throw (new Exception("Emprunt id :" + pid + " non trouvé !"));
		}
		er.findByLivre(e.get()).forEach(l ->
		{
			l.getEmpruntLivres().remove(e.get());
			lr.save(l);
		});
		er.deleteById(pid);
		return "redirect:/emprunt/emprunts";
	}
}
