package com.liu.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CusInter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object userInfo = session.getAttribute("accountInfo");
        if (userInfo!=null){
            return true;
        }else{
            response.sendRedirect(request.getContextPath()+"/htmls/login.html");
            return false;
        }
    }
}
