package cn.tsxygfy.beyond.service.impl;

import cn.tsxygfy.beyond.exception.FileUploadException;
import cn.tsxygfy.beyond.model.dto.FileInfo;
import cn.tsxygfy.beyond.service.FileUploadService;
import cn.tsxygfy.beyond.service.OptionService;
import cn.tsxygfy.beyond.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import static cn.tsxygfy.beyond.core.BeyondConst.FILE_SEPARATOR;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service.impl
 * @since 2020-03-20 18:09:29
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Autowired
    private OptionService optionService;

    @Override
    public FileInfo uploadFile(MultipartFile file) {

        String dateStr = new SimpleDateFormat("yyyyMMdd").format(DateUtil.now());
        String fileName = file.getOriginalFilename();
        String path = UPLOAD_DIR + dateStr + FILE_SEPARATOR + fileName;

        File fileInDisk = new File(path);

        if (!fileInDisk.getParentFile().exists()) {
            // 不存在的目录 创建它！
            fileInDisk.getParentFile().mkdirs();
        }

        // 保存文件
        try {
            file.transferTo(fileInDisk);
        } catch (IOException e) {
            throw new FileUploadException("Upload file error. " + e.getMessage());
        }

        String baseUrl = optionService.getBlogBaseUrl();
        String fileUrl = baseUrl + FILE_URL_PREFIX + dateStr + "/" + fileName;

        return new FileInfo(fileName, fileUrl, (int) file.getSize() / 1024);
    }
}
