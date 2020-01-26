package com.liu.dao;

import com.liu.pojo.Account;

import java.util.List;

public interface AccountDao {
    Account findByNameAndPassword(Account account);
    List<Account> findByUserId(Integer user_id);
}
