package edu.nf.flash.dao;

import edu.nf.flash.entity.Admin;
import edu.nf.flash.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: AdminDao
 * @Author: Zachery
 * @Data: 20:33
 **/
public interface AdminDao {

    /**
     * 列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Admin> listAdmin(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 增
     * @param admin
     */
    void addAdmin(Admin admin);

    /**
     * 删
     * @param id
     */
    void delAdmin(String id);

    /**
     * 改
     * @param admin
     */
    void updateAdmin(Admin admin);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    Admin getAdminById(Admin admin);

}
