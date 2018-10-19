package org.ydy.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ydy.entity.Activity;

import java.util.List;

public interface ActivityMapper {
    @Select("SELECT * FROM cst_activity WHERE Atv_cust_no=#{Atv_cust_no}")
    public List<Activity> findAll(@Param("Atv_cust_no") String Atv_cust_no);

    @Select("SELECT * FROM cst_activity WHERE Atv_id=#{Atv_id}")
    public Activity findAInfo(@Param("Atv_id") int Atv_id);

    @Update("<script>UPDATE cst_activity <set> \n" +
            "<if test='Atv_date!=null'>Atv_date=#{Atv_date},</if>\n" +
            "<if test='Atv_place!=null'>Atv_place=#{Atv_place},</if>\n" +
            "<if test='Atv_title!=null'>Atv_title=#{Atv_title},</if>\n" +
            "<if test='Atv_desc!=null'>Atv_desc=#{Atv_desc},</if>\n" +
            "<if test='Atv_beizhu!=null'>Atv_beizhu=#{Atv_beizhu}</if>\n" +
            "</set>WHERE Atv_id=#{Atv_id}" +
            "</script>")
    public int updateActivity(Activity activity);
}
