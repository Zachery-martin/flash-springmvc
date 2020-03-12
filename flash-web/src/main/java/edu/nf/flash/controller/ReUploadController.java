package edu.nf.flash.controller;/**
 * @ClassName: ReUploadController
 * @Author: Zachery
 * @Data: 20:34
 **/

import com.github.pagehelper.PageInfo;
import edu.nf.flash.controller.util.MyFileUtils;
import edu.nf.flash.controller.util.UUIDUtils;
import edu.nf.flash.controller.vo.ResponseVO;
import edu.nf.flash.entity.Author;
import edu.nf.flash.entity.ReUpload;
import edu.nf.flash.service.ReUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: ReUploadController
 * @Author: Zachery
 * @Data: 20:34
 **/
@RestController
public class ReUploadController extends BaseController{

    @Autowired
    private ReUploadService service;

    @GetMapping("/list_ReUpload")
    public ResponseVO<PageInfo> listReUpload(Integer pageNum, Integer pageSize){
        PageInfo<ReUpload> pageInfo = service.listReUpload(pageNum, pageSize);
        return success(pageInfo);
    }

    @GetMapping("/auth_list_ReUpload")
    @CrossOrigin
    @ResponseBody
    public ResponseVO<PageInfo> authListPageInfo(Integer pageNum, Integer pageSize,String autId){
        PageInfo<ReUpload> pageInfo = service.authListReUpload(pageNum, pageSize,autId);
        return success(pageInfo);
    }

    /**
     * 重新选择文件存储地址，页面加载不允许加载本地资源
     * @param reUpload
     * @param session
     * @param files
     * @return
     * @throws IOException
     */
    @PostMapping("/ReUpload_add")
    @ResponseBody
    public ResponseVO<List<String>> addReUpload(@Valid ReUpload reUpload, HttpSession session,
                                                MultipartFile[] files) throws IOException {
        //将文件上传到当前web项目部署的目录中，先获取部署目录
        //String uploadPath = "D:"+File.separator + "upload";
        String uploadPath = "D:"+File.separator + "upload";
        List<String> fileNames = new ArrayList<>();
        //创建上传目录
        MyFileUtils.createUploadDir(uploadPath);
        for (MultipartFile file : files) {
            //获取上传文件的文件名
            String fileName = file.getOriginalFilename();
            fileName = MyFileUtils.newFileName(fileName);
            String str = fileName.substring(fileName.lastIndexOf(".")+1);
            if(str.equals("jpg")||str.equals("png")){
                reUpload.setImgUrl(fileName);
            }else{
                reUpload.setUrl(fileName);
            }
            //构建上传的文件
            File uploadFile = MyFileUtils.createUploadFile(uploadPath, fileName);
            //执行上传
            file.transferTo(uploadFile);
            fileNames.add(fileName);
        }
        //获取创作者session作用域信息
        Author a = (Author) session.getAttribute("author");
        reUpload.setUpLoadId("upload-" + UUIDUtils.createExtractionCode());
        reUpload.setAutId(a.getAutId());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String createdate = sdf.format(date);
        reUpload.setTime(createdate);
        service.addReUpload(reUpload);
        return success ("auth-index.html");
    }

    @PostMapping("/ReUpload_del")
    public ResponseVO delReUpload( @Valid ReUpload reUpload){
        service.delReUpload(reUpload);
        return success ("auth-work.html");
    }

    @PostMapping("/ReUpload_update")
    public ResponseVO updateReUpload(@Valid ReUpload reUpload){
        service.updateReUpload(reUpload);
        return success ("auth-work.html");
    }

    @GetMapping("/getWorkByUploadId")
    public ResponseVO getReUploadById(@Valid ReUpload reUpload){
        ReUpload backReUpload=service.getReUploadById(reUpload);
        return success (backReUpload);
    }

}
