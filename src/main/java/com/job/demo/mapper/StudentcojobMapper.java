package com.job.demo.mapper;

import com.job.demo.entity.Studentcojob;
import com.job.demo.entity.StudentcojobExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

public interface StudentcojobMapper {
    int countByExample(StudentcojobExample example);

    int deleteByExample(StudentcojobExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Studentcojob record);

    int insertSelective(Studentcojob record);

    List<Studentcojob> selectByExample(StudentcojobExample example);

    Studentcojob selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Studentcojob record, @Param("example") StudentcojobExample example);

    int updateByExample(@Param("record") Studentcojob record, @Param("example") StudentcojobExample example);

    int updateByPrimaryKeySelective(Studentcojob record);

    int updateByPrimaryKey(Studentcojob record);

    @Update("update Studentcojob set state = #{state} where id = #{id}")
    int changeStatus(@Param("id")int id,@Param("state")int state);

    @Select("select * from Studentcojob t1, Student t2 where t1.sid=t2.sid and t1.jid =#{jid}")
    List<HashMap<String,Object>> selectEmpList(@Param("jid") int jid);
}