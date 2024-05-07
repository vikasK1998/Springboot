package com.wipro.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.Dao.CustomerCrudDao;
import com.wipro.Dao.CustomerDao;
import com.wipro.Exception.NoDataException;
import com.wipro.Exception.NotFoundException;
import com.wipro.Model.Customer;
import com.wipro.service.CustomerService;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao cus;
	
	@Autowired
	CustomerCrudDao cusCrud;
	
	@Override
	public Customer addCustomer(Customer cus) {
		
		
		int len=cus.getAccounts().size();
		for(int i=0;i<len;i++)
		{
			cus.getAccounts().get(i).setCustomer(cus);
		}
		return cusCrud.save(cus);
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> cusall=cus.findAll();
		if(cusall.isEmpty())
		{
			throw new NoDataException();
		}
		return cus.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(long id) {
		
		Optional<Customer> op=cus.findById(id);
		if(op.isEmpty())
		{
			throw new NotFoundException(id);
		}
		return op;
		
	}

	@Override
	public Customer UpdateCustomerById(Customer customer) {
	
		
		List<Customer> cusall=cus.findAll();
		for(int i=0;i<cusall.size();i++)
		{
			if(cusall.get(i).getId()==customer.getId())
			{
				customer.setPancard(cusall.get(i).getPancard());
				int len=customer.getAccounts().size();
				for(int j=0;j<len;j++)
				{
					customer.getAccounts().get(j).setCustomer(customer);
				}
				
				return cusCrud.save(customer);
			}
		}
		throw new NotFoundException();
	}

	@Override
	public String deleteCustomerById(long id) {
		try
		{
			cusCrud.deleteById(id);
			return id+" "+"Deleted Successfully";
		}
		catch(Exception ex)
		{
			throw new NotFoundException();
		}
		
		
	}

	@Override
	public void deleteAllCustomer() {

		try
		{
			cus.deleteAll();
		}
		catch(Exception ex)
		{
			throw new NoDataException("No Data Available to Delete");
		}
		
		
	}

}
