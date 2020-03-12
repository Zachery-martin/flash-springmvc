package edu.nf.flash.controller;/**
 * @ClassName: OrdersController
 * @Author: Zachery
 * @Data: 16:03
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.controller.util.UUIDUtils;
import edu.nf.flash.controller.vo.ResponseVO;
import edu.nf.flash.entity.Customer;
import edu.nf.flash.entity.Orders;
import edu.nf.flash.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: OrdersController
 * @Author: Zachery
 * @Data: 16:03
 **/
@RestController
public class OrdersController extends BaseController{

    @Autowired
    private OrdersService service;

    @GetMapping("/list_order")
    public ResponseVO<PageInfo> listOrders(Integer pageNum, Integer pageSize){
        PageInfo<Orders> pageInfo = service.listOrders(pageNum, pageSize);
        return success(pageInfo);
    }


    @GetMapping("/auth_list_order")
    public ResponseVO<PageInfo> authListOrders(Integer pageNum, Integer pageSize,String autId){
        PageInfo<Orders> pageInfo = service.autListOrders(pageNum, pageSize,autId);
        return success(pageInfo);
    }


    @GetMapping("/cus_list_order")
    public ResponseVO<PageInfo> cusListOrders(Integer pageNum, Integer pageSize,String cusId){
        System.out.printf(cusId);
        PageInfo<Orders> pageInfo = service.cusListOrders(pageNum, pageSize,cusId);
        return success(pageInfo);
    }

    @PostMapping("/order_add")
    public ResponseVO addOrders(HttpServletRequest request,
                                @Valid Orders orders, HttpSession session){
        Customer c = (Customer) session.getAttribute("customer");
        orders.setOid("ord-"+ UUIDUtils.createExtractionCode());
        orders.setCusId(c.getCusId());
        orders.setReAddress(c.getReAddress1());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createdate = sdf.format(date);
        orders.setTime(createdate);
        orders.setPayment("否");
        service.addOrder(orders);
        return success ("index.html");
    }

    @PostMapping("/order_del")
    public ResponseVO delOrders(HttpServletRequest request,
                                @Valid Orders orders){
        service.delOrders(orders.getOid());
        return success ("order.html");
    }

    @PostMapping("/order_update")
    public ResponseVO updateOrders(HttpServletRequest request,
                                @Valid Orders orders){
        service.updateOrder(orders);
        return success ("order-detailed.html");
    }
}
