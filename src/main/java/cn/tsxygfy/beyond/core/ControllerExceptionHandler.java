package cn.tsxygfy.beyond.core;

import cn.tsxygfy.beyond.exception.BaseException;
import cn.tsxygfy.beyond.model.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.core
 * @since 2020-02-21 15:00:26
 */
@RestControllerAdvice(basePackages = "cn.tsxygfy.beyond.controller.admin.api")
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public BaseResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        BaseResponse<?> response = handleException(e);
        response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public BaseResponse handleIllegalArgumentException(IllegalArgumentException e) {
        BaseResponse<Object> response = handleException(e);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return response;
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse> handleBeyondException(BaseException e) {
        BaseResponse<Object> baseResponse = handleException(e);
        baseResponse.setStatus(e.getStatus().value());
        baseResponse.setData(e.getErrorData());
        return new ResponseEntity<>(baseResponse, e.getStatus());
    }

    private <T> BaseResponse<T> handleException(Throwable t) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setMessage(t.getMessage());
        return baseResponse;
    }

}
