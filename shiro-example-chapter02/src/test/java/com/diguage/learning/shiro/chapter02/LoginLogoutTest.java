package com.diguage.learning.shiro.chapter02;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Shiro登录验证示例
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-08-13 10:58
 */
public class LoginLogoutTest {
    private static final Logger log = LoggerFactory.getLogger(LoginLogoutTest.class);

    @Test
    public void testHelloworld() {
        // 1. 获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        // 2. 得到SecurityManager实例并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // 3. 得到Subject以及创建用户名/密码身份验证Token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");


        try {
            // 4. 登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            // 5. 身份验证失败。（失败也不抛出错误。）
            log.error("Auth Error!");
        }

        Assert.assertEquals(true, subject.isAuthenticated()); // 判断用户是否登录

        // 6. 退出
        subject.logout();

    }

    @Test
    public void testCustomRealm() {
        // 1. 获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        // 2. 得到SecurityManager实例并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // 3. 得到Subject以及创建用户名/密码身份验证Token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");


        try {
            // 4. 登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            // 5. 身份验证失败。（失败也不抛出错误。）
            log.error("Auth Error!");
        }

        Assert.assertEquals(true, subject.isAuthenticated()); // 判断用户是否登录

        // 6. 退出
        subject.logout();

    }

    @Test
    public void testJdbcRealm() {
        // 1. 获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        // 2. 得到SecurityManager实例并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        // 3. 得到Subject以及创建用户名/密码身份验证Token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");


        try {
            // 4. 登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            // 5. 身份验证失败。（失败也不抛出错误。）
            log.error("Auth Error!");
        }

        Assert.assertEquals(true, subject.isAuthenticated()); // 判断用户是否登录

        // 6. 退出
        subject.logout();

    }
}
