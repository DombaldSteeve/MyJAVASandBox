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

import fr.diginamic.webmvc01.entities.Livre;
import fr.diginamic.webmvc01.exceptions.ErreurClient;
import fr.diginamic.webmvc01.repository.CrudLivreRepo;

@Controller
@RequestMapping("/livre")
public class LivresController
{
	@Autowired
	CrudLivreRepo lr;

	public LivresController()
	{
	}

	@GetMapping("/livres")
	public String findall(Model model)
	{
		model.addAttribute("livres", (List<Livre>) lr.findAll());
		model.addAttribute("Titre", "Liste des livres");
		model.addAttribute("titre", "Gestion Bibliothèque");
		return "livres/listeLivres";
	}

	@GetMapping("/add")
	public String addT(Model model)
	{
		model.addAttribute("livreForm", new Livre());
		model.addAttribute("Titre", "Ajouter un livre");
		model.addAttribute("titre", "Gestion Bibliothèque");
		return "livres/addLivres";
	}

	@PostMapping("/add")
	public String add(Model model, @Valid @ModelAttribute("livreForm")
	Livre livreForm)
	{
		lr.save(livreForm);
		return "redirect:/livre/livres";
	}

	@GetMapping("/update")
	public String updateT(Model model)
	{
		List<Livre> listesLivres = (List<Livre>) lr.findAll();
		model.addAttribute("livreUpdateForm", new Livre());
		model.addAttribute("Titre", "Modifier un livre");
		model.addAttribute("titre", "Gestion Bibliothèque");
		model.addAttribute("livres", listesLivres);
		return "livres/updateLivres";
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("livreUpdateForm")
	Livre livre) throws ErreurClient
	{
		lr.save(livre);
		return "redirect:/livre/livres";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")
	Integer pid) throws Exception
	{
		Optional<Livre> c = lr.findById(pid);
		if(c.isEmpty())
		{
			/**
			 * Je déclenche l'exception ClientError package fr.diginamic.Rest01.exceptions;
			 * Exception Fonctionnelle = métier
			 */
			throw (new Exception("Livre id :" + pid + " non trouvé !"));
		}
		lr.deleteById(pid);
		return "redirect:/livre/livres";
	}
}
