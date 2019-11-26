package com.roobtyan.controller;

import com.roobtyan.common.JSON;
import com.roobtyan.pojo.Login;
import com.roobtyan.pojo.User;
import com.roobtyan.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
@ResponseBody
@Controller
public class LoginController {
    @Autowired
//    private Login login;
    private LoginService loginService;
    private Login login = new Login();
    private User user = new User();

    /**
     * 登陆
     * @param loginname
     * @param password
     * * @return
     */
    @RequestMapping(value = "/login1")
    public JSON tologin(String loginname,String password,HttpSession session){
        login.setUserName(loginname);
        login.setPassWord(password);
//        if(login.getUserName()=liu) {
        User use = loginService.ClientLogin(user);
        if(use!=null){
//            System.out.println(lo);
            session.setAttribute("userName",use.getUserName());
            session.setAttribute("passWord",use.getUserPass());
            session.setAttribute("user",use);
            System.out.println("LoginController");
//            int p = lo.getPower();
            System.out.println(use);
            return JSON.ok(use);
        }else{
            return JSON.errorMsg("用户名或密码错误！");
        }
    }

    /**
     * 管理员，客户登录
     */
    @RequestMapping(value = "/clientLogin")
    public JSON clientLogin(Integer userId,String userPass,HttpSession session){
        user.setUserId(userId);
        user.setUserPass(userPass);
        User use = loginService.ClientLogin(user);
        if(use!=null){
//            session.setAttribute("userName",use.getUserName());
//            session.setAttribute("userPass",use.getUserPass());
            session.setAttribute("user",user);
            System.out.println(use.getUserPower());
//            int powerNum = use.getUserPower();
            return JSON.ok(use);
        }else{
//            return JSON.ok();
            return JSON.errorMsg("用户名或密码错误！");
        }
    }




}
