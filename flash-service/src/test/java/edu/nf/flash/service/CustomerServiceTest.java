package edu.nf.flash.service;

import edu.nf.flash.entity.Customer;
import edu.nf.flash.service.config.AppConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CustomerServiceTest {

    private final static Logger log = LoggerFactory.getLogger(CustomerServiceTest.class);

    @Test
    public void testUpdateOrdinaryCustomer() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService service = context.getBean("customerService", CustomerService.class);
        Customer c = new Customer();
        c.setCusLogId("cus");
        c.setName("顾客测试1号1");
        c.setPhone("1231");
        c.setAddress("广东珠海1");
        service.updateOrdinaryCustomer(c);
    }
}