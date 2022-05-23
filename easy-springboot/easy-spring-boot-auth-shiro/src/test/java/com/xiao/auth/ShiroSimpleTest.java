package com.xiao.auth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ShiroSimpleTest {

    @Test
    public void test() {
        // 1.创建安全管理器对象
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        // 2.给安全管理器对象设置realm数据源
        securityManager.setRealm(new IniRealm("classpath:shiro.ini"));
        // 3.SecurityUtils给全局安全工具类设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        // 4.全局安全工具类通过安全管理者生成Subject对象
        Subject subject = SecurityUtils.getSubject();
        // 5.创建令牌
        String username = "xiao";
        UsernamePasswordToken token = new UsernamePasswordToken(username, "123456");
        try {
            System.out.println("认证状态" + subject.isAuthenticated());
            // 6. 登录
            subject.login(token);
            System.out.println("认证状态" + subject.isAuthenticated());

            // 7. 是否具有某个角色
            String projectManager = "project_manager";
            String userManager = "user_manager";

            ArrayList<String> roles = new ArrayList<>();
            roles.add(projectManager);
            roles.add(userManager);

            System.out.println(
                    String.format("用户【%s】具有【%s】角色？" + subject.hasRole(projectManager), username, projectManager));
            System.out.println(
                    String.format("用户【%s】具有【%s】角色？" + subject.hasRole(userManager), username, userManager));
            System.out.println(
                    String.format("用户【%s】具有【%s】角色？" + Arrays.toString(subject.hasRoles(roles)), username, roles));

            // 8. 是否具有某个权限
            String addProject = "addProject";
            String updateProject = "updateProject";
            String deleteProject = "deleteProject";
            String queryProject = "queryProject";

            System.out.println(
                    String.format("用户【%s】具有【%s】权限？" + subject.isPermitted(addProject), username, addProject));
            System.out.println(
                    String.format("用户【%s】具有【%s】权限？" + subject.isPermitted(updateProject), username, updateProject));
            System.out.println(
                    String.format("用户【%s】具有【%s】权限？" + subject.isPermitted(deleteProject), username, deleteProject));
            System.out.println(
                    String.format("用户【%s】具有【%s】权限？" + subject.isPermitted(queryProject), username, queryProject));

        } catch (UnknownAccountException e) {
            System.out.println("认证失败，用户名不存在");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("认证失败");
        }
    }

}
