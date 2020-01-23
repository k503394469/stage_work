package com.liu.dao;

import com.liu.pojo.Account;

public interface AccountDao {
    Account findByNameAndPassword(Account account);
}
