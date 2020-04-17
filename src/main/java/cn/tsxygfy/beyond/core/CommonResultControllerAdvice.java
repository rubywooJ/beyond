package cn.tsxygfy.beyond.core;

import cn.tsxygfy.beyond.model.dto.BaseResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.beyond.core
 * @since 2020-02-21 14:35:11
 */
@ControllerAdvice("cn.tsxygfy.beyond.controller")
public class CommonResultControllerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return AbstractJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType contentType,
                                  Class<? extends HttpMessageConverter<?>> converterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        MappingJacksonValue container = getOrCreateContainer(body);
        // The contain body will never be null
        beforeBodyWriteInternal(container, contentType, returnType, request, response);
        return container;
    }

    private MappingJacksonValue getOrCreateContainer(Object body) {
        return (body instanceof MappingJacksonValue ? (MappingJacksonValue) body : new MappingJacksonValue(body));
    }

    private void beforeBodyWriteInternal(MappingJacksonValue bodyContainer,
                                         MediaType contentType,
                                         MethodParameter returnType,
                                         ServerHttpRequest request,
                                         ServerHttpResponse response) {
        // 获取返回值
        Object returnBody = bodyContainer.getValue();

        if (returnBody instanceof BaseResponse) {
            // 如果是BaseResponse直接返回
            BaseResponse<?> baseResponse = (BaseResponse) returnBody;
            response.setStatusCode(HttpStatus.resolve(baseResponse.getStatus()));
            return;
        }

        // 包装返回
        if (returnBody != null) {
            BaseResponse<?> baseResponse = BaseResponse.ok(returnBody);
            bodyContainer.setValue(baseResponse);
            response.setStatusCode(HttpStatus.valueOf(baseResponse.getStatus()));
        } else {//controller 返回 void
            BaseResponse<?> baseResponse = BaseResponse.ok(null);
            bodyContainer.setValue(baseResponse);
            response.setStatusCode(HttpStatus.valueOf(baseResponse.getStatus()));
        }
    }

}
