package com.sheng.hrt.dao;

import com.sheng.hrt.po.DailyStatistic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DailyStatisticDao {
    @Select("select * from daily_statistic")
    List<DailyStatistic> getAllDailyStatistic();
    @Insert("insert into daily_statistic(id,point_id,create_time,issue_amount,consume_amount" +
            ",commision_amount,register_num,issue_count,issue_people_num,test_name)" +
            "values(null,#{point_id},#{create_time},#{issue_amount},#{consume_amount}" +
            ",#{commision_amount},#{register_num},#{issue_count},#{issue_people_num}" +
            ",#{test_name})")
    void addDailyStatistic(@Param("point_id") String point_id, @Param("create_time") String create_time,
                           @Param("issue_amount") String issue_amount, @Param("consume_amount") String consume_amount,
                           @Param("commision_amount") String commision_amount,@Param("register_num") String register_num,
                           @Param("issue_count") String issue_count,@Param("issue_people_num") String issue_people_num,
                           @Param("test_name") String test_name);
    @Delete("delete from daily_statistic where id=#{id}")
    void delDailyStatistic(@Param("id") String id);
}
