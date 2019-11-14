package com.webapp.onlinebankspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public abstract class Person
{

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected long personId;
	
	protected String firstName="";
	protected String lastName="";
	protected String telephoneNumber="";
	protected String email="";
	protected String password="";
	protected String street="";
	protected String city="";
	protected String state="";
	protected String zipCode="";
	
	
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


	public long getPersonid()
	{
		return personId;
	}

	public void setPersonid(long personid)
	{
		this.personId = personid;
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
	
	

	
}
