package edu.nf.flash.controller;/**
 * @ClassName: ReWorkUpdateController
 * @Author: Zachery
 * @Data: 20:34
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.controller.util.DateUtils;
import edu.nf.flash.controller.util.UUIDUtils;
import edu.nf.flash.controller.vo.ResponseVO;
import edu.nf.flash.entity.Orders;
import edu.nf.flash.entity.ReWorkUpdate;
import edu.nf.flash.service.ReWorkUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;

/**
 * @ClassName: ReWorkUpdateController
 * @Author: Zachery
 * @Data: 20:34
 **/
@RestController
public class ReWorkUpdateController extends BaseController{

    @Autowired
    private ReWorkUpdateService service;

    @GetMapping("/list_workUpdate")
    public ResponseVO<PageInfo> listReWorkUpdate(Integer pageNum, Integer pageSize){
        PageInfo<ReWorkUpdate> pageInfo = service.listReWorkUpdate(pageNum, pageSize);
        return success(pageInfo);
    }

    @PostMapping("/workUpdate_add")
    public ResponseVO addReWorkUpdate(HttpServletRequest request,
                                @Valid ReWorkUpdate reWorkUpdate){
        reWorkUpdate.setUpdateId("work-"+ UUIDUtils.createExtractionCode());
        reWorkUpdate.setTime(Date.valueOf(DateUtils.nowDate()));
        service.addReWorkUpdate(reWorkUpdate);
        return success ("author-update-record.html");
    }

    @PostMapping("/workUpdate_del")
    public ResponseVO delReWorkUpdate(HttpServletRequest request,
                                @Valid ReWorkUpdate reWorkUpdate){
        service.delReWorkUpdate(reWorkUpdate.getUpdateId());
        return success ("author-update-record.html");
    }

    @PostMapping("/workUpdate_update")
    public ResponseVO updateReWorkUpdate(HttpServletRequest request,
                                   @Valid ReWorkUpdate reWorkUpdate){
        service.updateReWorkUpdate(reWorkUpdate);
        return success ("author-update-record.html");
    }
}
