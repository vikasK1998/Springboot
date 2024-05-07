package com.wipro.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Customer implements Serializable{
	public Customer(String name, String phn, String email, List<Account> accounts) {
		super();
		this.name = name;
		this.phn = phn;
		this.email = email;
		this.accounts = accounts;
	}

	
	
	
	public String getCustomer() {
		return customer;
	}




	public void setCustomer(String customer) {
		this.customer = customer;
	}




	public Customer(long id,String pancard, String name, String phn, String email, String customer,
			List<Account> accounts) {
		super();
//		this.id = id;
		this.pancard = pancard;
		this.name = name;
		this.phn = phn;
		this.email = email;
		this.customer=customer;
		this.accounts = accounts;
	}




	public long getId() {
		return id;
	}



	public String getPancard() {
		return pancard;
	}




	public void setPancard(String pancard) {
		this.pancard = pancard;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getPhn() {
		return phn;
	}




	public void setPhn(String phn) {
		this.phn = phn;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}








	public List<Account> getAccounts() {
		return accounts;
	}




	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}




	public Customer() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String pancard;
	private String name;
	private String phn;
	private String email;
	private String customer;
	
	@OneToMany(mappedBy="customer",cascade = CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	List<Account> accounts;
	
	
	

}
