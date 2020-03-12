package edu.nf.flash.controller;/**
 * @ClassName: ReUpShelfController
 * @Author: Zachery
 * @Data: 20:34
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.controller.util.DateUtils;
import edu.nf.flash.controller.util.UUIDUtils;
import edu.nf.flash.controller.vo.ResponseVO;
import edu.nf.flash.entity.Orders;
import edu.nf.flash.entity.ReUpShelf;
import edu.nf.flash.service.ReUpShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;

/**
 * @ClassName: ReUpShelfController
 * @Author: Zachery
 * @Data: 20:34
 **/
@RestController
public class ReUpShelfController extends BaseController{

    @Autowired
    private ReUpShelfService service;

    @GetMapping("/list_ReUpShelf")
    public ResponseVO<PageInfo> listReUpShelf(Integer pageNum, Integer pageSize){
        PageInfo<ReUpShelf> pageInfo = service.listReUpShelf(pageNum, pageSize);
        return success(pageInfo);
    }

    @PostMapping("/ReUpShelf_add")
    public ResponseVO addReUpShelf(HttpServletRequest request,
                                @Valid ReUpShelf reUpShelf){
        reUpShelf.setRid("shelf-"+ UUIDUtils.createExtractionCode());
        reUpShelf.setUpLoadTime(Date.valueOf(DateUtils.nowDate()));
        service.addReUpShelf(reUpShelf);
        return success ("author-upload-record.html");
    }

    @PostMapping("/ReUpShelf_del")
    public ResponseVO delReUpShelf(HttpServletRequest request,
                                @Valid ReUpShelf reUpShelf){
        service.delReUpShelf(reUpShelf.getRid());
        return success ("author-upload-record.html");
    }

    @PostMapping("/ReUpShelf_update")
    public ResponseVO updateReUpShelf(HttpServletRequest request,
                                   @Valid ReUpShelf reUpShelf){
        service.updateReUpShelf(reUpShelf);
        return success ("author-upload-record.html");
    }
}
