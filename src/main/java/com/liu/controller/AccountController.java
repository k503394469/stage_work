package com.liu.controller;

import com.liu.pojo.Account;
import com.liu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/login")
    public String login(Account account, HttpSession session){
        Account loginUser = accountService.login(account);
        if (loginUser!=null){
            session.setAttribute("accountInfo",loginUser);
            return "redirect:/user/allUser";
        }else {
            return "redirect:/htmls/login.html";
        }
    }
}
