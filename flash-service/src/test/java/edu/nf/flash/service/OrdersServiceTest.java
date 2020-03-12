package edu.nf.flash.service;

import edu.nf.flash.entity.Orders;
import edu.nf.flash.service.config.AppConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OrdersServiceTest {

    private final static Logger log = LoggerFactory.getLogger(OrdersServiceTest.class);
    @Test
    public void testAutListOrders() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        OrdersService service = context.getBean("ordersService", OrdersService.class);
        Orders o = new Orders();
        java.util.Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createdate = sdf.format(date);
        o.setTime(createdate);
        o.setOid("111");
        o.setCusId("111");
        o.setAutId("111");
        o.setReAddress("asdasd");
        o.setPrice(BigDecimal.valueOf(12));
        o.setPayment("是");
        service.addOrder(o);
    }

}