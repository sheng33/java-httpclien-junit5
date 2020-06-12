package com.sheng.hrt.dao;

import com.sheng.hrt.po.TestPlan;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestPlanDao {
    @Select("select * from testPlan")
    List<TestPlan> getAllTestPlan();
    @Insert("insert into testPlan(id,application_id,channel_id,third_channel_id,point_id,test_id)" +
            "values(null,#{application_id},#{channel_id},#{third_channel_id},#{point_id},#{test_id})")
    void addTestPlan(@Param("application_id") String application_id, @Param("channel_id") String channel_id,
                     @Param("third_channel_id") String third_channel_id,@Param("point_id") String point_id,
                     @Param("test_id") String test_id);
    @Delete("delete from testPlan where id=#{test_id}")
    void delTestPlan(@Param("test_id") String test_id);
}
