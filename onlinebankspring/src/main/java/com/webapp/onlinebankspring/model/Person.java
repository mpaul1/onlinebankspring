package com.webapp.onlinebankspring.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public abstract class Person
{

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long personId;
	
	@NotNull(message="First Name cannot be blank")
	@Size(min=1, message="First Name must be at least 1 character")
	protected String firstName="";
	@NotNull(message="Last Name cannot be blank")
	@Size(min=1, message="Last Name must be at least 1 character")
	protected String lastName="";
	@NotNull(message="Telephone cannot be blank")
	@Size(min=10, message="Telephone must be at least 10 characters")
	protected String telephoneNumber="";
	@NotNull(message="Email Name cannot be blank")
	@Email
	protected String email="";
	@NotNull(message="Password Name cannot be blank")
	@Size(min=4, message="Password must be at least 4 characters")
	protected String password="";
	@NotNull(message="Street cannot be blank")
	@Size(min=4, message="Street must be at least 4 characters")
	protected String street="";
	@NotNull(message="City cannot be blank")
	@Size(min=4, message="City must be at least 4 characters")
	protected String city="";
	@NotNull(message="State cannot be blank")
	@Size(min=2, max=2, message="State must be 2 characters")
	protected String state="";
	@NotNull(message="Zip Code cannot be blank")
	@Size(min=5, message="Zip Code must be at least 5 characters")
	protected String zipCode="";
	@NotNull(message="Intial Deposit cannot be blank")
	@Min(value=1L, message="Initial Deposit must be greater than $0")
	protected long initialDeposit;
	
	@OneToMany(mappedBy = "person",fetch=FetchType.EAGER)
	private List<Account> accounts = new ArrayList<Account>();
	
	public Person()
	{
		
	}

	public Person(String firstName, String lastName, String telephoneNumber, String email,
			String password, String street, String city, String state, String zipcode)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephoneNumber = telephoneNumber;
		this.email = email;
		this.password = password;
		this.street = street;
		this.city = city;
		this.state=state;
		this.zipCode=zipcode;

	}


	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getTelephoneNumber()
	{
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber)
	{
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(Account account) {
		accounts.add(account);
		account.setPerson(this);
	}

	public long getInitialDeposit() {
		return initialDeposit;
	}

	public void setInitialDeposit(long initialDeposit) {
		this.initialDeposit = initialDeposit;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", telephoneNumber=" + telephoneNumber + ", email=" + email + ", password=" + password + ", street="
				+ street + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", accounts=" + accounts
				+ "]";
	}

	
}
