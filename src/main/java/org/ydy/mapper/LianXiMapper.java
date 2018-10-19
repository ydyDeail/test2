package org.ydy.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ydy.entity.LianXi;

import java.util.List;

public interface LianXiMapper {
    @Select("SELECT * FROM cst_linkman WHERE lkm_cust_no=#{lkm_cust_no}")
    public List<LianXi> findAll(@Param("lkm_cust_no") String lkm_cust_no);

    @Select("SELECT * FROM cst_linkman WHERE lkm_id=#{lkm_id}")
    public LianXi findInfo(@Param("lkm_id") int lkm_id);

    @Update("<script>UPDATE cst_linkman SET \n" +
            "<if test='lkm_name!=null'>lkm_name=#{lkm_name},</if>\n" +
            "lkm_sex=#{lkm_sex},\n" +
            "<if test='lkm_postion!=null'>lkm_postion=#{lkm_postion},</if>\n" +
            "<if test='lkm_tel!=null'>lkm_tel=#{lkm_tel},</if>\n" +
            "<if test='lkm_mobile!=null'>lkm_mobile=#{lkm_mobile},</if>\n" +
            "<if test='lkm_memo!=null'>lkm_memo=#{lkm_memo}</if>\n" +
            "WHERE lkm_id=#{lkm_id}" +
            "</script>")
    public int updateLianXi(LianXi lx);
    @Insert("INSERT INTO cst_linkman(lkm_cust_no,lkm_cust_name,lkm_name,lkm_sex,lkm_postion,lkm_tel,lkm_mobile,lkm_memo) \n" +
            "VALUE(#{lkm_cust_no},#{lkm_cust_name},#{lkm_name},#{lkm_sex},#{lkm_postion},#{lkm_tel},#{lkm_mobile},#{lkm_memo})")
    public int addLianXi(LianXi lx);
}
