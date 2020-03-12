package edu.nf.flash.service;/**
 * @ClassName: CustomerService
 * @Author: Zachery
 * @Data: 09:50
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.entity.Customer;

/**
 * @ClassName: CustomerService
 * @Author: Zachery
 * @Data: 09:50
 **/
public interface CustomerService {

    /**
     * 顾客列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Customer> listCustomer(Integer pageNum, Integer pageSize);

    /**
     * 顾客校验
     * @param customer
     * @return
     */
    Customer findCustomer(Customer customer);

    /**
     * 顾客注册
     * @param customer
     */
    void register(Customer customer);

    /**
     * 顾客注销
     * @param id
     */
    void delCustomer(String id);

    /**
     * 修改顾客信息
     * @param customer
     */
    void updateCustomer(Customer customer);

    /**
     * 普通修改
     * @param customer
     */
    void updateOrdinaryCustomer(Customer customer);

    /**
     * 设置收货地址
     * @param customer
     */
    void updateAddressCustomer(Customer customer);

    /**
     * 修改密码
     * @param customer
     */
    void  updateCustomerPwd(Customer customer);

}
