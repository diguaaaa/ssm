package com.roobtyan.service.Impl;
import com.roobtyan.dao.LoginMapper;
import com.roobtyan.dao.UserMapper;
import com.roobtyan.pojo.Login;
import com.roobtyan.pojo.LoginExample;
import com.roobtyan.pojo.User;
import com.roobtyan.pojo.UserExample;
import com.roobtyan.service.LoginService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public Login LoginServiceA(Login login){
        LoginExample loginExample = new LoginExample();
        LoginExample.Criteria criteria = loginExample.createCriteria();
        criteria.andUserNameEqualTo(login.getUserName());
        criteria.andPassWordEqualTo(login.getPassWord());
        List<Login> lo = loginMapper.selectByExample(loginExample);

        System.out.println("loginServiceImpl");
        if(lo.size()!=0){
            return lo.get(0);
        }
        return null;
    }

    @Override
    public User ClientLogin(User user){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        criteria.andUserPassEqualTo(user.getUserPass());
        List<User> use = userMapper.selectByExample(userExample);
        if(use.size()!=0){
            return use.get(0);
        }
        return null;
    }
}
