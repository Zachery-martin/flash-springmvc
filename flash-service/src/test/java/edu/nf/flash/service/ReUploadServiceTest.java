package edu.nf.flash.service;

import edu.nf.flash.entity.ReUpload;
import edu.nf.flash.service.config.AppConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReUploadServiceTest {

    private final static Logger log = LoggerFactory.getLogger(ReUploadServiceTest.class);
    @Test
    public void testreUploadById() {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ReUploadService service = context.getBean("reUploadService", ReUploadService.class);
        ReUpload reUpload = new ReUpload();
        reUpload.setUpLoadId("upload-134");
        ReUpload reUploadById = service.getReUploadById(reUpload);
        System.out.println(reUploadById.getWorkName());
    }

}