package edu.nf.flash.dao;

import edu.nf.flash.entity.ReWorkUpdate;

import java.util.List;

/**
 * @ClassName: ReWorkUpdate
 * @Author: Zachery
 * @Data: 20:36
 **/
public interface ReWorkUpdateDao {

    /**
     * 列表
     * @return
     */
    List<ReWorkUpdate> listReWorkUpdate(Integer pageNum, Integer pageSize);

    /**
     * 增
     * @param reWorkUpdate
     */
    void addReWorkUpdate(ReWorkUpdate reWorkUpdate);

    /**
     * 删
     * @param id
     */
    void delReWorkUpdate(String id);

    /**
     * 改
     * @param reWorkUpdate
     */
    void updateReWorkUpdate(ReWorkUpdate reWorkUpdate);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    ReWorkUpdate getReWorkUpdateById(String id);
}
