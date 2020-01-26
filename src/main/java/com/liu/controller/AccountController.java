package com.liu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.Account;
import com.liu.pojo.User;
import com.liu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
            return "redirect:/user/name_search";
        }else {
            return "redirect:/htmls/login.html";
        }
    }
    @RequestMapping("/accountList")
    public String checkAccount(Integer id, Model model,@RequestParam(defaultValue = "1", name = "startPage") Integer startPage){
        Map<String, Object> pageMap = new TreeMap<>();
        PageHelper.startPage(startPage, 10);
        List<Account> accountList = accountService.findByUserId(id);
        PageInfo<Account> pageInfo = new PageInfo<>(accountList);
        pageMap.put("pages", pageInfo.getPages());
        pageMap.put("pageNum", pageInfo.getPageNum());
        pageMap.put("lastPage",pageInfo.getPrePage());
        pageMap.put("nextPage",pageInfo.getNextPage());
        pageMap.put("dataList", pageInfo.getList());
        pageMap.put("user_id",id);
        model.addAttribute("pageMap", pageMap);
        return "account_look";
    }
}
