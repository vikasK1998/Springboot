package com.wipro.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Dao.AccountCrudDao;
import com.wipro.Dao.AccountDao;
import com.wipro.Exception.NoDataException;
import com.wipro.Exception.NotFoundException;
import com.wipro.Model.Account;
import com.wipro.Model.MoneyTransaction;
import com.wipro.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDao acc;
	
	@Autowired
	AccountCrudDao accCrud;
	
	
	@Override
	public Account addAccount(Account acc) {
		return accCrud.save(acc);
	}

	@Override
	public List<Account> findAll() {
		
		List<Account> accall=acc.findAll();
		if(accall.isEmpty())
		{
			throw new NoDataException();
		}
		return accall;
	}

	@Override
	public Optional<Account> getAccountById(long accNum) {

		Optional<Account> accid=acc.findById(accNum);
		if(accid.isEmpty())
			throw new NotFoundException(accNum);
		return accid;
	}

	@Override
	public Account UpdateAccountById(Account account) {
		List<Account> accall=acc.findAll();
		for(int i=0;i<accall.size();i++)
		{
		    if(accall.get(i).getAcc_num()==account.getAcc_num())
		    {
		    	return accCrud.save(account);
		    }
		}
		throw new NotFoundException();
	}

	@Override
	public void deleteAccountById(long accNum) {
		
		try
		{
			accCrud.deleteById(accNum);
		}
		catch(Exception ex)
		{
			throw new NotFoundException();
		}
		
		
	}

	@Override
	public void deleteAllAccount() {
		
		try
		{
			acc.deleteAll();
		}
		catch(Exception ex)
		{
			throw new NoDataException("No Data Available to Delete");
		}
		
		
	}

	@Override
	public String transferAmount(MoneyTransaction mt) {
		try
		{
		Optional<Account> fromacc=acc.findById(mt.getFromAccNum());
		Optional<Account> toacc=acc.findById(mt.getToAccNum());
		
		Account from=fromacc.get();
		Account to=toacc.get();
		
			if(from.getBalance()>=mt.getAmount())
			{
				from.setBalance(from.getBalance()-mt.getAmount());
				to.setBalance(to.getBalance()+mt.getAmount());
				 accCrud.save(from);
				 accCrud.save(to);
			}
		
			return "Transaction Completed Successfully";
		}
		catch(Exception e)
		{
			throw new NotFoundException();
		}		
		
	}
	
	
}
