package com.webapp.onlinebankspring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webapp.onlinebankspring.model.*;
import com.webapp.onlinebankspring.repository.CustomerRepository;



@Controller
@SessionAttributes("customer")
public class CustomerController
{
	@ModelAttribute("customer")
	public Customer customer() {
	    return new Customer();
	}
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@GetMapping("openaccount")
	String register(@ModelAttribute("customer") Customer customer, Model model) {
//			model.addAttribute("customer", new Customer());
		return "openaccount";
		
	}
	
	@PostMapping("openaccount")
	String sign(@ModelAttribute("customer") Customer customer, Model model, RedirectAttributes redirect) {
		try
		{

			if(customerRepository.findByEmail(customer.getEmail())==null){
			customerRepository.save(customer);
			redirect.addFlashAttribute("success", "Registration Success");
			return "redirect:/index3";
			}else {
				redirect.addFlashAttribute("error1", "User Already Exists, did not register this user");
				System.out.println("open account failed");
				return "redirect:/openaccount";
			}
		} catch (Exception e)
		{
			redirect.addFlashAttribute("error2", "Error saving new account, did not register this user");
			System.out.println("open account failed");
			e.printStackTrace();
			return "redirect:/openaccount";
		}
		
		
	}
	
	@GetMapping("login")
	String getlogin(@ModelAttribute("customer") Customer customer, Model model) {
//			model.addAttribute("customer", new Customer());
		return "login";
		
	}
	
	@PostMapping("login")
	String postlogin(@ModelAttribute Customer customer, Model model, RedirectAttributes redirect) {
			
			Customer thiscustomer = customerRepository.findByEmail(customer.getEmail());
			if(thiscustomer!=null&&thiscustomer.getPassword().equalsIgnoreCase(customer.getPassword())&&thiscustomer.getEmail().equalsIgnoreCase(customer.getEmail())) {
				redirect.addFlashAttribute("customer", thiscustomer);
//				model.addAttribute("customer", thiscustomer);
				redirect.addFlashAttribute("loginsuccess",  "Successful Login");
				return "redirect:/index3";
		
			}else {
				redirect.addFlashAttribute("loginerror",  "Invalid Credentials");
				return "redirect:/index";
			}
		
	}
	
	@GetMapping("index3")
	String getindex3(@ModelAttribute Customer customer, Model model) {
//			model.addAttribute("customer", new Customer());
		return "index3";
		
	}
	
	@GetMapping("signout")
	String getsignout(@ModelAttribute Customer customer, Model model, HttpSession session) {
			model.addAttribute("customer", new Customer());
			session.setAttribute("customer", null);
			session.invalidate();
		return "redirect:/index";
		
	}

	
}
