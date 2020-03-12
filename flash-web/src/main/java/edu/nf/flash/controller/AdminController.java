package edu.nf.flash.controller;/**
 * @ClassName: RegistrationController
 * @Author: Zachery
 * @Data: 11:53
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.controller.util.UUIDUtils;
import edu.nf.flash.controller.vo.ResponseVO;
import edu.nf.flash.entity.Admin;
import edu.nf.flash.entity.Orders;
import edu.nf.flash.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * @ClassName: RegistrationController
 * @Author: Zachery
 * @Data: 11:53
 **/
@RestController
public class AdminController extends BaseController{

    @Autowired
    private AdminService service;

    @GetMapping("/list_admin")
    public ResponseVO<PageInfo> listOrders(Integer pageNum, Integer pageSize){
        PageInfo<Admin> pageInfo = service.listAdmin(pageNum, pageSize);
        return success(pageInfo);
    }

    @PostMapping("/admin_login")
    public ResponseVO login(@Valid Admin admin, HttpSession session){
        Admin backAdmin = service.findAdmin(admin);
        session.setAttribute("admin", backAdmin);
        System.out.println("管理员:"+backAdmin.getName()+"验证成功!并加入session作用域。");
        return success("back-index.html");
    }

    @PostMapping("/admin_register")
    public ResponseVO addAdmin(@Valid Admin admin){
        admin.setAdminId("admin-"+ UUIDUtils.createExtractionCode());
        service.register(admin);
        return success ("back-login.html");
    }

    @PostMapping("/admin_del")
    public ResponseVO delAdmin(@Valid Admin admin){
        service.deleteAdmin(admin.getAdminId());
        return success ("back-login.html");
    }

    @PostMapping("/admin_update")
    public ResponseVO updateAdmin(@Valid Admin admin, HttpSession session){
        service.updateAdmin(admin);
        return success ("back-login.html");
    }

    @GetMapping("/admin_getAdmin")
    public ResponseVO getOnLineAdmin(HttpSession session){
        Admin a = (Admin) session.getAttribute("admin");
        return success(a);
    }

    @GetMapping("/admin_Logout")
    public ResponseVO logOutAdmin(HttpSession session){
        session.removeAttribute("admin");
        return success("back-login.html");
    }

}
