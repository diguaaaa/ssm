package com.roobtyan.dao;

import com.roobtyan.pojo.ChoiceCustom;
import com.roobtyan.pojo.User;

import java.util.List;

public interface ChoiceMapperCustom {
     List<ChoiceCustom> findUserAndGameResultMap(String choiceId);
     List<ChoiceCustom> findUserAndGameResultMapAndOrder(Integer userId);
     ChoiceCustom  findUserAndGameResultMap1(String choiceId);
}
