package com.liu.service.impl;

import com.liu.dao.AccountDao;
import com.liu.pojo.Account;
import com.liu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public Account login(Account account) {
        return accountDao.findByNameAndPassword(account);
    }

    @Override
    public List<Account> findByUserId(Integer user_id) {
        return accountDao.findByUserId(user_id);
    }
}
