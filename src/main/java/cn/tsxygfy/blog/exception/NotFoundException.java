package cn.tsxygfy.blog.exception;

import org.springframework.http.HttpStatus;

/**
 * @author feiyang
 * @version v1.0
 * @className NotFoundException
 * @description
 * @date 2020/02/09 周日 15:48
 */
public class NotFoundException extends BeyondException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
