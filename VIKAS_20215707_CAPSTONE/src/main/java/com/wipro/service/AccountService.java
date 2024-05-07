package com.wipro.service;

import java.util.List;
import java.util.Optional;

import com.wipro.Model.Account;
import com.wipro.Model.MoneyTransaction;

public interface AccountService {
	
    public Account addAccount(Account acc);	

	public List<Account> findAll();
	
	public Optional<Account> getAccountById(long accNum);
	
	public Account UpdateAccountById(Account account);
	
	public void deleteAccountById(long accNum);
	
	public void deleteAllAccount();
	
	public String transferAmount(MoneyTransaction mt);
	

}
