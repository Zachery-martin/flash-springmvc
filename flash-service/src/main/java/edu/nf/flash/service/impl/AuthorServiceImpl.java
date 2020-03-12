package edu.nf.flash.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.flash.dao.AuthorDao;
import edu.nf.flash.entity.Author;
import edu.nf.flash.service.AuthorService;
import edu.nf.flash.service.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: AuthorServiceImpl
 * @Author: Zachery
 * @Data: 14:28
 **/
@Service("authorService")
@Transactional(rollbackFor = RuntimeException.class)
public class AuthorServiceImpl implements AuthorService {

    private static final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);

    @Autowired
    private AuthorDao dao;

    @Override
    public PageInfo<Author> listAuthor(Integer pageNum, Integer pageSize) {
        try {
            List<Author> list = dao.listAuthor(pageNum, pageSize);
            PageInfo<Author> pageInfo = new PageInfo<>(list);
            log.info("查询条数：" + pageInfo.getList().size());
            return pageInfo;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误,暂时无法访问");
        }
    }
    @Override
    public Author findAuthor(Author author) {
        try {
            Author au = dao.getAuthorById(author);
            if(au.getAutLogId().equals(author.getAutLogId()) && au.getAutLogPwd().equals(author.getAutLogPwd())){
                return au;
            }
            log.info("创作者消息:"+author.getName()+"已登陆flash前台");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        throw new DataAccessException("用户名或密码错误!");
    }

    @Override
    public void register(Author author) {
        try {
            dao.addAuthor(author);
            log.info("已成功添加"+author.getName()+"的作者信息");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器繁忙，请稍后尝试");
        }
    }

    @Override
    public void delAuthor(String id) {
        try {
            dao.delAuthor(id);
            log.info("已删除ID为:"+id+"的作者信息");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，删除失败");
        }
    }
    /**
     * 普通修改
     * @param author
     */
    @Override
    public void updateOrdinaryAuthor(Author author) {
        try {
            dao.updateOrdinaryAuthor(author);
            log.info("创作者:"+author.getName()+"的普通修改已完成");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }

    /**
     * 高级修改
     * @param author
     */
    @Override
    public void updateSeniorAuthor(Author author) {
        try {
            dao.updateSeniorAuthor(author);
            log.info("创作者:"+author.getName()+"的高级修改已完成");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }

    /**
     * 修改密码
     * @param author
     */
    @Override
    public void updateAuthorPwd(Author author) {
        try {
            dao.updateAuthorPwd(author);
            log.info("创作者:"+author.getName()+"的作者密码更新已完成");
        }catch (Exception e){
            log.error(e.getMessage());
            throw new DataAccessException("服务器内部错误，更新失败");
        }
    }
}
