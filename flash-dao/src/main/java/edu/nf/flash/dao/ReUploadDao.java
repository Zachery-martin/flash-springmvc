package edu.nf.flash.dao;

import edu.nf.flash.entity.ReUpload;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: ReUpload
 * @Author: Zachery
 * @Data: 20:35
 **/
public interface ReUploadDao {

    /**
     * 列表
     * @return
     */
    List<ReUpload> listReUpload(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 创作者查询分页列表
     * @param autId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ReUpload> authListReUpload(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, String autId);


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
     * @param upLoadId
     * @return
     */
    ReUpload getReUploadById(ReUpload upLoadId);
}
