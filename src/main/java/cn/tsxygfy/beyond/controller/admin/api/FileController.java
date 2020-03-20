package cn.tsxygfy.beyond.controller.admin.api;

import cn.tsxygfy.beyond.exception.FileUploadException;
import cn.tsxygfy.beyond.model.dto.FileInfo;
import cn.tsxygfy.beyond.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.controller.admin.api
 * @since 2020-03-20 17:40:38
 */
@RestController
@RequestMapping("api/admin/upload")
public class FileController {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping
    public FileInfo upload(@RequestParam MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileUploadException("Upload file is empty.");
        }
        return fileUploadService.uploadFile(file);
    }
}
