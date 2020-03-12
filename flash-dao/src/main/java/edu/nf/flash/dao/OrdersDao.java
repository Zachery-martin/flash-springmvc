package edu.nf.flash.dao;

import edu.nf.flash.entity.Orders;
import org.apache.ibatis.annotations.Param;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @ClassName: Order
 * @Author: Zachery
 * @Data: 20:34
 **/
public interface OrdersDao {

    /**
     * 分页列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Orders> listOrder(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 创作者查询分页列表
     * @param autId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Orders> authListOrder(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,String autId);

    /**
     * 顾客查询分页列表
     * @param cusId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Orders> cusListOrder(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,String cusId);


    /**
     * 增
     * @param order
     */
    void addOrder(Orders order);

    /**
     * 删
     * @param id
     */
    void delOrder(String id);

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
