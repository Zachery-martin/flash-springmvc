package edu.nf.flash.service.impl;/**
 * @ClassName: CustomerServiceImpl
 * @Author: Zachery
 * @Data: 19:24
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.dao.CustomerDao;
import edu.nf.flash.entity.Customer;
import edu.nf.flash.service.CustomerService;
import edu.nf.flash.service.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: CustomerServiceImpl
 * @Author: Zachery
 * @Data: 19:24
 **/
@Service("customerService")
@Transactional(rollbackFor = RuntimeException.class)
public class CustomerServiceImpl implements CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);


    @Autowired
    private CustomerDao dao;

    @Override
    public PageInfo<Customer> listCustomer(Integer pageNum, Integer pageSize) {
        try {
            List<Customer> list = dao.listCustomer(pageNum, pageSize);
            PageInfo<Customer> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public Customer findCustomer(Customer customer) {
        try {
            Customer cu = dao.getCustomerById(customer);
            if(cu.getCusLogId().equals(customer.getCusLogId()) && cu.getCusLogPwd().equals(customer.getCusLogPwd())){
                return cu;
            }
            log.info("顾客消息:"+customer.getName()+"已登陆flash前台");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        throw new DataAccessException("用户名或密码错误!");
    }

    @Override
    public void register(Customer customer) {
        try {
            dao.addCustomer(customer);
            log.info("已成功添加"+customer.getName()+"的顾客信息");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器繁忙，请稍后尝试");
        }
    }

    @Override
    public void delCustomer(String id) {
        try {
            dao.delCustomer(id);
            log.info("已删除ID为:"+id+"的顾客信息");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，删除失败");
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            dao.updateCustomer(customer);
            log.info("编号为:"+customer.getName()+"的顾客信息已更新");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }

    /**
     * 普通修改
     * @param customer
     */
    @Override
    public void updateOrdinaryCustomer(Customer customer) {
        try {
            dao.updateOrdinaryCustomer(customer);
            log.info("顾客:"+customer.getName()+"的顾客普通信息已更新");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }

    /**
     * 设置收货地址
     * @param customer
     */
    @Override
    public void updateAddressCustomer(Customer customer) {
        try {
            dao.updateAddressCustomer(customer);
            log.info("顾客:"+customer.getName()+"的顾客收货地址已更新");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }

    /**
     * 修改密码
     * @param customer
     */
    @Override
    public void updateCustomerPwd(Customer customer) {
        try {
            dao.updateCustomerPwd(customer);
            log.info("顾客:"+customer.getName()+"的顾客密码已更新");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }
}
