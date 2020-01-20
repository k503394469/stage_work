package com.liu.controller;

import com.liu.pojo.User;
import com.liu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/allUser",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<User> allUser() {
        List<User> all = userService.findAll();
        return all;
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
