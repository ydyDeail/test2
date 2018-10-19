package org.ydy.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.ydy.domain.CustomerPageBean;
import org.ydy.entity.Area;
import org.ydy.entity.Customer;
import org.ydy.entity.Level;
import org.ydy.entity.Maneger;

import java.util.List;

public interface CustomerMapper {
    //查询当前用户的总数
    @Select("<script>SELECT COUNT(cust_no) FROM cst_customer\n" +
            "WHERE 1=1\n" +
            "<if test='cust_no!=null'>AND cust_no LIKE CONCAT('%',#{cust_no},'%')\n</if>" +
            "<if test='cust_name!=null'>AND cust_name LIKE CONCAT('%',#{cust_name},'%')\n</if>" +
            "<if test='cust_region!=null'>AND cust_region=#{cust_region}\n</if>" +
            "<if test='Cust_manager_name!=null'>AND Cust_manager_name=#{Cust_manager_name}\n</if>" +
            "<if test='cust_level_label!=null'>AND cust_level_label=#{cust_level_label}\n</if>" +
            "</script>")
    public int findCustomerCount(CustomerPageBean customerPageBean);
    //查询当前所有用户
    @Select("<script>SELECT * FROM cst_customer\n" +
            "WHERE 1=1\n" +
            "<if test='cust_no!=null'>AND cust_no LIKE CONCAT('%',#{cust_no},'%')\n</if>" +
            "<if test='cust_name!=null'>AND cust_name LIKE CONCAT('%',#{cust_name},'%')\n</if>" +
            "<if test='cust_region!=null'>AND cust_region=#{cust_region}\n</if>" +
            "<if test='Cust_manager_name!=null'>AND Cust_manager_name=#{Cust_manager_name}\n</if>" +
            "<if test='cust_level_label!=null'>AND cust_level_label=#{cust_level_label}\n</if>" +
            "LIMIT #{from},#{offset}" +
            "</script>")
    public List<Customer> showAllCustomer(CustomerPageBean customerPageBean);
    //查询所有地区
    @Select("SELECT cust_region FROM cst_customer GROUP BY cust_region")
    public List<Area> findAllArea();
    //查询所有用户等级
    @Select("SELECT cust_level,cust_level_label FROM cst_customer GROUP BY cust_level")
    public List<Level> findAllLevel();
    //查询所有客户经理
    @Select("SELECT cust_manager_id,Cust_manager_name FROM cst_customer GROUP BY cust_manager_id")
    public List<Maneger> findAllManeger();
    //按id查询客户
    @Select("SELECT * FROM cst_customer WHERE cust_no=#{cust_no}")
    public Customer customerInfo(@Param("cust_no") String cust_no);
    //修改客户信息
    @Update("<script>UPDATE cst_customer <set> " +
            "<if test='cust_name!=null'>cust_name=#{cust_name},\n</if>" +
            "<if test='cust_region!=null'>cust_region=#{cust_region},\n</if>" +
            "<if test='cust_manager_id!=0'>cust_manager_id=#{cust_manager_id},\n</if>" +
            "<if test='Cust_manager_name!=null'>Cust_manager_name=#{Cust_manager_name},\n</if>" +
            "<if test='cust_level!=0'>cust_level=#{cust_level},\n</if>" +
            "<if test='cust_level_label!=null'>cust_level_label=#{cust_level_label},\n</if>" +
            "<if test='cust_satisfy!=null'>cust_satisfy=#{cust_satisfy},\n</if>" +
            "<if test='cust_credit!=null'>cust_credit=#{cust_credit},\n</if>" +
            "<if test='cust_addr!=null'>cust_addr=#{cust_addr},\n</if>" +
            "<if test='cust_zip!=null'>cust_zip=#{cust_zip},\n</if>" +
            "<if test='cust_tel!=null'>cust_tel=#{cust_tel},\n</if>" +
            "<if test='cust_fax!=null'>cust_fax=#{cust_fax},\n</if>" +
            "<if test='cust_website!=null'>cust_website=#{cust_website},\n</if>" +
            "<if test='cust_licence_no!=null'>cust_licence_no=#{cust_licence_no},\n</if>" +
            "<if test='cust_chieftain!=null'>cust_chieftain=#{cust_chieftain},\n</if>" +
            "<if test='cust_bankroll!=null'>cust_bankroll=#{cust_bankroll},\n</if>" +
            "<if test='cust_turnover!=null'>cust_turnover=#{cust_turnover},\n</if>" +
            "<if test='cust_bank!=null'>cust_bank=#{cust_bank},\n</if>" +
            "<if test='cust_bank_account!=null'>cust_bank_account=#{cust_bank_account},\n</if>" +
            "<if test='cust_local_tax_no!=null'>cust_local_tax_no=#{cust_local_tax_no},\n</if>" +
            "<if test='cust_national_tax_no!=null'>cust_national_tax_no=#{cust_national_tax_no},\n</if>" +
            "</set> WHERE cust_no=#{cust_no}" +
            "</script>")
    public int updateCustomer(Customer customer);

    //查询经理id
    @Select("SELECT Dict_value FROM bas_activity WHERE Dict_item='#{Dict_item}'  AND Dict_type='职位'")
    public String findManegerId(@Param("Dict_item") String cust_manager_name);

    //查找客户等级id
    @Select("SELECT Dict_value FROM bas_activity WHERE Dict_item='#{Dict_item}' AND Dict_type='企业客户等级'")
    public String findLevelId(@Param("Dict_item") String cust_level_label);
}
