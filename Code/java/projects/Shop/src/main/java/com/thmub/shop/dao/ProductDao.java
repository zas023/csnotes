package com.thmub.shop.dao;

import com.thmub.shop.bean.Product;
import com.thmub.shop.bean.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProductDao extends BaseDao{

    //添加
    public static Boolean add(final Product product) throws Exception {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        try {
            PreparedStatement ps = conn.prepareStatement("insert into product values(?,?,?)");
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getNumber());

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
    public static Product get(final int id) throws Exception {
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from product where id=?");
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            Product product =null;
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setNumber(rs.getInt("number"));
            }
            return product;
        } catch (Exception e) {
            throw e;
        } finally {
            conn.close();
        }
    }

    //获取全部
    public static List<Product> getAll() throws Exception {
        List<Product> products = new ArrayList<Product>();
        Connection conn = getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from product");
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Product product = new Product();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setNumber(rs.getInt("number"));

                products.add(product);
            }
            return products;
        } catch (Exception e) {
            throw e;
        } finally {
            conn.close();
        }
    }



    //修改
    public static Boolean update(final Product product, final int oldId) throws Exception {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        try {
            PreparedStatement ps = conn.prepareStatement("update product set id=?,name=?,number=? where id=?");
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getNumber());
            ps.setInt(4, oldId);
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
    public static Boolean delete(final int id) throws Exception {
        Connection conn = getConnection();
        conn.setAutoCommit(false);
        try {
            PreparedStatement ps = conn.prepareStatement("delete from product where id=?");
            ps.setInt(1, id);
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
