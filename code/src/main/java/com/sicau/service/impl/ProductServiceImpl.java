package com.sicau.service.impl;

import com.sicau.pojo.Product;
import com.sicau.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getProductsBySid(long Sid) {
        return null;
    }

    @Override
    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public boolean addShopCart(long shopCartId) {
        return false;
    }

    @Override
    public boolean buyProduct(long pId) {
        return false;
    }

    @Override
    public boolean publishProduct(Product product) {
        return false;
    }
}
