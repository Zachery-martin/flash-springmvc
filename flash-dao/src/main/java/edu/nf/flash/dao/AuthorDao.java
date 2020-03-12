package edu.nf.flash.dao;

import edu.nf.flash.entity.Admin;
import edu.nf.flash.entity.Author;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: Author
 * @Author: Zachery
 * @Data: 20:34
 **/
public interface AuthorDao {

    /**
     * 列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Author> listAuthor(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 增
     * @param author
     */
    void addAuthor(Author author);

    /**
     * 删
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

    /**
     * 根据id获取
     * @param author
     * @return
     */
    Author getAuthorById(Author author);
}
