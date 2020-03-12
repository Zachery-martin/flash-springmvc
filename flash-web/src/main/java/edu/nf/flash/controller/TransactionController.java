package edu.nf.flash.controller;/**
 * @ClassName: TransactionController
 * @Author: Zachery
 * @Data: 20:34
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.controller.util.DateUtils;
import edu.nf.flash.controller.util.UUIDUtils;
import edu.nf.flash.controller.vo.ResponseVO;
import edu.nf.flash.entity.Orders;
import edu.nf.flash.entity.Transaction;
import edu.nf.flash.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @ClassName: TransactionController
 * @Author: Zachery
 * @Data: 20:34
 **/
@RestController
public class TransactionController extends BaseController{

    @Autowired
    private TransactionService service;

    @GetMapping("/list_transaction")
    public ResponseVO<PageInfo> listTransaction(Integer pageNum, Integer pageSize){
        PageInfo<Transaction> pageInfo = service.listTransaction(pageNum, pageSize);
        return success(pageInfo);
    }


    @GetMapping("/aut_list_transaction")
    public ResponseVO<PageInfo> autListTransaction(Integer pageNum, Integer pageSize, String autId){
        PageInfo<Transaction> pageInfo = service.autListTransaction(pageNum, pageSize,autId);
        return success(pageInfo);
    }


    @GetMapping("/cus_list_transaction")
    public ResponseVO<PageInfo> cusListTransaction(Integer pageNum, Integer pageSize, String cusId){
        PageInfo<Transaction> pageInfo = service.cusListTransaction(pageNum, pageSize,cusId);
        return success(pageInfo);
    }

    @PostMapping("/transaction_add")
    public ResponseVO addTransaction(HttpServletRequest request,
                                @Valid Transaction transaction){
        transaction.setTid("tran-"+ UUIDUtils.createExtractionCode());
        service.addTransaction(transaction);
        return success ("transaction-record.html");
    }

    @PostMapping("/transaction_del")
    public ResponseVO delTransaction(HttpServletRequest request,
                                @Valid Transaction transaction){
        service.delTransaction(transaction.getTid());
        return success ("transaction-record.html");
    }

    @PostMapping("/transaction_update")
    public ResponseVO updateTransaction(HttpServletRequest request,
                                   @Valid Transaction transaction){
        service.updateTransaction(transaction);
        return success ("transaction-record.html");
    }
}
