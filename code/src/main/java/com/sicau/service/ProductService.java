package com.sicau.service;

import com.sicau.pojo.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProductsBySid(long Sid);
    List<Product> getAllProduct();
    boolean addShopCart(long shopCartId);
    boolean buyProduct(long pId);
    boolean publishProduct(Product product);
}
