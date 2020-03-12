package edu.nf.flash.service;

import com.github.pagehelper.PageInfo;
import edu.nf.flash.entity.ReWorkUpdate;

/**
 * @ClassName: ReWorkUpdateService
 * @Author: Zachery
 * @Data: 09:51
 **/
public interface ReWorkUpdateService {

    /**
     *分页列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<ReWorkUpdate> listReWorkUpdate(Integer pageNum, Integer pageSize);

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
