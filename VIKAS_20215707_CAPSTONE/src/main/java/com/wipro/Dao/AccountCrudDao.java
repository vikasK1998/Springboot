package com.wipro.Dao;

import org.springframework.data.repository.CrudRepository;

import com.wipro.Model.Account;

public interface AccountCrudDao extends CrudRepository<Account, Long> {

}
