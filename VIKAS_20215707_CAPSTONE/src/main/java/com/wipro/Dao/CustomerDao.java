package com.wipro.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.Model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
}
