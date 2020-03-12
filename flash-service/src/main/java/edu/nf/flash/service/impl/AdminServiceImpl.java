package edu.nf.flash.service.impl;/**
 * @ClassName: AdminServiceImpl
 * @Author: Zachery
 * @Data: 11:11
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.dao.AdminDao;
import edu.nf.flash.entity.Admin;
import edu.nf.flash.service.AdminService;
import edu.nf.flash.service.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: AdminServiceImpl
 * @Author: Zachery
 * @Data: 11:11
 **/
@Service("adminService")
@Transactional(rollbackFor = RuntimeException.class)
public class AdminServiceImpl implements AdminService {

    private static final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminDao dao;

    @Override
    public PageInfo<Admin> listAdmin(Integer pageNum, Integer pageSize) {
        try {
            List<Admin> list = dao.listAdmin(pageNum, pageSize);
            PageInfo<Admin> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public Admin findAdmin(Admin admin) {
        try {
            Admin ba = dao.getAdminById(admin);
            if(ba.getAdLogId().equals(admin.getAdLogId()) && ba.getAdLogPwd().equals(admin.getAdLogPwd())){
                return ba;
            }
            log.info("管理员消息:"+admin.getName()+"已登陆flash后台");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        throw new DataAccessException("用户名或密码错误!");
    }

    @Override
    public void register(Admin admin) {
        try {
            dao.addAdmin(admin);
            log.info("已成功添加"+admin.getName()+"的信息");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器繁忙，请稍后尝试");
        }
    }

    @Override
    public void deleteAdmin(String id) {
        try {
            dao.delAdmin(id);
            log.info("已删除ID为:"+id+"的管理员信息");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，删除失败");
        }
    }

    @Override
    public void updateAdmin(Admin admin) {
        try {
            dao.updateAdmin(admin);
            log.info("编号为:"+admin.getAdminId()+"的管理员信息已更新");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }
}
