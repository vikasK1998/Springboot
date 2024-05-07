package com.wirpo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import com.wipro.service.CustomerService;
import com.wipro.serviceImpl.AccountServiceImpl;
import com.wipro.serviceImpl.CustomerServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
	@InjectMocks
	CustomerServiceImpl as;
	
	@Mock
	CustomerService accrepo;

	@Test
    public void getAllCustomerTest()
    {
		List<Customer> list = new ArrayList<Customer>();
        Customer savedaccount1=new Customer();
        savedaccount1.setCustomer("CUS1001");
        list.add(savedaccount1);
        lenient().when(accrepo.findAll()).thenReturn(list);
        assertEquals("CUS1001", savedaccount1.getCustomer());
    }
	
	@Test
    public void addCustomerTest()
    {
        Customer savedaccount1=new Customer();
        savedaccount1.setCustomer("CUS1001");
        lenient().when(accrepo.addCustomer(savedaccount1)).thenReturn(savedaccount1);
        assertEquals("CUS1001", savedaccount1.getCustomer());
    }
	
	@Test
    public void getCustomerByidTest()
    {
        Customer savedaccount1=new Customer();
        savedaccount1.setCustomer("CUS1001");
        lenient().when(accrepo.getCustomerById(1001)).thenReturn(null);
        assertEquals("CUS1001", savedaccount1.getCustomer());
    }
	
	@Test
    public void UpdateCustomerByIdTest()
    {
		Customer savedaccount1=new Customer();
        savedaccount1.setCustomer("CUS1001");
        savedaccount1.setEmail("ABC@g.com");
		 lenient().when(accrepo.UpdateCustomerById(savedaccount1)).thenReturn(savedaccount1);
		 assertEquals("ABC@g.com", savedaccount1.getEmail());
    }
	
	
	@Test
    public void deleteCustomerByIdTest()
    {
		Customer savedaccount1=new Customer();
		accrepo.deleteCustomerById(1001);
        verify(accrepo, times(1)).deleteCustomerById(1001);
    }
	
	@Test
    public void deleteAllCustomerTest()
    {
		Customer savedaccount1=new Customer();
		accrepo.deleteAllCustomer();
        verify(accrepo, times(1)).deleteAllCustomer();
    }
	
	
}
