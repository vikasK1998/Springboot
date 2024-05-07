package com.wipro.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.Model.Account;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
}
