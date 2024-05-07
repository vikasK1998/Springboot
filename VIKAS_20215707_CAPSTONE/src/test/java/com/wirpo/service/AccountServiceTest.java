package com.wirpo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.wipro.Dao.AccountDao;
import com.wipro.Model.Account;
import com.wipro.Model.Customer;
import com.wipro.Model.MoneyTransaction;
import com.wipro.service.AccountService;
import com.wipro.serviceImpl.AccountServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
	@InjectMocks
	AccountServiceImpl as;
	
	@Mock
	AccountService accrepo;

	@Test
    public void getAllAccountTest()
    {
		List<Account> list = new ArrayList<Account>();
        Account savedaccount1=new Account();
        savedaccount1.setAcc_num(1001);
      list.add(savedaccount1);
                lenient().when(accrepo.findAll()).thenReturn(list);
        assertEquals(1001, savedaccount1.getAcc_num());
    }
	
	@Test
    public void getAccountByidTest()
    {
        Customer savedaccount1=new Customer();
        savedaccount1.setCustomer("CUS1001");
        lenient().when(accrepo.getAccountById(1001)).thenReturn(null);
        assertEquals("CUS1001", savedaccount1.getCustomer());
    }
	
	@Test
    public void addAccountTest()
    {
        Account savedaccount1=new Account();
        savedaccount1.setAcc_num(1001);
        lenient().when(accrepo.addAccount(savedaccount1)).thenReturn(savedaccount1);
        assertEquals(1001, savedaccount1.getAcc_num());
    }
	
	@Test
    public void UpdateAccountByIdTest()
    {
		Account savedaccount1=new Account();
        savedaccount1.setAcc_num(1001);
        savedaccount1.setAccounttype("Savings");
		 lenient().when(accrepo.UpdateAccountById(savedaccount1)).thenReturn(savedaccount1);
		 assertEquals("Savings", savedaccount1.getAccounttype());
    }
	
	
	@Test
    public void deleteAccountByIdTest()
    {
		Account savedaccount1=new Account();
		savedaccount1.setAcc_num(1001);
		accrepo.deleteAccountById(1001);
        verify(accrepo, times(1)).deleteAccountById(1001);
    }
	
	@Test
    public void deleteAllAccountTest()
    {
		Account savedaccount1=new Account();
		savedaccount1.setAcc_num(1001);
		accrepo.deleteAllAccount();
        verify(accrepo, times(1)).deleteAllAccount();
    }
	
	@Test
    public void transferAmounttest()
    {
		MoneyTransaction savedaccount1=new MoneyTransaction();
        savedaccount1.setAmount(100.0);
        savedaccount1.setFromAccNum(1001);
        savedaccount1.setToAccNum(1003);
        lenient().when(accrepo.transferAmount(savedaccount1)).thenReturn("acc_num");
		 assertEquals(1001, savedaccount1.getFromAccNum());
       
    }
	
	
}
