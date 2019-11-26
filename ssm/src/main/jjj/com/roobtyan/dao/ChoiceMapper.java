package com.roobtyan.dao;

import com.roobtyan.pojo.Choice;
import com.roobtyan.pojo.ChoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChoiceMapper {
    int countByExample(ChoiceExample example);

    int deleteByExample(ChoiceExample example);

    int deleteByPrimaryKey(String choiceId);

    int insert(Choice record);

    int insertSelective(Choice record);

    List<Choice> selectByExample(ChoiceExample example);

    Choice selectByPrimaryKey(String choiceId);

    int updateByExampleSelective(@Param("record") Choice record, @Param("example") ChoiceExample example);

    int updateByExample(@Param("record") Choice record, @Param("example") ChoiceExample example);

    int updateByPrimaryKeySelective(Choice record);

    int updateByPrimaryKey(Choice record);
}