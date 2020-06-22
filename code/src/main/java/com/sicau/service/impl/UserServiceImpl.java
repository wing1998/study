package com.sicau.service.impl;

import com.sicau.mapper.ProductMapper;
import com.sicau.mapper.UOrderMapper;
import com.sicau.mapper.UserMapper;
import com.sicau.pojo.Product;
import com.sicau.pojo.UOrder;
import com.sicau.pojo.User;
import com.sicau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper = null;
    private UOrderMapper uOrderMapper = null;
    private ProductMapper productMapper = null;

    @Autowired
    public UserServiceImpl(UserMapper userMapper,
                           UOrderMapper uOrderMapper,
                           ProductMapper productMapper) {
        this.userMapper = userMapper;
        this.uOrderMapper = uOrderMapper;
        this.productMapper = productMapper;
    }

    @Override
    public UOrder getUserDataByUName(String uName) {
        long uId = userMapper.getUIdByUName(uName);
        UOrder order = uOrderMapper.getOrderByUId(uId);
        List<Product> productList = productMapper.getProductsByOId(order.getOId());
        for (Product product:productList) {
            order.setPId(product.getPId());
            order.setTotalPrice(product.getPPrice());
        }
        return order;
    }

    @Override
    public User registerUser(String uName, String uPass) {
        return null;
    }

    @Override
    public User getUserByUNameAndUPass(User user) {
        return null;
    }
}
