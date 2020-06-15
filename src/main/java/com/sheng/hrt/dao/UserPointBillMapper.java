package com.sheng.hrt.dao;

import com.sheng.hrt.po.UserPointBill;
@org.apache.ibatis.annotations.Mapper
public interface UserPointBillMapper extends Mapper<UserPointBill,Long>{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_point_bill
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long billId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_point_bill
     *
     * @mbggenerated
     */
    int insert(UserPointBill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_point_bill
     *
     * @mbggenerated
     */
    int insertSelective(UserPointBill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_point_bill
     *
     * @mbggenerated
     */
    UserPointBill selectByPrimaryKey(Long billId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_point_bill
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(UserPointBill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_point_bill
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserPointBill record);
}