package cn.tsxygfy.blog.core;

import cn.tsxygfy.blog.exception.BaseException;
import cn.tsxygfy.blog.model.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:00:26
 * @see cn.tsxygfy.blog.core
 *
 */
@ControllerAdvice(basePackages = "cn.tsxygfy.blog.controller.admin")
public class ControllerExceptionHandler {


    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse> handleBeyondException(BaseException e) {
        BaseResponse<Object> baseResponse = handleBaseException(e);
        baseResponse.setStatus(e.getStatus().value());
        baseResponse.setData(e.getErrorData());
        return new ResponseEntity<>(baseResponse, e.getStatus());
    }

    private <T> BaseResponse<T> handleBaseException(Throwable t) {
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.setMessage(t.getMessage());
        return baseResponse;
    }

}
