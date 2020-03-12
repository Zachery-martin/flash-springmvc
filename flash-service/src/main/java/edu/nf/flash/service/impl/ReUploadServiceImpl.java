package edu.nf.flash.service.impl;/**
 * @ClassName: ReUploadServiceiMPL
 * @Author: Zachery
 * @Data: 19:57
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.dao.OrdersDao;
import edu.nf.flash.dao.ReUploadDao;
import edu.nf.flash.entity.Orders;
import edu.nf.flash.entity.ReUpload;
import edu.nf.flash.service.ReUploadService;
import edu.nf.flash.service.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: ReUploadServiceiMPL
 * @Author: Zachery
 * @Data: 19:57
 **/
@Service("reUploadService")
@Transactional(rollbackFor = RuntimeException.class)
public class ReUploadServiceImpl implements ReUploadService {

    private static final Logger log = LoggerFactory.getLogger(ReUploadServiceImpl.class);

    @Autowired
    private ReUploadDao dao;

    @Override
    public PageInfo<ReUpload> listReUpload(Integer pageNum, Integer pageSize) {
        try {
            List<ReUpload> list = dao.listReUpload(pageNum,pageSize);
            PageInfo<ReUpload> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public PageInfo<ReUpload> authListReUpload(Integer pageNum, Integer pageSize, String autId) {
        try {
            List<ReUpload> list = dao.authListReUpload(pageNum,pageSize,autId);
            PageInfo<ReUpload> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public void addReUpload(ReUpload reUpload) {
        try {
            dao.addReUpload(reUpload);
            log.info("已成功添加编号为:"+reUpload.getUpLoadId()+"的作者上传记录");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器繁忙，请稍后尝试");
        }
    }

    @Override
    public void delReUpload(ReUpload reUpload) {
        try {
            dao.delReUpload(reUpload);
            log.info("已成功删除编号为:"+reUpload.getUpLoadId()+"的作者上传记录");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器错误，删除失败");
        }
    }

    @Override
    public void updateReUpload(ReUpload reUpload) {
        try {
            dao.updateReUpload(reUpload);
            log.info("编号为:"+reUpload.getUpLoadId()+"的作者上传记录已更新");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }

    @Override
    public ReUpload getReUploadById(ReUpload reUpload) {
        try {
            ReUpload backReUpload = dao.getReUploadById(reUpload);
            log.info("根据"+backReUpload.getUpLoadId()+"获取到"+reUpload.getUpLoadId()+"作者上传记录");
            return backReUpload;
        } catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("查询失败，请稍后重试");
        }
    }
}
