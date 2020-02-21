package cn.tsxygfy.blog.core;

import cn.tsxygfy.blog.exception.BeyondException;
import cn.tsxygfy.blog.model.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author feiyang
 * @version v1.0
 * @className ControllerExceptionHandler
 * @description
 * @date 2020/02/10 周一 17:05
 */
@ControllerAdvice(basePackages = "cn.tsxygfy.blog.controller.admin")
public class ControllerExceptionHandler {


    @ExceptionHandler(BeyondException.class)
    public ResponseEntity<BaseResponse> handleBeyondException(BeyondException e) {
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
