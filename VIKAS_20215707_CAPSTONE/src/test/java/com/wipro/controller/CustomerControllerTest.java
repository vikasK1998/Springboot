package com.wipro.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.wipro.Model.Account;
import com.wipro.Model.Customer;
import com.wipro.Model.MoneyTransaction;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

		@LocalServerPort
		private int randomPort;
		@Autowired
		TestRestTemplate testTemplate;
		
	@Test
	void addCustomerTest() {
		String URI=("http://localhost:" +randomPort+"/customer/addCustomer/");
		Customer c1=new Customer();
		c1.setName("CustomerTest");
		List<Account> c1Accounts=new ArrayList<Account>();
		Account a1=new Account("Savings",100.0,"chennai",c1);
		c1.setAccounts(c1Accounts);
		c1Accounts.add(a1);
		HttpEntity<Customer> request=new HttpEntity<>(c1);
		ResponseEntity<Customer> foundcustomer=testTemplate.postForEntity(URI, request, Customer.class);
		assertNotEquals("CustomerTest",foundcustomer.getBody().getName());

	}
	@Test
	void GetCustomerByIdTest() {
		String URI = "http://localhost:" + randomPort;
		Customer customer = testTemplate.getForObject(URI + "/getCustomerByid/1", Customer.class);
        System.out.println(customer.getName());
        assertNotNull(customer);
	}
	
	@Test
	void GetAllCustomerTest() {
		String URI = "http://localhost:" + randomPort;
		Customer customer = testTemplate.getForObject(URI + "/getAllCustomer/1", Customer.class);
        System.out.println(customer.getName());
        assertNotNull(customer);
	}
	
	@Test
	void deleteAllCustomerTest() {
		String URI = "http://localhost:" + randomPort;
		Customer customer = testTemplate.getForObject(URI + "/deleteAllCustomer/1", Customer.class);
        System.out.println(customer.getName());
        assertNotNull(customer);
	}
	
	@Test
	void deleteCustomerByidTest()
	{
		int id = 1;
		String URI = "http://localhost:" + randomPort ;
        Customer customer = testTemplate.getForObject(URI+ "/deleteCustomerByid/" + id, Customer.class);
        assertNotNull(customer);
        testTemplate.delete(URI + "/customers/" + id);
        try {
             customer = testTemplate.getForObject(URI + "/getCustomerByid/" + id, Customer.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }
	

	@Test
	void editCustomerdetailsTest() {
		int id = 1;
		String URI = "http://localhost:" + randomPort + "/editCustomer/1";
		Customer foundCustomer = testTemplate.getForObject(URI + id, Customer.class);
		foundCustomer.setName("Ram");
		testTemplate.put(URI + id, foundCustomer);
		HttpEntity<Customer> request = new HttpEntity<>(foundCustomer);
		Customer a = testTemplate.postForObject(URI + id, request, Customer.class);
		assertNotNull(a);
	}

	@SuppressWarnings("deprecation")
	@Test
	void transferAmountTest()
	{
	String URI="http://localhost:"+randomPort+"/transferAmount";
	MoneyTransaction f= new MoneyTransaction();
	Account account = testTemplate.getForObject(URI + f.getFromAccNum() + f.getToAccNum() + f.getAmount(), Account.class);
	testTemplate.put(URI + f.getToAccNum() + f.getToAccNum()+ f.getAmount(), account);
	HttpEntity<Account> request = new HttpEntity<>(account);
	Account transferred = testTemplate.postForObject(URI + f.getToAccNum() + f.getToAccNum() + f.getAmount(), request ,Account.class);
	assertThat(transferred, is(notNullValue()));
	}


	

}
