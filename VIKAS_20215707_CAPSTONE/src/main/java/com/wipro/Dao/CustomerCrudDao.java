package com.wipro.Dao;

import org.springframework.data.repository.CrudRepository;

import com.wipro.Model.Customer;

public interface CustomerCrudDao extends CrudRepository<Customer, Long> {

}
