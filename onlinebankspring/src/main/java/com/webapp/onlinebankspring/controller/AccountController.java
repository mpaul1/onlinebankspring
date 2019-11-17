package com.webapp.onlinebankspring.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webapp.onlinebankspring.model.Account;
import com.webapp.onlinebankspring.model.CheckingAccount;
import com.webapp.onlinebankspring.model.Customer;
import com.webapp.onlinebankspring.model.HouseAccount;
import com.webapp.onlinebankspring.model.SavingsAccount;
import com.webapp.onlinebankspring.repository.AccountRepository;
import com.webapp.onlinebankspring.repository.CustomerRepository;
import com.webapp.onlinebankspring.repository.TransactionRepository;
import com.webapp.onlinebankspring.service.TransactionAsObjects;
import com.webapp.onlinebankspring.service.TransferManager;
import com.webapp.onlinebankspring.model.Transaction;

import antlr.collections.List;

@Controller
@SessionAttributes({ "customer", "account", "accounttransactions" })
public class AccountController {

	@ModelAttribute("customer")
	public Customer customer() {
		return new Customer();
	}

	@ModelAttribute("account")
	public Account account() {
		Account account = null;
		return account;
	}

	@ModelAttribute("accounttransactions")
	public ArrayList<TransactionAsObjects> accounttransactions(){
		ArrayList<TransactionAsObjects> accounttransactions = new ArrayList<TransactionAsObjects>();
		return accounttransactions;
	}

	Date thirtydaysagodate() {
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -31);
		Date thirtydaysago = c.getTime();
		return thirtydaysago;
	}

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@GetMapping("account")
	String getaccount(@ModelAttribute("customer") Customer customer, @ModelAttribute("account") Account account, 
			@ModelAttribute("accounttransactions") ArrayList<TransactionAsObjects> accounttransactions,	Model model, @RequestParam String accountnumber, HttpSession session) {
		session.removeAttribute("accounttransactions");
		session.removeAttribute("account");
		
		account = accountRepository.findbyAccountNumber(Long.parseLong(accountnumber));
		model.addAttribute("account", account);
		session.setAttribute("account", account);

//		ArrayList<Transaction> accounttransactions = new ArrayList<Transaction>();
//		accounttransactions = transactionRepository.findByAccountIds(Long.parseLong(accountnumber));
////		accounttransactions = transactionRepository.findByAccountIdsWithin30Days(Long.parseLong(accountnumber),thirtydaysagodate());
//		for (Transaction t : accounttransactions) {
//			System.out.println(t);
//		}
//		session.setAttribute("stringaccounttransactions", accounttransactions);

//		ArrayList<TransactionAsObjects> objectaccounttransactions = new ArrayList<TransactionAsObjects>();

		ArrayList<TransactionAsObjects>  objectaccounttransactions = TransactionAsObjects.transactionsAsObjects(customerRepository, accountRepository, transactionRepository,
				accountnumber);
//		for (TransactionAsObjects t : objectaccounttransactions) {
//			System.out.println(t);
//		}
		accounttransactions = objectaccounttransactions;
		model.addAttribute("accounttransactions", accounttransactions);
		session.setAttribute("accounttransactions", accounttransactions);

		return "account";

	}

	@PostMapping("makedeposit")
	String makedeposit(@ModelAttribute("customer") Customer customer, @ModelAttribute("account") Account account,
			Model model, @RequestParam String accountnumber, @RequestParam String deposit, HttpSession session) {
		Customer housewithdrawalcustomer = customerRepository.findByEmail("2@e.c");
		Optional<Account> housedwithdrawalaccount = accountRepository.findById(4L);
		TransferManager.Transfer(customerRepository, accountRepository, transactionRepository, housewithdrawalcustomer,
				housedwithdrawalaccount.get(), customer, account, Long.parseLong(deposit), "Deposit");
		String accounturl = "?accountnumber="+accountnumber;
		return "redirect:/account"+accounturl;
	}
	
	@PostMapping("withdrawal")
	String withdrawal(@ModelAttribute("customer") Customer customer, @ModelAttribute("account") Account account,
			Model model, @RequestParam String accountnumber, @RequestParam String amount, HttpSession session, RedirectAttributes redirect) {
		Customer housewithdrawalcustomer = customerRepository.findByEmail("1@e.c");
		Optional<Account> housedwithdrawalaccount = accountRepository.findById(2L);
		TransferManager.Transfer(customerRepository, accountRepository, transactionRepository, customer, account,housewithdrawalcustomer,
				housedwithdrawalaccount.get(), Long.parseLong(amount), "Withdrawal");
		String accounturl = "?accountnumber="+accountnumber;
		return "redirect:/account"+accounturl;
	}

	@GetMapping("addaccount")
	String addaccount(@ModelAttribute("customer") Customer customer, Model model) {
//			model.addAttribute("customer", new Customer());
		return "addaccount";

	}

	@PostMapping("addaccount")
	String postaddaccount(@ModelAttribute("customer") Customer customer, Model model, @RequestParam String personid,
			@RequestParam String deposit, @RequestParam String typeofaccount, HttpSession session,
			RedirectAttributes redirect) {

		try {
			Customer thiscustomer = customerRepository.findByEmail(customer.getEmail());

			if (typeofaccount.equalsIgnoreCase("Checking")) {
				Account account = new CheckingAccount();
				customer.addAccount(account);
				accountRepository.save(account);
				Customer housewithdrawalcustomer = customerRepository.findByEmail("2@e.c");
				Optional<Account> housedwithdrawalaccount = accountRepository.findById(4L);
				TransferManager.Transfer(customerRepository, accountRepository, transactionRepository,
						housewithdrawalcustomer, housedwithdrawalaccount.get(), customer, account,
						Long.parseLong(deposit), "Initial Deposit");
			}
			if (typeofaccount.equalsIgnoreCase("Savings")) {
				Account account = new SavingsAccount();
				customer.addAccount(account);
				accountRepository.save(account);
				Customer housewithdrawalcustomer = customerRepository.findByEmail("2@e.c");
				Optional<Account> housedwithdrawalaccount = accountRepository.findById(4L);
				TransferManager.Transfer(customerRepository, accountRepository, transactionRepository,
						housewithdrawalcustomer, housedwithdrawalaccount.get(), customer, account,
						Long.parseLong(deposit), "Initial Deposit");
			}
			if (typeofaccount.equalsIgnoreCase("House")) {
				Account account = new HouseAccount();
				customer.addAccount(account);
				accountRepository.save(account);
				Customer housewithdrawalcustomer = customerRepository.findByEmail("2@e.c");
				Optional<Account> housedwithdrawalaccount = accountRepository.findById(4L);
				TransferManager.Transfer(customerRepository, accountRepository, transactionRepository,
						housewithdrawalcustomer, housedwithdrawalaccount.get(), customer, account,
						Long.parseLong(deposit), "Initial Deposit");
			}

			customerRepository.save(customer);
			session.setAttribute("customer", customer);
			redirect.addFlashAttribute("customer", customer);
			redirect.addFlashAttribute("status", "Add Account Succeeded");
		} catch (Exception e) {
			model.addAttribute("status", "Add Account Failed");
		}

		return "redirect:/index3";
	}

}
