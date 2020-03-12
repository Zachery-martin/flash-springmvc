package edu.nf.flash.service;

import com.github.pagehelper.PageInfo;
import edu.nf.flash.entity.ReUpShelf;
import edu.nf.flash.entity.ReUpload;

/**
 * @ClassName: ReUpShelf
 * @Author: Zachery
 * @Data: 09:50
 **/
public interface ReUpShelfService {

    /**
     *分页列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<ReUpShelf> listReUpShelf(Integer pageNum, Integer pageSize);

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
     * @param reUpShelf
     */
    void updateReUpShelf(ReUpShelf reUpShelf);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    ReUpShelf getReUpShelfById(String id);
}
