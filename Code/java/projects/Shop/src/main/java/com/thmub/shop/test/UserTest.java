package com.thmub.shop.test;

import com.thmub.shop.bean.User;
import com.thmub.shop.dao.UserDao;

import java.util.List;

public class UserTest {

    public static void main(String[] args) throws Exception {
        List<User> list=UserDao.getAll();
        System.out.println(list.size());
    }

}
