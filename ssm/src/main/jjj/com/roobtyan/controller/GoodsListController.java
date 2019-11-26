package com.roobtyan.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.roobtyan.common.JSON;
import com.roobtyan.pojo.*;
import com.roobtyan.service.UserService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SerializationUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@ResponseBody
@Controller
public class GoodsListController {
    @Autowired
    private UserService userService;

    /**
     * 跳转到管理员登录界面
     */
    @RequestMapping(value = "/toLogin")
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }

    /**
     * 加入购物车
     */
    @RequestMapping(value = "/addCart")
    public JSON addCart(Integer gId, HttpSession session){
        boolean flag = false;
        //通过id查询 游戏
        Game game = userService.selectGameService(gId);
        List<Choicedetail> cart = (List<Choicedetail>)session.getAttribute("cart");
        //获取session中用户信息
        User user = (User) session.getAttribute("user");
        if(user == null){
            throw new RuntimeException("用户未登录");
        }
        if(cart == null){
            cart = new ArrayList<>();
        }else{
            for(Choicedetail choicedetail : cart){
                if(choicedetail.getgId().equals(game.getgId())){
                    flag = true;
                    choicedetail.setCount(choicedetail.getCount()+1);
                    choicedetail.setSizeTotal(game.getgSize()*choicedetail.getCount());
                }
            }
        }

        if(!flag){
            Choicedetail choicedetail = new Choicedetail();
            choicedetail.setgId(game.getgId());
            choicedetail.setCount(1);
            choicedetail.setgSize(game.getgSize());
            cart.add(choicedetail);
            System.out.println(choicedetail.toString());
        }
        //计算总大小
        Double total = 0d;
        int countTotal = 0;
        for(Choicedetail choicedetail : cart){
            total += choicedetail.getgSize();
            countTotal += 1;
        }
        for(Choicedetail choicedetail : cart){
            choicedetail.setSizeTotal(total);
            choicedetail.setCount(countTotal);
            System.out.println(choicedetail.getSizeTotal());
        }
        session.setAttribute("cart",cart);
//        System.out.println(choicedetail);
        return JSON.ok(cart);
    }

    /**
     * 复选框批量加入购物车
     */
    @RequestMapping(value = "/buttomAddCart")
    public JSON buttomAddCart(@RequestBody String ids,HttpSession session){
        List<Choicedetail> cart = (List<Choicedetail>)session.getAttribute("cart");
        boolean flag = false;
        Double total = 0d;
        int countTotal = 0;
        User user = (User) session.getAttribute("user");
        List<Choicedetail> cart1 = JSONArray.parseArray(ids, Choicedetail.class);
        for(Choicedetail choicedetail:cart1){
            System.out.println(choicedetail);
        }

        if(user == null){
            throw new RuntimeException("用户未登录");
        }
        if(cart == null){
            cart = new ArrayList<>();
        }else{
            for(Choicedetail choicedetail:cart1) {
                for(Choicedetail choicedetail1:cart){
                    if(choicedetail.getgId().equals(choicedetail1.getgId())){
                        flag = true;
                    }
                }
            }
        }
        if(!flag){
            for(Choicedetail choicedetail:cart1) {
                Choicedetail choicedetail2 = new Choicedetail();
                choicedetail2.setgId(choicedetail.getgId());
                cart.add(choicedetail2);
            }
         }
        session.setAttribute("cart",cart);
        return JSON.ok("添加成功");
    }

    /**
     * 批量加购物车，保存在redis中
     */
    @RequestMapping(value = "/buttomAddCartRedis")
    public JSON buttomAddCartredis(@RequestBody String ids,HttpSession session){
        User user = (User)session.getAttribute("user");
        Integer userId = user.getUserId();
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println("1");
        byte[] userIdBs = SerializationUtils.serialize(userId);
        byte[] sCart = jedis.get(userIdBs);
        Choice choice1 = (Choice)SerializationUtils.deserialize(sCart);

        List<Choicedetail> cart1 = JSONArray.parseArray(ids, Choicedetail.class);
        System.out.println(cart1);
        Choice choice = new Choice();
        if(user == null){
            throw new RuntimeException("用户未登录");
        }
        System.out.println("2.25");
        if(sCart == null){
            System.out.println("2.5");
            Map<Integer,Choicedetail> cartMap = new HashMap<Integer,Choicedetail>();
            System.out.println("3");
            for(Choicedetail choicedetail:cart1){
                choicedetail.setCount(1);
                cartMap.put(choicedetail.getgId(),choicedetail);
            }
            System.out.println("3");
            choice.setCartMap(cartMap);
        }else{
            Map<Integer,Choicedetail> cartMap = choice1.getCartMap();
            System.out.println(cartMap);
            for(Choicedetail choicedetail:cart1) {
                choicedetail.setCount(1);
                cartMap.put(choicedetail.getgId(),choicedetail);
            }
            System.out.println(cartMap);
            choice.setCartMap(cartMap);
        }
        System.out.println("4");
        byte[] car = SerializationUtils.serialize(choice);
        byte[] userIDBs = SerializationUtils.serialize(userId);
        System.out.println("5");
        jedis.set(userIDBs,car);
        return JSON.ok();
    }

    /**
     * 將购物车保存在redis中，并用hashmap；
     */
    @RequestMapping(value = "/addCartRedis")
    public JSON addCartRedis(Integer gId, HttpServletRequest request){
        Game game = userService.selectGameService(gId);
        User user = (User)request.getSession().getAttribute("user");
        Integer userId = user.getUserId();
        System.out.println("连接redis");
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println("从redis获取购物车信息，判断购物车是否有商品");
        //JSONObject json = JSONObject.fromObject(userId);
        byte[] userIdBs = SerializationUtils.serialize(userId);
        byte[] sCart = jedis.get(userIdBs);
        System.out.println("购物车中的产品"+SerializationUtils.deserialize(sCart));
        Choice choice = new Choice();
        if(user == null){
            throw new RuntimeException("用户未登录");
        }
        if(sCart==null){
            Choicedetail choicedetail = new Choicedetail();
            Map<Integer, Choicedetail> cartMap = new HashMap<Integer, Choicedetail>();
            choicedetail.setgId(game.getgId());
            choicedetail.setCount(1);
            choicedetail.setgSize(game.getgSize());
            System.out.println("输出choicedetail对象中的gid");
            System.out.println(choicedetail);
            cartMap.put(game.getgId(),choicedetail);
            choice.setCartMap(cartMap);
        }else{
            //Map<Integer, Choicedetail> cartMap = new HashMap<Integer, Choicedetail>();
            choice = (Choice)SerializationUtils.deserialize(sCart);
            System.out.println("购物车存在商品sCart"+choice);
            if(choice.getCartMap().containsKey(gId)){
                Choicedetail choicedetail = choice.getCartMap().get(gId);
                choicedetail.setCount(choicedetail.getCount()+1);
            }else{
                Choicedetail choicedetail = new Choicedetail();
                choicedetail.setgId(game.getgId());
                choicedetail.setCount(1);
                choicedetail.setgSize(game.getgSize());
                choice.getCartMap().put(gId,choicedetail);
            }
        }
        System.out.println("序列化choice对象和userId");
        byte[] car = SerializationUtils.serialize(choice);
        byte[] userIDBs = SerializationUtils.serialize(userId);
        System.out.println("将对象序列化后插入redis");
        jedis.set(userIDBs,car);
        System.out.println(SerializationUtils.deserialize(userIDBs));
        return JSON.ok();
    }

    /**
     * 显示购物车信息
     */
    @RequestMapping(value = "/showMyCart")
    public JSON showMyCart(HttpSession session){
        List<Choicedetail> cart = (List<Choicedetail>)session.getAttribute("cart");
        List<Game> gameList = new ArrayList<>();
        for(Choicedetail choicedetail1:cart){
             Game game1 = userService.selectGameService(choicedetail1.getgId());
             gameList.add(game1);
        }
        for(Game game1:gameList) {
            System.out.print(game1.getgId());
            System.out.print(game1.getgName());
            System.out.print(game1.getgAddress());
            System.out.println(game1.getgSize());
        }
        System.out.println(gameList);
        return JSON.ok(gameList);
    }

    /**
     * 显示redis购物车中信息
     */
    @RequestMapping(value = "/showRedis")
    public JSON showRedis(HttpSession session){
        User user = (User)session.getAttribute("user");
        Integer userId = user.getUserId();
        Jedis jedis = new Jedis("127.0.0.1",6379);
        byte[] userIdBs = SerializationUtils.serialize(userId);
        byte[] sCart = jedis.get(userIdBs);
        Choice choice = (Choice)SerializationUtils.deserialize(sCart);
        Choicedetail choicedetail = new Choicedetail();
        List<Game> gameList2 = new ArrayList<>();
        Map<Integer, Choicedetail> cartMap1;
        cartMap1 = choice.getCartMap();
        System.out.println(choice);
        for(Map.Entry<Integer,Choicedetail> entry:cartMap1.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            Game game2 = userService.selectGameService(entry.getValue().getgId());
            gameList2.add(game2);
        }
        System.out.println(cartMap1);
        return JSON.ok(gameList2);
    }

    /**
     * 删除redis中购物车信息
     */
    @RequestMapping(value = "/removeRedis")
    public JSON removeRedis(Integer gId ,HttpSession session){
        User user = (User)session.getAttribute("user");
        Integer userId = user.getUserId();
        Jedis jedis = new Jedis("127.0.0.1",6379);
        byte[] userIdBs = SerializationUtils.serialize(userId);
        byte[] car = jedis.get(userIdBs);
        Choice choice = (Choice)SerializationUtils.deserialize(car);
        Map<Integer,Choicedetail> cartMap = choice.getCartMap();
        //Choicedetail choicedetail2 = cartMap.get(gId);
        cartMap.remove(gId);
        choice.setCartMap(cartMap);
        byte[] deletechoice = SerializationUtils.serialize(choice);
        byte[] deleteuserId = SerializationUtils.serialize(userId);
        jedis.set(deleteuserId,deletechoice);
        return JSON.ok();
    }

    /**
     * 批量移除购物车（redis）中商品
     */
    @RequestMapping(value = "/buttomRemoveRedis")
    public JSON buttomRemoveRedis(@RequestBody String ids,HttpSession session){
        User user = (User)session.getAttribute("user");
        List<Choicedetail> cart1 = JSONArray.parseArray(ids,Choicedetail.class);
        Jedis jedis = new Jedis("127.0.0.1",6379);
        byte[] userIdBs = SerializationUtils.serialize(user.getUserId());
        byte[] sCart = jedis.get(userIdBs);
        Choice choice = (Choice)SerializationUtils.deserialize(sCart);
        Map<Integer,Choicedetail> cartMap = choice.getCartMap();
        for(Choicedetail choicedetail:cart1){
            cartMap.remove(choicedetail.getgId());
        }
        System.out.println("1");
        choice.setCartMap(cartMap);
        byte[] deletechoice = SerializationUtils.serialize(choice);
        byte[] deleteuserId = SerializationUtils.serialize(user.getUserId());
        jedis.set(deleteuserId,deletechoice);
        return JSON.ok();
    }

    /**
     * 删除购物车信息
     */
    @RequestMapping(value = "/removeCart")
    public JSON removeCart(Integer gId,HttpSession session){
        List<Choicedetail> cart = (List<Choicedetail>)session.getAttribute("cart");
        for(Choicedetail choicedetail1:cart){
            if(choicedetail1.getgId()==gId){
//            Game game1 = userService.selectGameService(choicedetail1.getgId());
            cart.remove(choicedetail1);
            session.setAttribute("cart",cart);
            return JSON.ok();
            }
        }
        return JSON.ok();
    }

    /**
     * 批量移除购物车
     */@RequestMapping(value="/buttomRemoveCart")
    public JSON buttomRemoveCart(@RequestBody String ids,HttpSession session){
        List<Choicedetail> cart1 = JSONArray.parseArray(ids, Choicedetail.class);
        List<Choicedetail> cart = (List<Choicedetail>)session.getAttribute("cart");
        for(Iterator<Choicedetail> it = cart1.iterator(); it.hasNext();){
            for(Iterator<Choicedetail> it2 = cart.iterator(); it2.hasNext();){
                Choicedetail choicedetail=it.next();
                Choicedetail choicedetail1=it2.next();
                if(choicedetail.getgId()==choicedetail1.getgId()){
                    cart.remove(choicedetail1);
                }
            }
        }
        session.setAttribute("cart",cart);
        return JSON.ok();
    }



    /**
     * 提交订单
     */
    @RequestMapping(value = "/submitOrder")
    public JSON submitOrder(HttpSession session,Integer gId){
        //获取当前时间作为订单编号
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
//        int suiji = (int)(Math.random()*(9999 - 1000 + 1) + 1000); 获取指定位数公式
        User user = (User) session.getAttribute("user");
        Jedis jedis = new Jedis("127.0.0.1",6379);
        byte[] userIdBs = SerializationUtils.serialize(user.getUserId());
        byte[] sCart = jedis.get(userIdBs);
        String orderNum = (df.format(new Date())+user.getUserId());
        Choice choice = (Choice)SerializationUtils.deserialize(sCart);
        System.out.println(choice);
        if(choice.getChoiceId() != null) {
            Choicedetail choicedetail1 = new Choicedetail();
            Map<Integer,Choicedetail> cartMap = choice.getCartMap();
            //如果购物车不为空，遍历购物车，直接从购物车获取信息
            Set<Map.Entry<Integer,Choicedetail>> entry = cartMap.entrySet();
            Iterator<Map.Entry<Integer,Choicedetail>> it=entry.iterator();
            while(it.hasNext()){
                Map.Entry<Integer,Choicedetail> en = it.next();
                if(en.getValue().getgId()==gId) {
                    choicedetail1.setgId(en.getValue().getgId());
                    choicedetail1.setgSize(en.getValue().getgSize());
                    choicedetail1.setChoiceId(orderNum);
                    it.remove();
                }
            }
        }else{
//            List<Game> gameList = new ArrayList<>();
            //如果购物车为空，新创建对象choicedetail，
            Game game = userService.selectGameService(gId);
            Choicedetail choicedetail = new Choicedetail();
            choicedetail.setChoiceId(orderNum);
            choicedetail.setgId(gId);
            choicedetail.setgSize(game.getgSize());
            userService.insertChoicedetail(choicedetail);
        }
        return JSON.ok(orderNum);
    }

    /**
     * 批量提交订单到mysql中
     */
    @RequestMapping(value ="submitOrderRedis")
    public JSON submitOrderRedis(@RequestBody String ids,HttpSession session){
        User user = (User)session.getAttribute("user");
        Jedis jedis = new Jedis("127.0.0.1",6379);
        byte[] userIdBs = SerializationUtils.serialize(user.getUserId());
        byte[] sCart = jedis.get(userIdBs);
        List<Choicedetail> cart1 = JSONArray.parseArray(ids,Choicedetail.class);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderNum = (df.format(new Date())+user.getUserId());
        Choice choice = (Choice)SerializationUtils.deserialize(sCart);
        if(choice.getChoiceId() != null){
            Map<Integer,Choicedetail> cartMap = choice.getCartMap();
            Choicedetail choicedetail1 = new Choicedetail();
            Set<Map.Entry<Integer,Choicedetail>> entry = cartMap.entrySet();
            Iterator<Map.Entry<Integer,Choicedetail>> it=entry.iterator();
            while(it.hasNext()){
                Map.Entry<Integer,Choicedetail> en = it.next();
                choicedetail1.setChoiceId(orderNum);
                choicedetail1.setgId(en.getValue().getgId());
                choicedetail1.setgSize(en.getValue().getgSize());
                userService.insertChoicedetail(choicedetail1);
                it.remove();
            }
            choice.setCartMap(cartMap);
            byte[] userIdBs2 = SerializationUtils.serialize(user.getUserId());
            byte[] choice2 = SerializationUtils.serialize(choice);
            jedis.set(userIdBs2,choice2);
        }else{
            Choicedetail choicedetail1 = new Choicedetail();
            for(Choicedetail choicedetail:cart1){
                choicedetail1.setChoiceId(orderNum);
                choicedetail1.setgId(choicedetail.getgId());
                choicedetail1.setgSize(choicedetail.getgSize());
                userService.insertChoicedetail(choicedetail1);
            }
        }
        return JSON.ok();
    }

    /**
     * 显示订单
     */
    @RequestMapping(value = "/showOrderList")
    public JSON copyOrder(HttpSession session){
        User user = (User)session.getAttribute("user");
        Integer userId = user.getUserId();
        List<ChoiceCustom> choiceCustom = userService.selectOrderService(userId);
        System.out.println(choiceCustom);
        return JSON.ok(choiceCustom);
    }


}
