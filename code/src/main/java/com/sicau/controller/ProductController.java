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

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
@ResponseBody
public class ProductController {

    private UserService userService = null;
    private ShopCartService shopCartService = null;
    private ProductService productService = null;

    @Autowired
    public ProductController(UserService userService,
                             ShopCartService shopCartService,
                             ProductService productService) {
        this.userService = userService;
        this.shopCartService = shopCartService;
        this.productService = productService;
    }

    @RequestMapping(value = "/product_show", method = RequestMethod.GET)
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }

    /**
     * 1、可以加入验证用户是否登录的逻辑
     * 2、该处验证 HttpSession 类是否可以直接被注入使用
     * @param uName
     * @param session
     * @return
     */
    @RequestMapping(value = "/add_shop_cart", method = RequestMethod.GET)
    public boolean addShopCart(@RequestParam("u_name") String uName, HttpSession session) {
        User user = (User) session.getAttribute(uName);
        if (user != null) {
            long shopCartId = shopCartService.getSidByUid(user.getUId());
            user.setSId(shopCartId);
            session.setAttribute(uName, user);
            return productService.addShopCart(shopCartId);
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/buy_product", method = RequestMethod.GET)
    public boolean buyProduct(@RequestParam("p_id") long pId) {
        return productService.buyProduct(pId);
    }

    /**
     * @param pName 商品名称
     * @param pNum 商品数量
     * @param pPrice 商品价格
     * @param picture 商品展示图片链接
     * @return boolean 返回一个发布成功的布尔值
     */
    @RequestMapping(value = "/publish_product", method = RequestMethod.GET)
    public boolean publishProduct(@RequestParam("p_name") String pName,
                                  @RequestParam("p_num") long pNum,
                                  @RequestParam("p_price") double pPrice,
                                  @RequestParam("picture") String picture) {
        Product product = new Product();
        product.setPName(pName);
        product.setPNum(pNum);
        product.setPPrice(pPrice);
        product.setPicture(picture);
        return productService.publishProduct(product);
    }
}
