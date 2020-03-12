package edu.nf.flash.controller;/**
 * @ClassName: CustomerController
 * @Author: Zachery
 * @Data: 20:33
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.controller.util.UUIDUtils;
import edu.nf.flash.controller.vo.ResponseVO;
import edu.nf.flash.entity.Customer;
import edu.nf.flash.entity.Orders;
import edu.nf.flash.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @ClassName: CustomerController
 * @Author: Zachery
 * @Data: 20:33
 **/
@RestController
public class CustomerController extends BaseController{

    @Autowired
    private CustomerService service;

    @GetMapping("/list_customer")
    public ResponseVO<PageInfo> listCustomer(Integer pageNum, Integer pageSize){
        PageInfo<Customer> pageInfo = service.listCustomer(pageNum, pageSize);
        return success(pageInfo);
    }

    @PostMapping("/customer_login")
    public ResponseVO login(@Valid Customer customer, HttpSession session){
        Customer backCustomer = service.findCustomer(customer);
        session.setAttribute("customer", backCustomer);
        System.out.println("顾客:"+backCustomer.getName()+"验证成功!并加入session作用域。");
        return success("index.html");
    }

    @GetMapping("/customer_getCus")
    public ResponseVO getOnLineCustomer(HttpSession session){
        Customer c = (Customer) session.getAttribute("customer");
        return success(c);
    }

    @GetMapping("/customer_Logout")
    public ResponseVO logOutCustomer(HttpSession session){
        session.removeAttribute("customer");
        return success("login.html");
    }

    @PostMapping("/customer_register")
    public ResponseVO registerCustomer(@Valid Customer customer){
        customer.setCusId("cus-"+ UUIDUtils.createExtractionCode());
        service.register(customer);
        return success ("login.html");
    }

    @PostMapping("/customer_del")
    public ResponseVO delCustomer(@Valid Customer customer){
        service.delCustomer(customer.getCusId());
        return success ("login.html");
    }

    @PostMapping("/customer_update")
    public ResponseVO updateCustomer(@Valid Customer customer, HttpSession session){
        service.updateCustomer(customer);
        return success ("login.html");
    }

    /**
     * 普通修改
     * @param customer
     * @param session
     * @return
     */
    @PostMapping("/customer_ordinary_update")
    public ResponseVO updateOrdinaryCustomer(@Valid Customer customer, HttpSession session){
        Customer c = (Customer) session.getAttribute("customer");
        customer.setCusLogId(c.getCusLogId());
        service.updateOrdinaryCustomer(customer);
        session.removeAttribute("customer");
        session.setAttribute("customer", customer);
        return success ("login.html");
    }

    /**
     * 修改收货地址
     * @param customer
     * @param session
     * @return
     */
    @PostMapping("/customer_address_update")
    public ResponseVO updateAddressCustomer(@Valid Customer customer, HttpSession session){
        Customer c = (Customer) session.getAttribute("customer");
        customer.setCusLogId(c.getCusLogId());
        service.updateAddressCustomer(customer);
        session.removeAttribute("customer");
        return success ("login.html");
    }

    /**
     * 修改密码
     * @param customer
     * @param session
     * @return
     */
    @PostMapping("/customer_pwd_update")
    public ResponseVO updateCustomerPwd(@Valid Customer customer, HttpSession session){
        Customer c = (Customer) session.getAttribute("customer");
        customer.setCusLogId(c.getCusLogId());
        service.updateCustomerPwd(customer);
        session.removeAttribute("customer");
        return success ("login.html");
    }

}
