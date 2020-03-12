package edu.nf.flash.service.impl;/**
 * @ClassName: ReWorkUpdateServiceImpl
 * @Author: Zachery
 * @Data: 20:20
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.dao.ReWorkUpdateDao;
import edu.nf.flash.entity.ReUpShelf;
import edu.nf.flash.entity.ReWorkUpdate;
import edu.nf.flash.service.ReWorkUpdateService;
import edu.nf.flash.service.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: ReWorkUpdateServiceImpl
 * @Author: Zachery
 * @Data: 20:20
 **/
@Service("reWorkUpdateService")
@Transactional(rollbackFor = RuntimeException.class)
public class ReWorkUpdateServiceImpl implements ReWorkUpdateService {

    private static final Logger log = LoggerFactory.getLogger(ReWorkUpdateServiceImpl.class);

    @Autowired
    private ReWorkUpdateDao dao;

    @Override
    public PageInfo<ReWorkUpdate> listReWorkUpdate(Integer pageNum, Integer pageSize) {
        try {
            List<ReWorkUpdate> list = dao.listReWorkUpdate(pageNum,pageSize);
            PageInfo<ReWorkUpdate> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public void addReWorkUpdate(ReWorkUpdate reWorkUpdate) {
        try {
            dao.addReWorkUpdate(reWorkUpdate);
            log.info("已成功添加编号为:"+reWorkUpdate.getUpdateId()+"的作者作品更新记录");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器繁忙，请稍后尝试");
        }
    }

    @Override
    public void delReWorkUpdate(String id) {
        try {
            dao.delReWorkUpdate(id);
            log.info("已成功删除编号为:"+id+"的作者作品更新记录");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器错误，删除失败");
        }
    }

    @Override
    public void updateReWorkUpdate(ReWorkUpdate reWorkUpdate) {
        try {
            dao.updateReWorkUpdate(reWorkUpdate);
            log.info("编号为:"+reWorkUpdate.getUpdateId()+"的作品更新记录已更新");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }

    @Override
    public ReWorkUpdate getReWorkUpdateById(String id) {
        try {
            ReWorkUpdate reWorkUpdate = dao.getReWorkUpdateById(id);
            log.info("根据"+id+"获取到"+reWorkUpdate.getUpdateId()+"作品更新记录");
            return reWorkUpdate;
        } catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("查询失败，请稍后重试");
        }
    }
}
