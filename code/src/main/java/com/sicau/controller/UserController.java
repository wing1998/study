package com.sicau.controller;

import com.sicau.pojo.UOrder;
import com.sicau.pojo.User;
import com.sicau.service.ProductService;
import com.sicau.service.ShopCartService;
import com.sicau.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
@ResponseBody
public class UserController {

    private UserService userService = null;
    private ShopCartService shopCartService = null;
    private ProductService productService = null;

    @Autowired
    public UserController(UserService userService,
                          ShopCartService shopCartService,
                          ProductService productService) {
        this.userService = userService;
        this.shopCartService = shopCartService;
        this.productService = productService;
    }

    @RequestMapping(value = "/userdata", method = RequestMethod.GET)
    public UOrder getUserDate(@RequestParam("u_name") String uName) {
        System.out.println(uName);
        return userService.getUserDataByUName(uName);
    }

    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    public ModelAndView registerUser(HttpServletRequest request) {
        String uName = request.getParameter("u_name");
        String uPass = request.getParameter("u_pass");
        User user = userService.registerUser(uName, uPass);
        HttpSession session = request.getSession();
        session.setAttribute(uName, user);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        mv.addObject("sessionId", session.getId());
        return mv;
    }

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response) {
        String uName = request.getParameter("u_name");
        String uPass = request.getParameter("u_pass");
        User user = new User();
        user.setUName(uName);
        user.setUPass(uPass);
        user = userService.getUserByUNameAndUPass(user);
        HttpSession session = request.getSession();
        session.setAttribute(uName, user);
        ModelAndView mv = new ModelAndView();

        Cookie cookie = new Cookie(uName, session.getId());
        response.addCookie(cookie);

        if (user.getUId() > 0) {
            mv.setViewName("index");
        } else {
            mv.setViewName("login");
        }
        return mv;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(@RequestParam("u_name") String uName,
                               HttpSession session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
