package edu.nf.flash.service.impl;/**
 * @ClassName: OrdersServiceImpl
 * @Author: Zachery
 * @Data: 15:47
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.dao.OrdersDao;
import edu.nf.flash.entity.Orders;
import edu.nf.flash.service.OrdersService;
import edu.nf.flash.service.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: OrdersServiceImpl
 * @Author: Zachery
 * @Data: 15:47
 **/
@Service("ordersService")
@Transactional(rollbackFor = RuntimeException.class)
public class OrdersServiceImpl implements OrdersService {

    private static final Logger log = LoggerFactory.getLogger(OrdersServiceImpl.class);

    @Autowired
    private OrdersDao dao;

    @Override
    public PageInfo<Orders> listOrders(Integer pageNum, Integer pageSize) {
        try {
            List<Orders> list = dao.listOrder(pageNum,pageSize);
            PageInfo<Orders> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public PageInfo<Orders> autListOrders( Integer pageNum, Integer pageSize,String autId) {
        try {
            List<Orders> list = dao.authListOrder(pageNum,pageSize,autId);
            PageInfo<Orders> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public PageInfo<Orders> cusListOrders( Integer pageNum, Integer pageSize,String cusId) {
        try {
            List<Orders> list = dao.cusListOrder(pageNum,pageSize,cusId);
            PageInfo<Orders> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public void addOrder(Orders order) {
        try {
            dao.addOrder(order);
            log.info("已成功添加编号为:"+order.getOid()+"的订单信息");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器繁忙，请稍后尝试");
        }
    }

    @Override
    public void delOrders(String id) {
        try {
            dao.delOrder(id);
            log.info("已成功删除编号为:"+id+"的订单信息");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器错误，删除失败");
        }
    }

    @Override
    public void updateOrder(Orders order) {
        try {
            dao.updateOrder(order);
            log.info("编号为:"+order.getOid()+"的订单信息已更新");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }

    @Override
    public Orders getOrderById(String id) {
        try {
            Orders order = dao.getOrderById(id);
            log.info("根据"+id+"获取到"+order.getCusId()+"顾客订单的详细信息");
            return order;
        } catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("查询失败，请稍后重试");
        }
    }
}
