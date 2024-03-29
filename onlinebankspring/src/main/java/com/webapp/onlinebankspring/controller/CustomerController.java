package com.webapp.onlinebankspring.controller;

import java.net.http.HttpRequest;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webapp.onlinebankspring.model.*;
import com.webapp.onlinebankspring.repository.AccountRepository;
import com.webapp.onlinebankspring.repository.CustomerRepository;
import com.webapp.onlinebankspring.repository.TransactionRepository;
import com.webapp.onlinebankspring.service.TransferManager;

@Controller
@SessionAttributes("customer")
public class CustomerController {
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
	String sign(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model,
			RedirectAttributes redirect, HttpSession session) {

		if (result.hasErrors()) {
			System.out.println(result);
			return "openaccount";
		} else {
			try {

				if (customerRepository.findByEmail(customer.getEmail()) == null) {
					customerRepository.save(customer);
					Account account = new CheckingAccount();
					customer.addAccount(account);
					accountRepository.save(account);
					Customer housewithdrawalcustomer = customerRepository.findByEmail("2@e.c");
					Optional<Account> housedwithdrawalaccount = accountRepository.findById(4L);
					TransferManager.Transfer(customerRepository, accountRepository, transactionRepository,
							housewithdrawalcustomer, housedwithdrawalaccount.get(), customer, account,
							customer.getInitialDeposit(), "Initial Deposit");
					session.setAttribute("customer", customer);

					redirect.addFlashAttribute("newaccountsuccess", "Open Account Success");
					return "redirect:/index3";
				} else {
					redirect.addFlashAttribute("error1", "User Already Exists, did not register this user");
					System.out.println("open account failed");
					return "redirect:/openaccount";
				}
			} catch (Exception e) {
				redirect.addFlashAttribute("error2", "Error saving new account, did not register this user");
				System.out.println("open account failed");
				e.printStackTrace();
				return "redirect:/openaccount";
			}

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
		if (thiscustomer != null && thiscustomer.getPassword().equalsIgnoreCase(customer.getPassword())
				&& thiscustomer.getEmail().equalsIgnoreCase(customer.getEmail())) {
			redirect.addFlashAttribute("customer", thiscustomer);
			session.setAttribute("customer", customer);
			redirect.addFlashAttribute("loginsuccess", "Successful Login");
			return "redirect:/index3";

		} else {
			redirect.addFlashAttribute("loginerror", "Invalid Credentials");
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
		session.setAttribute("accounttransactions", null);
		session.setAttribute("bankaccount", null);
		session.invalidate();
		return "redirect:/index";

	}

	@GetMapping("profile")
	String profile(@ModelAttribute("customer") Customer customer, Model model) {

		return "profile";

	}

	@PostMapping("profile")
	String updateprofile(@ModelAttribute("customer") Customer customer, Model model,
			@RequestParam String firstnamefromform, @RequestParam String lastnamefromform,
			@RequestParam String emailfromform, @RequestParam String passwordfromform,
			@RequestParam String telephonefromform, @RequestParam String streetfromform,
			@RequestParam String cityfromform, @RequestParam String statefromform, @RequestParam String zipfromform,
			@RequestParam String overdraftProtectionfromform, HttpSession session, RedirectAttributes redirect) {

		try {
			Customer thiscustomer = customerRepository.findByEmail(customer.getEmail());

			if (firstnamefromform != "") {
				thiscustomer.setFirstName(firstnamefromform);
			}
			if (lastnamefromform != "") {
				thiscustomer.setLastName(lastnamefromform);
			}
			if (telephonefromform != "") {
				thiscustomer.setTelephoneNumber(telephonefromform);
			}
			if (emailfromform != "") {
				thiscustomer.setEmail(emailfromform);
			}
			if (passwordfromform != "") {
				thiscustomer.setPassword(passwordfromform);
			}
			if (streetfromform != "") {
				thiscustomer.setStreet(streetfromform);
			}
			if (cityfromform != "") {
				thiscustomer.setCity(cityfromform);
			}
			if (statefromform != "") {
				thiscustomer.setState(statefromform);
			}
			if (zipfromform != "") {
				thiscustomer.setZipCode(zipfromform);
			}
			boolean overdraftProtection2 = Boolean.parseBoolean(overdraftProtectionfromform);
			if (overdraftProtection2 != customer.getOverdraftProtect()) {
				customer.setOverdraftProtection(overdraftProtection2);
			}
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

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
}
