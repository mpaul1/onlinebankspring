package com.webapp.onlinebankspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.webapp.onlinebankspring.model.Customer;

@Controller
@SessionAttributes("customer")
public class MainController
{
	@ModelAttribute("customer")
	public Customer customer() {
	    return new Customer();
	}

	@GetMapping("/")
	String root(@ModelAttribute("customer") Customer customer, Model model) {
		model.addAttribute("customer", new Customer());
		return "index";
	}
	
	@GetMapping("index")
	String index(@ModelAttribute("customer") Customer customer, Model model) {
		model.addAttribute("customer", new Customer());
		return "index";
	}
	
	@GetMapping("about")
	String about(@ModelAttribute("customer") Customer customer, Model model) {
		model.addAttribute("customer", new Customer());
		return "about";
	}
	
	@GetMapping("contact")
	String contact(@ModelAttribute("customer") Customer customer, Model model) {
		model.addAttribute("customer", new Customer());
		return "contact";
		
	}
	
	@GetMapping("services")
	String services(@ModelAttribute("customer") Customer customer, Model model) {
		model.addAttribute("customer", new Customer());
		return "redirect:/index";
		
	}

	
	
}
