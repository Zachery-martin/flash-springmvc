package edu.nf.flash.service;

import com.github.pagehelper.PageInfo;
import edu.nf.flash.entity.Orders;

/**
 * @ClassName: OrdersService
 * @Author: Zachery
 * @Data: 15:40
 **/
public interface OrdersService {

    /**
     *分页列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Orders> listOrders(Integer pageNum, Integer pageSize);

    /**
     * 创作者查询订单列表
     * @param autId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Orders> autListOrders(Integer pageNum, Integer pageSize,String autId);

    /**
     * 顾客查询订单列表
     * @param cusId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Orders> cusListOrders(Integer pageNum, Integer pageSize,String cusId);

    /**
     * 增
     * @param order
     */
    void addOrder(Orders order);

    /**
     * 删
     * @param id
     */
    void delOrders(String id);

    /**
     * 改
     * @param order
     */
    void updateOrder(Orders order);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    Orders getOrderById(String id);
}
