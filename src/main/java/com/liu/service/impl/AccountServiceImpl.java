package com.liu.service.impl;

import com.liu.dao.AccountDao;
import com.liu.pojo.Account;
import com.liu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public Account login(Account account) {
        return accountDao.findByNameAndPassword(account);
    }
}
