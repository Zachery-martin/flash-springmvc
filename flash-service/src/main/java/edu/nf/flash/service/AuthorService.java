package edu.nf.flash.service;

import com.github.pagehelper.PageInfo;
import edu.nf.flash.entity.Author;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: author
 * @Author: Zachery
 * @Data: 09:48
 **/
public interface AuthorService {

    /**
     * 创作者列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Author> listAuthor(Integer pageNum, Integer pageSize);

    /**
     * 创作者验证登陆
     * @param author
     * @return
     */
    Author findAuthor(Author author);

    /**
     * 注册创作者
     * @param author
     */
    void register(Author author);

    /**
     * 注销创作者
     * @param id
     */
    void delAuthor(String id);

    /**
     * 普通修改
     * @param author
     */
    void updateOrdinaryAuthor(Author author);

    /**
     * 高级修改
     * @param author
     */
    void updateSeniorAuthor(Author author);

    /**
     * 修改密码
     * @param author
     */
    void  updateAuthorPwd(Author author);
}
