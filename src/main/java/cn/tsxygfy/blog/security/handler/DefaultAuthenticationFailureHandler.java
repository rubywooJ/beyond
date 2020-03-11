package cn.tsxygfy.blog.security.handler;

import cn.tsxygfy.blog.exception.BaseException;
import cn.tsxygfy.blog.model.dto.BaseResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.security.handler
 * @since 2020-03-11 15:23:06
 */
@Slf4j
public class DefaultAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onFailure(HttpServletRequest request, HttpServletResponse response, BaseException exception) throws IOException, ServletException {
        log.error("Authentication failure", exception);

        BaseResponse<Object> error = new BaseResponse<>();
        error.setStatus(exception.getStatus().value());
        error.setMessage(exception.getMessage());
        error.setData(exception.getErrorData());

        response.setStatus(error.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(new ObjectMapper().writeValueAsString(error));
    }
}
