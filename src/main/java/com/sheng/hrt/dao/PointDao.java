package com.sheng.hrt.dao;

import com.sheng.hrt.po.Point;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PointDao {
    @Select("select * from point")
    List<Point> getAllPoint();
    @Insert("insert into point(point_id,point_name,point_exchange_rate,create_time,point_code,test_id)" +
            "values(null,#{point_name},#{point_exchange_rate},#{create_time},#{point_code},#{test_name})")
    void addPoint(@Param("point_name") String point_name, @Param("point_exchange_rate") String point_exchange_rate,
                       @Param("create_time") String create_time, @Param("point_code") String point_code,@Param("test_name") String test_name);
    @Delete("delete from point where id=#{point_id}")
    void delPoint(@Param("point_id") String point_id);

}
