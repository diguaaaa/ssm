package com.roobtyan.controller;


import com.roobtyan.common.JSON;
import com.roobtyan.pojo.ChoiceCustom;
import com.roobtyan.pojo.Game;
import com.roobtyan.pojo.User;
import com.roobtyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

@ResponseBody
@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    public User user;

    /**
     * 跳转到添加界面
     */
    @RequestMapping(value = "/toAddGame")
    public ModelAndView toAddGame(){
//        System.out.println(userId);
        return new ModelAndView("addGame");
    }


    /**
     * 添加
     */
    @RequestMapping (value = "/addGame")
    public JSON addUser(Game game){
        userService.addGameService(game);
        return JSON.ok();
    }

//    /**
//     * 跳转到游戏列表界面
//     */
//    @RequestMapping(value = "/toShowGame")
//    public ModelAndView toGameList(){
//        return new ModelAndView("showGame");
//    }

    /**
     * 游戏显示
     */
    @ResponseBody
    @RequestMapping(value = "/showGame")
//    RuntimeNode.Request request
    public JSON showGame(){
        List<Game> game = userService.showGameService();

        return JSON.ok(game);
    }

    /**
     * 跳转到订单列表
     */
    @RequestMapping(value = "/toIndex1")
    public ModelAndView toIndex1(){
        return new ModelAndView("index1");
    }

    /**
     * 携带id跳转到游戏修改界面
     */
    @RequestMapping(value = "/toEditGame")
    public ModelAndView toEditGame(Integer gId){
        return new ModelAndView("updateGame").addObject("gId",gId);
    }

    /**
     * 修改游戏列表
     */
    @RequestMapping(value = "/upGame")
    public JSON updateGame(Game game){
        userService.updateGameService(game);
        return JSON.ok();
    }

    /**
     * 返回游戏列表
     */
    @RequestMapping(value = "/toShowGame")
    public ModelAndView toShowGame(){
        return new ModelAndView("showGame");
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delUser")
    public JSON delUser(User user){
        userService.delUserService(user);
        return JSON.ok();
    }

    /**
     * 根据游戏编号查询
     */
    @ResponseBody
    @RequestMapping(value = "/selectGame" )
    public JSON selectGame(Integer gId){
        Game game = userService.selectGameService(gId);
        return JSON.ok(game);
    }

    /**
     * toPage
     */
//    @RequestMapping(value = "/toPage",method = {RequestMethod.GET})
//    public String sad(String page){
//        return page;
//    }

    /**
     * 修改带id跳转
     */

    @RequestMapping(value = "/toEditUser")
    public ModelAndView toEditUser(String choiceId){
        System.out.println(choiceId);
        return new ModelAndView("updateUser").addObject("choiceId",choiceId);
    }

    /**
     * 返回主界面
     */
    @RequestMapping(value = "/toShowUser")
    public ModelAndView toShowUser(){
        return new ModelAndView("index1");
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/upUser")
    public JSON updateUser(User user){
        userService.updateUserService(user);
        return JSON.ok();
    }

    /**
     * 查询
     */
    @ResponseBody
    @RequestMapping(value = "/selectUser" )
    public JSON selectUser(String choiceId){
        ChoiceCustom ChoiceCustom3 ;
        ChoiceCustom3 = userService.selectUserService(choiceId);
        System.out.println("selectUser");
        System.out.println(choiceId);
        System.out.println(ChoiceCustom3);
        return JSON.ok(ChoiceCustom3);

    }

    /**
     * 显示所有订单信息
     */
    @ResponseBody
    @RequestMapping(value = "/showUser")
    public JSON showUser(String choiceId){
        System.out.println("userController");
        List<ChoiceCustom> ChoiceCustom2 = userService.showUserService(choiceId);
//        System.out.println(ChoiceCustom2.toString());
//        System.out.println(ChoiceCustom2.toString());
        return JSON.ok(ChoiceCustom2);
    }

    /**
     * 显示所有用户信息
     */
    @ResponseBody
    @RequestMapping(value = "/showUserTable")
    public JSON showUserTable(){
        List<User> list = userService.showUserTableService();
        return JSON.ok(list);
    }

    /**
     * 拷贝文件到指定目录
     */

    @RequestMapping(value = "/toCopy")
    public JSON toCopy(String gAddress) throws IOException {
        userService.copyUserService(gAddress);
        return JSON.ok();
    }

}
