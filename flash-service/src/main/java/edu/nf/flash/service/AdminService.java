package edu.nf.flash.service;

import com.github.pagehelper.PageInfo;
import edu.nf.flash.entity.Admin;

/**
 * @ClassName: AdminService
 * @Author: Zachery
 * @Data: 11:10
 **/
public interface AdminService {

    /**
     * 管理员列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Admin> listAdmin(Integer pageNum, Integer pageSize);

    /**
     * 管理员验证登陆
     * @param admin
     * @return
     */
    Admin findAdmin(Admin admin);

    /**
     * 注册管理员
     * @param admin
     */
    void register(Admin admin);

    /**
     * 注销管理员
     * @param id
     */
    void deleteAdmin(String id);

    /**
     * 修改管理员用户信息
     * @param admin
     */
    void updateAdmin(Admin admin);
}
