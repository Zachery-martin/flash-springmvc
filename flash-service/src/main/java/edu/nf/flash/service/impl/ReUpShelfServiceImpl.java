package edu.nf.flash.service.impl;/**
 * @ClassName: ReUpShelfServiceImpl
 * @Author: Zachery
 * @Data: 20:08
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.dao.ReUpShelfDao;
import edu.nf.flash.dao.ReUploadDao;
import edu.nf.flash.entity.ReUpShelf;
import edu.nf.flash.entity.ReUpload;
import edu.nf.flash.service.ReUpShelfService;
import edu.nf.flash.service.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: ReUpShelfServiceImpl
 * @Author: Zachery
 * @Data: 20:08
 **/
@Service("reUpShelfService")
@Transactional(rollbackFor = RuntimeException.class)
public class ReUpShelfServiceImpl implements ReUpShelfService {

    private static final Logger log = LoggerFactory.getLogger(ReUpShelfServiceImpl.class);

    @Autowired
    private ReUpShelfDao dao;

    @Override
    public PageInfo<ReUpShelf> listReUpShelf(Integer pageNum, Integer pageSize) {
        try {
            List<ReUpShelf> list = dao.listReUpShelf(pageNum,pageSize);
            PageInfo<ReUpShelf> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public void addReUpShelf(ReUpShelf reUpShelf) {
        try {
            dao.addReUpShelf(reUpShelf);
            log.info("已成功添加编号为:"+reUpShelf.getRid()+"的作者上架记录");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器繁忙，请稍后尝试");
        }
    }

    @Override
    public void delReUpShelf(String id) {
        try {
            dao.delReUpShelf(id);
            log.info("已成功删除编号为:"+id+"的作者上架记录");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器错误，删除失败");
        }
    }

    @Override
    public void updateReUpShelf(ReUpShelf reUpShelf) {
        try {
            dao.updateReUpShelf(reUpShelf);
            log.info("编号为:"+reUpShelf.getRid()+"的详细信息已更新");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }

    @Override
    public ReUpShelf getReUpShelfById(String id) {
        try {
            ReUpShelf reUpShelf = dao.getReUpShelfById(id);
            log.info("根据"+id+"获取到"+reUpShelf.getRid()+"作者上架记录");
            return reUpShelf;
        } catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("查询失败，请稍后重试");
        }
    }
}
