package com.webapp.onlinebankspring.controller;

import java.net.http.HttpRequest;

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
import com.webapp.onlinebankspring.repository.AccountRepository;
import com.webapp.onlinebankspring.repository.CustomerRepository;
import com.webapp.onlinebankspring.repository.TransactionRepository;



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
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@GetMapping("openaccount")
	String register(@ModelAttribute("customer") Customer customer, Model model) {
//			model.addAttribute("customer", new Customer());
		return "openaccount";
		
	}
	
	@PostMapping("openaccount")
	String sign(@ModelAttribute("customer") Customer customer, Model model, RedirectAttributes redirect, HttpSession session) {
		try
		{

			if(customerRepository.findByEmail(customer.getEmail())==null){
			customerRepository.save(customer);
			Account account = new CheckingAccount(customer.getInitialDeposit());
//			System.out.println(account);
			customer.addAccount(account);
			accountRepository.save(account);
			session.setAttribute("customer", customer);
			
			redirect.addFlashAttribute("success", "Open Account Success");
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
	String postlogin(@ModelAttribute Customer customer, Model model, RedirectAttributes redirect, HttpSession session) {
			
			Customer thiscustomer = customerRepository.findByEmail(customer.getEmail());
			if(thiscustomer!=null&&thiscustomer.getPassword().equalsIgnoreCase(customer.getPassword())&&thiscustomer.getEmail().equalsIgnoreCase(customer.getEmail())) {
				redirect.addFlashAttribute("customer", thiscustomer);
				session.setAttribute("customer", customer);
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
	
	@GetMapping("profile")
	String profile(@ModelAttribute("customer") Customer customer, Model model) {
		
		
		return "profile";
		
	}

	@PostMapping("profile")
	String updateprofile(@ModelAttribute("customer") Customer customer, Model model, @RequestParam String firstnamefromform, @RequestParam String lastnamefromform, @RequestParam String emailfromform, 
			@RequestParam String passwordfromform, @RequestParam String telephonefromform, @RequestParam String streetfromform, @RequestParam String cityfromform,
			@RequestParam String statefromform, @RequestParam String zipfromform,  @RequestParam String overdraftProtectionfromform,
			HttpSession session, RedirectAttributes redirect) {
		
		try {
			Customer thiscustomer = customerRepository.findByEmail(customer.getEmail());
			
			if(firstnamefromform!="") {
				thiscustomer.setFirstName(firstnamefromform);}
			if(lastnamefromform!="") {thiscustomer.setLastName(lastnamefromform);}
			if(telephonefromform!="") {thiscustomer.setTelephoneNumber(telephonefromform);}
			if(emailfromform!="") {thiscustomer.setEmail(emailfromform);}
			if(passwordfromform!="") {thiscustomer.setPassword(passwordfromform);}
			if(streetfromform!="") {thiscustomer.setStreet(streetfromform);}
			if(cityfromform!="") {thiscustomer.setCity(cityfromform);}
			if(statefromform!="") {thiscustomer.setState(statefromform);}
			if(zipfromform!="") {thiscustomer.setZipCode(zipfromform);}
			boolean overdraftProtection2 = Boolean.parseBoolean(overdraftProtectionfromform);
			if(overdraftProtection2!=customer.getOverdraftProtect()) {customer.setOverdraftProtection(overdraftProtection2);}
			customer = thiscustomer;
			customerRepository.save(customer);
//			session.setAttribute("customer", null);
			session.setAttribute("customer", customer);
//			System.out.println("pause");
			redirect.addFlashAttribute("customer", customer);
			redirect.addFlashAttribute("updatesuccess", "Update Succeeded");
		} catch (Exception e) {
			model.addAttribute("updatefailed", "Update Failed");
		}
		
		
		return "redirect:/profile";
	}	
	
}
