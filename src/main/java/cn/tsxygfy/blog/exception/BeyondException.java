package cn.tsxygfy.blog.exception;

import org.springframework.http.HttpStatus;

/**
 * @author feiyang
 * @version v1.0
 * @className BeyondException
 * @description
 * @date 2020/02/09 周日 15:44
 */
public abstract class BeyondException extends RuntimeException {

    private Object errorData;

    public BeyondException(String message) {
        super(message);
    }

    public BeyondException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus getStatus();

    public Object getErrorData() {
        return this.errorData;
    }

    public BeyondException setErrorData(Object errorData) {
        this.errorData = errorData;
        return this;
    }

}
