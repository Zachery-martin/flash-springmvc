package edu.nf.flash.dao;

import edu.nf.flash.dao.config.DaoConfig;
import edu.nf.flash.entity.Orders;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: OrderDaoTest
 * @Author: Zachery
 * @Data: 14:22
 **/
public class OrdersDaoTest {

    private final static Logger log = LoggerFactory.getLogger(OrdersDaoTest.class);

    @Test
    public void testListOrder() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class);
        OrdersDao dao = context.getBean(OrdersDao.class);
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
        dao.addOrder(o);
    }
}