package cn.tsxygfy.beyond.service;

import cn.tsxygfy.beyond.core.BeyondConst;
import cn.tsxygfy.beyond.model.dto.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import static cn.tsxygfy.beyond.core.BeyondConst.FILE_SEPARATOR;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.service
 * @since 2020-03-20 17:17:31
 */
public interface FileUploadService {

    /**
     * /upload/
     */
    String FILE_URL_PREFIX = "/upload/";

    /**
     * {user.home}/.beyond/upload/
     */
    String UPLOAD_DIR = BeyondConst.USER_HOME + FILE_SEPARATOR + ".beyond" + FILE_SEPARATOR + "upload"
            + FILE_SEPARATOR;

    FileInfo uploadFile(MultipartFile file);

}
