package edu.nf.flash.controller;/**
 * @ClassName: AuthorController
 * @Author: Zachery
 * @Data: 20:33
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.controller.util.UUIDUtils;
import edu.nf.flash.controller.vo.ResponseVO;
import edu.nf.flash.entity.Author;
import edu.nf.flash.entity.Orders;
import edu.nf.flash.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: AuthorController
 * @Author: Zachery
 * @Data: 20:33
 **/
@RestController
public class AuthorController extends BaseController{

    @Autowired
    private AuthorService service;

    @GetMapping("/list_author")
    public ResponseVO<PageInfo> listAuthor(Integer pageNum, Integer pageSize){
        PageInfo<Author> pageInfo = service.listAuthor(pageNum, pageSize);
        return success(pageInfo);
    }

    @PostMapping("/author_login")
    public ResponseVO login(@Valid Author author, HttpSession session){
        Author backAuthor = service.findAuthor(author);
        session.setAttribute("author", backAuthor);
        System.out.println("创作者:"+backAuthor.getName()+"验证成功!并加入session作用域。");
        return success("auth-index.html");
    }

    @PostMapping("/author_register")
    public ResponseVO addAuthor(@Valid Author author){
        author.setAutId("aut-"+ UUIDUtils.createExtractionCode());
        service.register(author);
        return success ("auth-login.html");
    }

    @PostMapping("/author_del")
    public ResponseVO delAuthor(@Valid Author author){
        service.delAuthor(author.getAutId());
        return success ("auth-login.html");
    }

    /**
     * 普通修改
     * @param author
     * @param session
     * @return
     */
    @PostMapping("/author_ordinary_update")
    public ResponseVO updateOrdinaryAuthor(@Valid Author author, HttpSession session){
        Author a = (Author) session.getAttribute("author");
        author.setAutId(a.getAutId());
        service.updateOrdinaryAuthor(author);
        session.removeAttribute("author");
        session.setAttribute("author", author);
        return success ("auth-login.html");
    }

    /**
     * 高级修改
     * @param author
     * @param session
     * @return
     */
    @PostMapping("/author_senior_update")
    public ResponseVO updateSeniorAuthor(@Valid Author author, HttpSession session){
        Author a = (Author) session.getAttribute("author");
        author.setAutId(a.getAutId());
        service.updateSeniorAuthor(author);
        session.removeAttribute("author");
        return success ("auth-login.html");
    }

    /**
     * 修改密码
     * @param author
     * @param session
     * @return
     */
    @PostMapping("/author_pwd_update")
    public ResponseVO updateAuthorPwd(@Valid Author author, HttpSession session){
        Author a = (Author) session.getAttribute("author");
        author.setAutId(a.getAutId());
        service.updateAuthorPwd(author);
        session.removeAttribute("author");
        return success ("auth-login.html");
    }

    @GetMapping("/author_getAuthor")
    public ResponseVO getOnLineAuthor(HttpSession session){
        Author a = (Author) session.getAttribute("author");
        return success(a);
    }

    @GetMapping("/author_Logout")
    public ResponseVO logOutAuthor(HttpSession session){
        session.removeAttribute("author");
        return success("auth-login.html");
    }

}
