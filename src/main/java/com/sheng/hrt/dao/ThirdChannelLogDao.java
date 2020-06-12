package com.sheng.hrt.dao;

import com.sheng.hrt.po.ThirdChannelLog;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ThirdChannelLogDao {
    @Select("select * from third_channel_log")
    List<ThirdChannelLog> getAllThirdChannelLog();
    @Insert("insert into third_channel_log(id,create_time,state_change,operator_id,remark,test_name)" +
            "value(null,#{create_time},#{state_change},#{operator_id},#{remark},#{test_name})")
    void addThirdChannelLog(@Param("create_time") String create_time, @Param("state_change") String state_change,
                     @Param("operator_id") String operator_id, @Param("remark") String remark,
                     @Param("test_name") String test_name);
    @Delete("delete from third_channel_log where id=#{id}")
    void delThirdChannelLog(@Param("id") String id);
}
