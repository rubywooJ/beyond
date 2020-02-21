package cn.tsxygfy.blog.exception;

import org.springframework.http.HttpStatus;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:01:03
 * @see cn.tsxygfy.blog.exception
 *
 */
public abstract class BaseException extends RuntimeException {

    private Object errorData;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public abstract HttpStatus getStatus();

    public Object getErrorData() {
        return this.errorData;
    }

    public BaseException setErrorData(Object errorData) {
        this.errorData = errorData;
        return this;
    }

}
