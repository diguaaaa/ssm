package com.roobtyan.service;
import com.roobtyan.pojo.Login;
import com.roobtyan.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    Login LoginServiceA(Login login);
    User ClientLogin(User user);
}
