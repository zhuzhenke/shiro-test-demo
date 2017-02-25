package com.shiro.test;

import com.shiro.util.ShiroUtil;
import org.apache.shiro.subject.Subject;

/**
 * Description:
 * User: zhuzhenke
 * Date: 16/11/11
 * Time: 14:45
 * Version: 1.0
 */
public class PermissionTest {
    /**
     * 运行测试类报错请参看org.apache.shiro.realm.jdbc.JdbcRealm类的表和字段筛选
     * Caused by: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Table 'db_shiro.user_roles' doesn't exist
     */
//    @Test
    public void hasPermission() {
//        Subject subject = ShiroUtil.login("classpath:testini/shiro_permission.ini", "zhuzhenke", "123");
        Subject subject = ShiroUtil.login("classpath:testini/shiro_permission.ini", "zzk", "123");
//        System.out.println(subject.isPermitted("user:select") ? "拥有这个权限" : "没有这个权限");
//        System.out.println(subject.isPermitted("user:add") ? "拥有这个权限" : "没有这个权限");

        boolean[] list = subject.isPermitted("user:select", "user:update");
        System.out.println("权限：" + list[0]);
        System.out.println("权限：" + list[1]);

        System.out.println(subject.isPermittedAll("user:select", "user:delete") ? "有这两个权限" : "两个权限不全有");

        subject.logout();
    }


//    @Test
    public void checkPermission() {
//        Subject subject = ShiroUtil.login("classpath:testini/shiro_permission.ini", "zhuzhenke", "123");
        Subject subject = ShiroUtil.login("classpath:testini/shiro_permission.ini", "zzk", "123");
        subject.checkPermission("user:select");

        subject.logout();
    }
}
