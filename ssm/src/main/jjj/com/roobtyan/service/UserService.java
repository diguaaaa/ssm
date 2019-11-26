package com.roobtyan.service;
import com.roobtyan.pojo.Choice;

import com.roobtyan.pojo.Choicedetail;
import com.roobtyan.pojo.Game;
import com.roobtyan.pojo.ChoiceCustom;
import com.roobtyan.pojo.User;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.lang.String;

@Service
public interface UserService {
    void addGameService(Game game);
    List<Game> showGameService();
    void updateGameService(Game game);
    Game selectGameService(Integer gId);
    Integer delUserService(User user);
    void updateUserService(User user);
    ChoiceCustom selectUserService(String choiceId);
    List<ChoiceCustom> showUserService(String choiceId);
    void copyUserService(String gAddress) throws IOException;
    void insertChoice(Choice choice);
    void insertChoicedetail(Choicedetail Choicedetail);
//    void insertChoicedetails(Choicedetail Choicedetail);
    List<User> showUserTableService();
    List<ChoiceCustom> selectOrderService(Integer userId);

}
