package cn.tsxygfy.beyond;

import cn.tsxygfy.beyond.service.FileUploadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileUploadServiceTest {

    @Autowired
    FileUploadService fileUploadService;

    @Test
    public void getUploadDir() {
        //System.out.println(fileUploadService.getUploadDir());
    }

}
