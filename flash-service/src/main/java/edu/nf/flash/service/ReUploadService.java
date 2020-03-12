package edu.nf.flash.service;

import com.github.pagehelper.PageInfo;
import edu.nf.flash.entity.Orders;
import edu.nf.flash.entity.ReUpload;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: ReUploadService
 * @Author: Zachery
 * @Data: 09:51
 **/
public interface ReUploadService {

    /**
     *分页列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<ReUpload> listReUpload(Integer pageNum, Integer pageSize);


    /**
     * 创作者查询分页列表
     * @param autId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<ReUpload> authListReUpload(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, String autId);

    /**
     * 增
     * @param reUpload
     */
    void addReUpload(ReUpload reUpload);

    /**
     * 删
     * @param reUpload
     */
    void delReUpload(ReUpload reUpload);

    /**
     * 改
     * @param reUpload
     */
    void updateReUpload(ReUpload reUpload);

    /**
     * 根据id获取
     * @param reUpload
     * @return
     */
    ReUpload getReUploadById(ReUpload reUpload);
}
