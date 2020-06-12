package com.sheng.hrt.dao;

import com.sheng.hrt.po.TestConfig;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestConfigDao {
    @Select("select * from testConfig")
    List<TestConfig> getAllTestConfig();
    @Insert("insert into testConfig(test_id,test_name,test_time)" +
            "values(null,#{test_name},#{test_time})")
    void addTestConfig(@Param("test_name") String test_name, @Param("test_time") String test_time);
    @Delete("delete from testConfig where id=#{test_id}")
    void delTestConfig(@Param("test_id") String test_id);
}
