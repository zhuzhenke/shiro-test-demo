package com.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Description:
 * User: zhuzhenke
 * Date: 16/11/10
 * Time: 16:53
 * Version: 1.0
 */
public class HelloWorld {

    @Test
    public void testHelloWorld() {
        //读取卑职文件，初始化SecurityManager工厂
        //默认路径是  classpath:shiro.ini
//        Factory<SecurityManager> factory = new IniSecurityManagerFactory();
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:testini/shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        //创建token令牌
        UsernamePasswordToken token = new UsernamePasswordToken("zhuzhenke", "123");
        try {
            subject.login(token);
            System.out.println("登录成功");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登录失败");
        }
        subject.logout();
    }
}
