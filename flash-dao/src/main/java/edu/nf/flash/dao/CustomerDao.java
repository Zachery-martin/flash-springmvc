package edu.nf.flash.dao;

import edu.nf.flash.entity.Author;
import edu.nf.flash.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: Customer
 * @Author: Zachery
 * @Data: 20:34
 **/
public interface CustomerDao {

    /**
     * 列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Customer> listCustomer(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 增
     * @param customer
     */
    void addCustomer(Customer customer);

    /**
     * 删
     * @param id
     */
    void delCustomer(String id);

    /**
     * 改
     * @param customer
     */
    void updateCustomer(Customer customer);

    /**
     * 普通修改
     * @param customer
     */
    void updateOrdinaryCustomer(Customer customer);

    /**
     * 修改收货地址
     * @param customer
     */
    void updateAddressCustomer(Customer customer);

    /**
     * 修改密码
     * @param customer
     */
    void  updateCustomerPwd(Customer customer);

    /**
     * 根据id获取
     * @param customer
     * @return
     */
    Customer getCustomerById(Customer customer);
}
