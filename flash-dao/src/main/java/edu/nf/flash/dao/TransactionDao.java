package edu.nf.flash.dao;

import edu.nf.flash.entity.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: Transaction
 * @Author: Zachery
 * @Data: 20:36
 **/
public interface TransactionDao {

    /**
     * 分页列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Transaction> listTransaction(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 创作者查询分页列表
     * @param autId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Transaction> authListTransaction(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,String autId);

    /**
     * 顾客查询分页列表
     * @param cusId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Transaction> cusListTransaction(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize,String cusId);

    /**
     * 增
     * @param transaction
     */
    void addTransaction(Transaction transaction);

    /**
     * 删
     * @param id
     */
    void delTransaction(String id);

    /**
     * 改
     * @param transaction
     */
    void updateTransaction(Transaction transaction);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    Transaction getTransactionById(String id);
}
