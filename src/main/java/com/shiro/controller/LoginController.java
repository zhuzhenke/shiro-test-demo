package com.shiro.controller;

import com.shiro.pojo.Users;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * User: zhuzhenke
 * Date: 16/11/16
 * Time: 15:02
 * Version: 1.0
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(Users users, HttpServletRequest request, HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(users.getUserName(), users.getPassword());

        try {
            subject.login(usernamePasswordToken);//通过验证
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorInfo", "用户名或者密码错误");
            try {
                response.sendRedirect("login.jsp");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
