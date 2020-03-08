package cn.tsxygfy.blog.security.handler;

import cn.tsxygfy.blog.exception.BaseException;

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
 * @since 2020-03-08 21:20:21
 */
public interface AuthenticationFailureHandler {

    /**
     * 认证失败
     *
     * @param request
     * @param response
     * @param exception
     * @throws IOException
     * @throws ServletException
     */
    void onFailure(HttpServletRequest request, HttpServletResponse response, BaseException exception) throws IOException, ServletException;
}
