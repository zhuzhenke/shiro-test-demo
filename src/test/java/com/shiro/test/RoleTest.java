package com.shiro.test;

import com.shiro.util.ShiroUtil;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * Description:
 * User: zhuzhenke
 * Date: 16/11/11
 * Time: 14:32
 * Version: 1.0
 */
public class RoleTest {
    /**
     * 运行测试类报错请参看org.apache.shiro.realm.jdbc.JdbcRealm类的表和字段筛选
     * Caused by: com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException: Table 'db_shiro.user_roles' doesn't exist
     */
//    @Test
    public void hasRole() {
//        Subject subject = ShiroUtil.login("classpath:testini/shiro_role.ini", "zhuzhenke", "123");
        Subject subject = ShiroUtil.login("classpath:testini/shiro_role.ini", "zzk", "123");
        System.out.println(subject.hasRole("role2") ? "有这个角色" : "没有这个角色");

        boolean[] booleanList = subject.hasRoles(Arrays.asList("role1", "role2"));

        System.out.println("role1:" + booleanList[0]);
        System.out.println("role2:" + booleanList[1]);

        boolean allRoles = subject.hasAllRoles(Arrays.asList("role1", "role2"));
        System.out.println("allRoles:" + allRoles);

        subject.logout();
    }

//    @Test
    public void checkRole() {
//        Subject subject = ShiroUtil.login("classpath:testini/shiro_role.ini", "zhuzhenke", "123");
        Subject subject = ShiroUtil.login("classpath:testini/shiro_role.ini", "zzk", "123");
//        subject.checkRole("role2");//没有这个觉得就会抛UnauthorizedException异常

        subject.checkRoles(Arrays.asList("role1", "role2"));
        subject.checkRoles("role1", "role2");
//
//        System.out.println("role1:" + booleanList[0]);
//        System.out.println("role2:" + booleanList[1]);
//
//        boolean allRoles = subject.hasAllRoles(Arrays.asList("role1", "role2"));
//        System.out.println("allRoles:" + allRoles);

        subject.logout();
    }
}
