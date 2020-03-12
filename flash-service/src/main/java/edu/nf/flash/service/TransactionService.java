package edu.nf.flash.service;

import com.github.pagehelper.PageInfo;
import edu.nf.flash.entity.Transaction;

/**
 * @ClassName: TransactionService
 * @Author: Zachery
 * @Data: 09:51
 **/
public interface TransactionService {

    /**
     *分页列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Transaction> listTransaction(Integer pageNum, Integer pageSize);


    /**
     * 创作者查询交易列表
     * @param autId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Transaction> autListTransaction(Integer pageNum, Integer pageSize,String autId);

    /**
     * 顾客查询交易列表
     * @param cusId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Transaction> cusListTransaction(Integer pageNum, Integer pageSize,String cusId);

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
