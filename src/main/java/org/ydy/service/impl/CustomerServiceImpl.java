package org.ydy.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.ydy.domain.CustomerPageBean;
import org.ydy.entity.Area;
import org.ydy.entity.Customer;
import org.ydy.entity.Level;
import org.ydy.entity.Maneger;
import org.ydy.mapper.CustomerMapper;
import org.ydy.service.CustomerService;

import java.util.List;

/**
 * @author 姚端阳
 * @date 2018/10/4 17:31
 */
@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomerMapper customerMapper;

    public CustomerMapper getCustomerMapper() {
        return customerMapper;
    }

    public void setCustomerMapper(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public void serParam(CustomerPageBean customerPageBean) {
        int count=customerMapper.findCustomerCount(customerPageBean);
        customerPageBean.setCount(count);
        customerPageBean.setList(customerMapper.showAllCustomer(customerPageBean));
    }

    @Override
    public List<Area> findAllArea() {
        return customerMapper.findAllArea();
    }

    @Override
    public List<Level> findAllLevel() {
        return customerMapper.findAllLevel();
    }

    @Override
    public List<Maneger> findAllManeger() {
        return customerMapper.findAllManeger();
    }

    @Override
    public Customer customerInfo(String cust_no) {
        return customerMapper.customerInfo(cust_no);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public String findManegerId(String cust_manager_name) {
        return customerMapper.findManegerId(cust_manager_name);
    }

    @Override
    public String findLevelId(String cust_level_label) {
        return customerMapper.findLevelId(cust_level_label);
    }

}
