package com.liu.service;

import com.liu.pojo.Account;

import java.util.List;

public interface AccountService {
    Account login(Account account);
    List<Account> findByUserId(Integer user_id);
}
