package com.wipro.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3096447832121024740L;



	public Account(String branch, double balance, String accountType, Customer customer) {
		super();
		this.branch = branch;
		this.balance = balance;
		this.customer = customer;
	}

	
	
	
	public Account() {
		super();
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long acc_num;
	private String branch;
	private String accounttype;	
	private double balance;
	

	public long getAcc_num() {
		return acc_num;
	}



	public void setAcc_num(long acc_num) {
		this.acc_num = acc_num;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getAccounttype() {
		return accounttype;
	}



	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}




	@ToString.Exclude
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_customer_id")
	@JsonIgnore
	Customer customer;

	

}
