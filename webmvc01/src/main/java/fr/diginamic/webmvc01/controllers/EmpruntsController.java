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

	private Optional<Emprunt> verifEmprunt(Integer idEmprunt) throws Exception
	{
		Optional<Emprunt> emp = er.findById(idEmprunt);
		if(emp.isEmpty())
		{
			/**
			 * Je déclenche l'exception ClientError package fr.diginamic.Rest01.exceptions;
			 * Exception Fonctionnelle = métier
			 */
			throw (new Exception("Client id :" + idEmprunt + " non trouvé !"));
		}
		return emp;
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

	@GetMapping("/update/{id}")
	public String updateT(@PathVariable("id")
	Integer pid, Model model) throws Exception
	{
		Emprunt emp = verifEmprunt(pid).get();
		List<Client> listesClients = (List<Client>) cr.findAll();
		List<Livre> listeLivres = (List<Livre>) lr.findAll();
		model.addAttribute("empruntUpdateForm", new Emprunt());
		model.addAttribute("Titre", "Modifier un emprunt");
		model.addAttribute("titre", "Gestion Bibliothèque");
		model.addAttribute("listeClients", listesClients);
		model.addAttribute("listeLivres", listeLivres);
		model.addAttribute("emprunt", emp);
		return "emprunts/updateEmprunts";
	}

	@PostMapping("/update/{id}")
	public String update(@PathVariable("id")
	Integer pid, @Valid @ModelAttribute("empruntUpdateForm")
	Emprunt empruntUpdateForm) throws Exception
	{
		Emprunt emp = verifEmprunt(pid).get();
		er.findLivreByEmprunt(emp).forEach(l ->
		{
			l.getEmpruntLivres().remove(emp);
			lr.save(l);
		});
		emp.setDatedebut(empruntUpdateForm.getDatedebut());
		emp.setDatefin(empruntUpdateForm.getDatefin());
		emp.setDelai(empruntUpdateForm.getDelai());
		emp.setClientE(empruntUpdateForm.getClientE());
		emp.setLivresE(empruntUpdateForm.getLivresE());
		er.save(emp);
		empruntUpdateForm.getLivresE().forEach(l ->
		{
			l.getEmpruntLivres().add(emp);
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
		er.findLivreByEmprunt(e.get()).forEach(l ->
		{
			l.getEmpruntLivres().remove(e.get());
			lr.save(l);
		});
		er.deleteById(pid);
		return "redirect:/emprunt/emprunts";
	}
}
