package edu.nf.flash.service.impl;/**
 * @ClassName: TransactionServiceImpl
 * @Author: Zachery
 * @Data: 20:27
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.dao.ReWorkUpdateDao;
import edu.nf.flash.dao.TransactionDao;
import edu.nf.flash.entity.ReWorkUpdate;
import edu.nf.flash.entity.Transaction;
import edu.nf.flash.service.TransactionService;
import edu.nf.flash.service.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: TransactionServiceImpl
 * @Author: Zachery
 * @Data: 20:27
 **/
@Service("transactionService")
@Transactional(rollbackFor = RuntimeException.class)
public class TransactionServiceImpl implements TransactionService {

    private static final Logger log = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionDao dao;

    @Override
    public PageInfo<Transaction> listTransaction(Integer pageNum, Integer pageSize) {
        try {
            List<Transaction> list = dao.listTransaction(pageNum,pageSize);
            PageInfo<Transaction> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public PageInfo<Transaction> autListTransaction(Integer pageNum, Integer pageSize, String autId) {
        try {
            List<Transaction> list = dao.authListTransaction(pageNum,pageSize,autId);
            PageInfo<Transaction> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public PageInfo<Transaction> cusListTransaction(Integer pageNum, Integer pageSize, String cusId) {
        try {
            List<Transaction> list = dao.cusListTransaction(pageNum,pageSize,cusId);
            PageInfo<Transaction> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }

    @Override
    public void addTransaction(Transaction transaction) {
        try {
            dao.addTransaction(transaction);
            log.info("已成功添加编号为:"+transaction.getTid()+"的交易记录");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器繁忙，请稍后尝试");
        }
    }

    @Override
    public void delTransaction(String id) {
        try {
            dao.delTransaction(id);
            log.info("已成功删除编号为:"+id+"的交易记录");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器错误，删除失败");
        }
    }

    @Override
    public void updateTransaction(Transaction transaction) {
        try {
            dao.updateTransaction(transaction);
            log.info("编号为:"+transaction.getTid()+"的交易记录已更新");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }

    @Override
    public Transaction getTransactionById(String id) {
        try {
            Transaction transaction = dao.getTransactionById(id);
            log.info("根据"+id+"获取到"+transaction.getTid()+"交易记录");
            return transaction;
        } catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("查询失败，请稍后重试");
        }
    }
}
