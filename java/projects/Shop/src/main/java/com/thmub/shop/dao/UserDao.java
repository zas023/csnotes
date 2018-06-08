package com.thmub.shop.dao;

import com.thmub.shop.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserDao extends BaseDao{

    //添加
    public static Boolean add(final User us) throws Exception {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        try {
            PreparedStatement ps = conn.prepareStatement("insert into user values(?,?,?)");
            ps.setString(1, us.id);
            ps.setString(2, us.username);
            ps.setString(3, us.userpwd);

            ps.execute();
            conn.commit();
            return true;
        } catch (Exception e) {

            conn.rollback();
            throw e;
        } finally {
            conn.close();
        }
    }

    //获取
    public static User get(final String id) throws Exception {
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from user where id=?");
            ps.setString(1, id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            User us = null;
            if (rs.next()) {
                us = new User();
                us.id = rs.getString("id");
                us.username = rs.getString("username");
                us.userpwd = rs.getString("userpwd");

            }
            return us;
        } catch (Exception e) {
            throw e;
        } finally {
            conn.close();
        }
    }

    //获取全部
    public static List<User> getAll() throws Exception {
        List<User> users = new ArrayList<User>();
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from user");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                User us = new User();

                us.id = rs.getString("id");
                us.username = rs.getString("username");
                us.userpwd = rs.getString("userpwd");
                users.add(us);
            }
            return users;
        } catch (Exception e) {
            throw e;
        } finally {
            conn.close();
        }
    }

    //获取全部
    public static boolean isValidUser(String name, String password) throws Exception {
        boolean bresult = false;
        Connection conn = getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from user");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                User us = new User();

                us.id = rs.getString("id");
                us.username = rs.getString("username");
                us.userpwd = rs.getString("userpwd");
                if (us.username.equals(name) && us.userpwd.equals(password))
                    bresult = true;

            }
            return bresult;
        } catch (Exception e) {
            throw e;
        } finally {
            conn.close();
        }
    }

    //修改
    public static Boolean update(final User us, final String oldId) throws Exception {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        try {
            PreparedStatement ps = conn.prepareStatement("update user set id=?,username=?,userpwd=? where id=?");
            ps.setString(1, us.id);
            ps.setString(2, us.username);
            ps.setString(3, us.userpwd);
            ps.setString(4, oldId);
            ps.execute();
            conn.commit();
            return true;
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            conn.close();
        }
    }

    //删除
    public static Boolean delete(final String id) throws Exception {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        try {
            PreparedStatement ps = conn.prepareStatement("delete from user where id=?");
            ps.setString(1, id);
            ps.execute();
            conn.commit();
            return true;
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            conn.close();
        }
    }
}
