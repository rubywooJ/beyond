package cn.tsxygfy.blog.exception;

import org.springframework.http.HttpStatus;

/**
 * @author feiyang
 * @version v1.0
 * @className BadRequestException
 * @description
 * @date 2020/02/09 周日 20:49
 */
public class BadRequestException extends BeyondException {

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
