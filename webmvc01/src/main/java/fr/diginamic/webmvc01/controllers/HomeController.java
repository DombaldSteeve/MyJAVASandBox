package fr.diginamic.webmvc01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController
{
	public HomeController()
	{
	}

	@GetMapping
	public String home(Model model)
	{
		String dtitre = "Bonjour Toi ;) et bienvenue dans le gestionnaire bibliothèque !";
		model.addAttribute("Titre", dtitre);
		model.addAttribute("titre", "Gestion Bibliothèque");
		return "home";
	}
}
