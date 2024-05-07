package com.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.Dao.AccountDao;
import com.wipro.Exception.NotFoundException;
import com.wipro.Model.Account;
import com.wipro.Model.Customer;
import com.wipro.Model.MoneyTransaction;
import com.wipro.serviceImpl.AccountServiceImpl;
import com.wipro.serviceImpl.CustomerServiceImpl;

import javassist.bytecode.stackmap.BasicBlock.Catch;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired CustomerServiceImpl csi;
	@Autowired AccountServiceImpl asi;
	@Autowired AccountDao acc;
	
		@PostMapping("/addCustomer")
		public ResponseEntity<?> AddCustomer(@RequestBody Customer cus)
		{
			
			ResponseEntity<?> response=new ResponseEntity<>(HttpStatus.CONFLICT);
			Customer customer=csi.addCustomer(cus);
			if(customer!=null)
			{
				response=new ResponseEntity<>(customer,HttpStatus.CREATED);
				
			}
			
			return ResponseEntity.ok(response);
			
		}
		
		@PutMapping("/editCustomer")
		public ResponseEntity<?> editCustomer(@RequestBody Customer cus)
		{
			
			Customer customer=csi.UpdateCustomerById(cus);
			ResponseEntity<?> response=new ResponseEntity<>(HttpStatus.CONFLICT);
			if(customer!=null)
				response=new ResponseEntity<>(customer,HttpStatus.CREATED);
			
			return response;
		}
		@GetMapping("/getAllCustomer")
		public List<Customer> getAllCustomer()
		{
			List<Customer> allCus=csi.findAll();
			
			return allCus;
		}
		
		@GetMapping("/getCustomerByid/{id}")
		public Optional<Customer> getCustomerByid(@PathVariable("id") long cusId)
		{
			Optional<Customer> cus=csi.getCustomerById(cusId);
			
			return cus;
		}
		
		@DeleteMapping("/deleteCustomerByid/{id}")
		public String deleteCustomerByid(@PathVariable("id") long cusId)
		{
			String s=csi.deleteCustomerById(cusId);
			
			return s;
		}
		
		@DeleteMapping("/deleteAllCustomer")
		public String deleteallCustomer()
		{
			if(csi.findAll()!=null) {
			csi.deleteAllCustomer();
			}
			return "Customer Details Deleted Successfully";
		}
		
		@PutMapping("/transferAmount")
		public String TranferAmount(@RequestBody MoneyTransaction mt, Account account)
		{ 
			Optional<Account> fromacc=acc.findById(mt.getFromAccNum());
			Optional<Account> toacc=acc.findById(mt.getToAccNum());
			
			Account from=fromacc.get();
			Account to=toacc.get();
			
			
			if(from != to && from.getBalance()>0&&mt.getAmount()>0&&mt.getAmount()<=from.getBalance()) {
				
				String status=asi.transferAmount(mt);
				return status;
			} else if(mt.getAmount()<0) {
				return "Please Enter Valid Amount!!!";
			} else if(mt.getAmount()>from.getBalance()) {
				return "Transaction Failed due to insufficient balance!!!";
			}  
			return "Transaction Failed....Source Account should not be same as From account!!!";
		}
		

}
