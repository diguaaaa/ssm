package com.roobtyan.service.Impl;

import com.roobtyan.dao.*;

import com.roobtyan.pojo.*;
//import com.roobtyan.pojo.ChoiceCustom;

import com.roobtyan.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Integer;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class ServiceImpl implements UserService {
    @Autowired
    private GameMapper gameMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ChoiceMapperCustom choiceMapperCustom;
    @Autowired
    private ChoiceMapper choiceMapper;
    @Autowired
    private ChoicedetailMapper choicedetailMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;




    /**
     * 添加
     * @param game
     */
    @Override
    public void addGameService(Game game) {
        gameMapper.insert(game);
    }

    /**
     * 查询所有游戏
     */
    public List<Game> showGameService(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GameMapper gameMapper = sqlSession.getMapper(GameMapper.class);
        List<Game> list = gameMapper.selectAllGame();
        return list;
    }

    /**
     * 修改游戏列表
     */

    @Override
    public void updateGameService(Game game){
        gameMapper.updateByPrimaryKey(game);
    }

    /**
     * 通过游戏编号查询
     */
    public Game selectGameService(Integer gId){
        Game game = gameMapper.selectByPrimaryKey(gId);
        return game;
    }



    /**
     * 删除
     * @param user
     */
    @Override
    public Integer delUserService(User user){
       return(userMapper.deleteByPrimaryKey(user.getUserId()));
    }



    /**
     * 修改
     */
    @Override
    public void updateUserService(User user){
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 编辑游戏 -查询
     */

    public ChoiceCustom selectUserService(String choiceId){
        ChoiceCustom choiceCustom = choiceMapperCustom.findUserAndGameResultMap1(choiceId);

        return choiceCustom;
    }

    /**
     * 显示所有订单信息
     */
    public List<ChoiceCustom> showUserService(String choiceId){
        System.out.println("ServiceImpl");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建代理对象
        ChoiceMapperCustom choiceMapperCustom=sqlSession.getMapper(ChoiceMapperCustom.class);
        List<ChoiceCustom> list = new ArrayList<>();
        try {
         list = choiceMapperCustom.findUserAndGameResultMap(choiceId);
         //证明Mybatis一级缓存
//         System.out.println(list);
//         list = choiceMapperCustom.findUserAndGameResultMap(choiceId);
//         System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        ChoiceCustom choiceCustom1 = new ChoiceCustom();
        for(int i = 0; i<list.size();i++){
        }
////        System.out.println(list.get(0));
        return list;
    }

    /**
     * 显示所有用户账户信息
     */
    public List<User> showUserTableService(){
        List<User> list = userMapper.selectAllUser();
        return list;
    }

    /**
     * 实现拷贝
     * @param gAddress
     * @throws IOException
     */
    public void copyUserService(String gAddress)throws IOException {
        System.out.println(gAddress);
        String sourcefile= gAddress;
        String targetfile;
        switch(gAddress){
            case "D:\\守望先锋.txt":targetfile = "E:\\守望先锋.txt";break;
            case "D:\\生化危机.txt":targetfile = "E:\\生化危机.txt";break;
            default:targetfile = "E\\未命名.txt";
        }
        FileChannel sourcefc = new FileInputStream(sourcefile).getChannel();
        FileChannel targetfc = new FileOutputStream(targetfile).getChannel();
        sourcefc.transferTo(0,sourcefc.size(),targetfc);
    }

    /**
     *将choiceId和userId插入choice表
     */
    public void insertChoice(Choice choice){
         choiceMapper.insert(choice);
    }

    /**
     * 插入choicedetail表
     */
    public void insertChoicedetail(Choicedetail choicedetail){
        choicedetailMapper.insert(choicedetail);
    }

//    /**
//     * 批量插入choicedetail表
//     */
//    public void insertChoicedetails(Choicedetail choicedetail){
//        choicedetailMapper.insert(choicedetail);
//    }

    /**
     * 查询订单
     */
    public List<ChoiceCustom> selectOrderService(Integer userId){
        List<ChoiceCustom> list = choiceMapperCustom.findUserAndGameResultMapAndOrder(userId);
        return list;
    }

}
