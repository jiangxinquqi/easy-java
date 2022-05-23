package com.xiao.auth.shiro;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class AuthenticationRepository {

    private static final String jdbcUrl = "jdbc:mysql://124.71.70.43:3306/shallwe?characterEncoding=UTF-8&useSSL=false";
    private static final String user = "root";
    private static final String password = "xiaojianjun";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, user, password);
    }

    public static String getPassword(String userName) {
        String sql = "select password from user where username = ?";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("password");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    public static Set<String> listRoles(String userName) {

        Set<String> roles = new HashSet<>();
        String sql = "select r.name from user u " +
                "left join user_role ur on u.id = ur.user_id " +
                "left join role r on r.id = ur.role_id " +
                "where u.username = ?";

        return query(userName, roles, sql);
    }

    public static Set<String> listPermissions(String userName) {
        Set<String> permissions = new HashSet<>();
        String sql = "select p.name from user u " +
                "left join user_role ru on u.id = ru.user_id " +
                "left join role r on r.id = ru.role_id " +
                "left join role_permission rp on r.id = rp.role_id " +
                "left join permission p on p.id = rp.permission_id " +
                "where u.username =?";

        return query(userName, permissions, sql);
    }

    private static Set<String> query(String userName, Set<String> permissions, String sql) {
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, userName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                permissions.add(rs.getString(1));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return permissions;
    }

}
