package com.diguage.learning.shiro.chapter03;

import static org.junit.Assert.*;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Test;

/**
 * <p/>
 * Coder：D瓜哥，http://www.diguage.com/
 * <p/>
 * Date: 2014-08-13 17:01
 */
public class PermissionTest extends BaseTest {
    @Test
    public void testIsPermitted() {
        login("classpath:shiro-permission.ini", "zhang", "123");
        assertTrue(subject().isPermitted("user:create"));
        assertTrue(subject().isPermittedAll("user:update", "user:delete"));
        assertFalse(subject().isPermitted("user:view"));
    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckPermission() {
        login("classpath:shiro-permission.ini", "zhang", "123");
        subject().checkPermission("user:create");
        subject().checkPermissions("user:delete", "user:update");
        subject().checkPermissions("user:view");
    }
}
