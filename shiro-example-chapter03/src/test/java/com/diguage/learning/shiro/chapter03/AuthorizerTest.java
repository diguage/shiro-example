package com.diguage.learning.shiro.chapter03;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-08-13 17:46
 */
public class AuthorizerTest extends BaseTest {
    @Test
    public void testIsPermitted() {
        login("classpath:shiro-jdbc-authorizer.ini", "zhang", "123");
        assertTrue(subject().isPermitted("user1:update"));
        assertTrue(subject().isPermitted("user2:update"));


        assertTrue(subject().isPermitted("+user1+2"));
        assertTrue(subject().isPermitted("+user1+8"));
        assertTrue(subject().isPermitted("+user2+10"));
        assertFalse(subject().isPermitted("+user1+4"));

        assertTrue(subject().isPermitted("menu:view"));
    }
}
