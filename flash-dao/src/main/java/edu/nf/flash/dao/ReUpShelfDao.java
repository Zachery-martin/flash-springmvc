package edu.nf.flash.dao;

import edu.nf.flash.entity.ReUpShelf;

import java.util.List;

/**
 * @ClassName: ReUpShelf
 * @Author: Zachery
 * @Data: 20:35
 **/
public interface ReUpShelfDao {

    /**
     * 列表
     * @return
     */
    List<ReUpShelf> listReUpShelf(Integer pageNum, Integer pageSize);

    /**
     * 增
     * @param reUpShelf
     */
    void addReUpShelf(ReUpShelf reUpShelf);

    /**
     * 删
     * @param id
     */
    void delReUpShelf(String id);

    /**
     * 改
     * @param id
     */
    void updateReUpShelf(ReUpShelf id);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    ReUpShelf getReUpShelfById(String id);
}
