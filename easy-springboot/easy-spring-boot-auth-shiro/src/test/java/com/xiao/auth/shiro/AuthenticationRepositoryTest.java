package com.xiao.auth.shiro;

import junit.framework.TestCase;
import org.junit.Test;

public class AuthenticationRepositoryTest extends TestCase {

    @Test
    public void test() {
        System.out.println(AuthenticationRepository.getPassword("admin"));
    }

}