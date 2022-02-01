package com.diginamic.bibliorest.bibliorest.controllerWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeControllerWeb
{
	@GetMapping
	public String welcome()
	{
		return "home";
	}
}
