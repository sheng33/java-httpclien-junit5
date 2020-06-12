package com.sheng.hrt.dao;

import com.sheng.hrt.po.Application;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ApplicationDao {
    @Select("select * from Application")
    List<Application> getAllApplication();
    @Insert("insert into applicatino(app_id,app_name,app_code,app_subtitle,app_img," +
            "app_url,sort,app_status,last_operator_id,test_name)" +
            "values(null,#{app_name},#{app_code},#{app_subtitle},#{app_img}" +
            ",#{app_url},#{sort},#{app_status},#{last_operator_id},#{test_name})")
    void addApplication( @Param("app_name") String app_name, @Param("app_code") String app_code,
                        @Param("app_subtitle") String app_subtitle, @Param("app_img") String app_img, @Param("app_url") String app_url,
                        @Param("sort") int sort, @Param("app_status") int app_status, @Param("last_operator_id") String last_operator_id,
                        @Param("test_name") String test_name);
    @Delete("delete from application where app_id=#{app_id}")
    void delApplication(@Param("app_id") String app_id);
}
