package edu.nf.flash.dao;

import edu.nf.flash.dao.config.DaoConfig;
import edu.nf.flash.entity.Admin;
import edu.nf.flash.entity.Customer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName: CustomerDaoTest
 * @Author: Zachery
 * @Data: 11:55
 **/
public class CustomerDaoTest {

    private final static Logger log = LoggerFactory.getLogger(CustomerDaoTest.class);
    @Test
    public void testListCustomer() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class);
        CustomerDao dao = context.getBean(CustomerDao.class);
        List<Customer> list = dao.listCustomer(1,5);
        list.forEach((Customer)->log.info(Customer.getName()));
    }
    @Test
    public void testUpdateOrdinaryCustomer() {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoConfig.class);
        CustomerDao dao = context.getBean(CustomerDao.class);
        Customer c = new Customer();
        c.setCusLogId("cus");
        c.setName("顾客测试1号");
        c.setPhone("123");
        c.setAddress("广东珠海");
        dao.updateOrdinaryCustomer(c);
    }
}