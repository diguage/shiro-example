package com.diguage.learning.shiro.chapter03;

import static org.junit.Assert.*;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Test;

import java.util.Arrays;

/**
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-08-13 16:39
 */
public class RoleTest extends BaseTest {
    @Test
    public void testHasRole() {
        login("classpath:shiro-role.ini", "zhang", "123");

        assertTrue(subject().hasRole("role1"));

        boolean[] result = subject().hasRoles(Arrays.asList("role1", "role2", "role3"));

        assertEquals(true, result[0]);
        assertEquals(true, result[1]);
        assertEquals(false, result[2]);
    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckRole() {
        login("classpath:shiro-role.ini", "zhang", "123");
        subject().checkRole("role1");

        subject().checkRoles("role1", "role3");
    }

}
