package org.ydy.service.impl;

/**
 * @author 姚端阳
 * @date 2018/10/13 15:25
 */
public class test {
    public static void main(String[] args){
        CustomerServiceImpl customerServiceimpl=new CustomerServiceImpl();
        String num=customerServiceimpl.findLevelId("大客户");
        System.out.print(num);
    }
}
