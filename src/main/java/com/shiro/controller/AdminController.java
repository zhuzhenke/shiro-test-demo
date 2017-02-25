package com.shiro.controller;

import com.shiro.common.RoleContant;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description:
 * User: zhuzhenke
 * Date: 16/11/16
 * Time: 15:16
 * Version: 1.0
 */
@Controller
public class AdminController {


    /**
     * 如果是有权限的,直接跳转到admin.jsp
     */
    @RequiresRoles(value = {RoleContant.ROLE_ADMIN, RoleContant.ROLE_BOSS}, logical = Logical.OR)
    @RequestMapping(value = "/admin")
    public void login(HttpServletResponse response) {
        try {
            response.sendRedirect("admin.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
