package com.liu.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liu.pojo.User;
import com.liu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/allUser",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object allUser(@RequestParam(defaultValue = "1",name = "startPage") Integer startPage) {
        Map<String,Object> pageMap=new TreeMap<>();
        PageHelper.startPage(startPage,5);
        List<User> all = userService.findAll();
        PageInfo<User> pageInfo=new PageInfo<>(all);
        pageMap.put("pages",pageInfo.getPages());
        pageMap.put("pageNum",pageInfo.getPageNum());
        pageMap.put("dataList",pageInfo.getList());
        return pageMap;
    }
    @RequestMapping(value = "/delUser/{id}")
    public String delUser(@PathVariable String id){
        userService.deleteById(Integer.parseInt(id));
        return "look";
    }
    @RequestMapping("/updateUI/{id}")
    @ResponseBody
    public User updateUI(@PathVariable Integer id){
        return userService.findById(id);
    }
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/htmls/look.html";
    }


}
