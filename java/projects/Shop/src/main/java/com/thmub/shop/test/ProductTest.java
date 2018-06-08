package com.thmub.shop.test;

import com.thmub.shop.bean.Product;
import com.thmub.shop.dao.ProductDao;

public class ProductTest {

    public static void main(String[] args) throws Exception {

//        for (int i=1; i<101; i++){
//            Product product=new Product(i,"product"+i,i);
//            ProductDao.add(product);
//        }
        System.out.println(ProductDao.get(1));
    }

}
