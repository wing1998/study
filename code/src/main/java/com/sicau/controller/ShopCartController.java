package com.sicau.controller;

import com.sicau.pojo.Product;
import com.sicau.pojo.User;
import com.sicau.service.ProductService;
import com.sicau.service.ShopCartService;
import com.sicau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/shop")
@ResponseBody
public class ShopCartController {

    private UserService userService = null;
    private ShopCartService shopCartService = null;
    private ProductService productService = null;

    @Autowired
    public ShopCartController(UserService userService,
                              ShopCartService shopCartService,
                              ProductService productService) {
        this.userService = userService;
        this.shopCartService = shopCartService;
        this.productService = productService;
    }

    @RequestMapping(value = "/shop_cart", method = RequestMethod.GET)
    public List<Product> queryShopCart(@RequestParam("u_name") String uName,
                                       HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(uName);
        if (user != null) {
            long shopCartId = shopCartService.getSidByUid(user.getUId());
            user.setSId(shopCartId);
            session.setAttribute(uName, user);
            return productService.getProductsBySid(shopCartId);
        } else {
            return null;
        }
    }
}
