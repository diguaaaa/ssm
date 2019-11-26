package com.roobtyan.dao;

import com.roobtyan.pojo.Choicedetail;
import com.roobtyan.pojo.ChoicedetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChoicedetailMapper {
    int countByExample(ChoicedetailExample example);

    int deleteByExample(ChoicedetailExample example);

    int deleteByPrimaryKey(Integer choicedetailId);

    int insert(Choicedetail record);

    int insertSelective(Choicedetail record);

    List<Choicedetail> selectByExample(ChoicedetailExample example);

    Choicedetail selectByPrimaryKey(Integer choicedetailId);

    int updateByExampleSelective(@Param("record") Choicedetail record, @Param("example") ChoicedetailExample example);

    int updateByExample(@Param("record") Choicedetail record, @Param("example") ChoicedetailExample example);

    int updateByPrimaryKeySelective(Choicedetail record);

    int updateByPrimaryKey(Choicedetail record);
}