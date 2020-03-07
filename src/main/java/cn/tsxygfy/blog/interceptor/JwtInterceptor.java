package cn.tsxygfy.blog.interceptor;

import cn.tsxygfy.blog.properties.BeyondProperties;
import cn.tsxygfy.blog.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @see cn.tsxygfy.blog.interceptor
 * @since 2020-02-21 15:02:12
 */
@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private BeyondProperties beyondProperties;

    /**
     * 响应之前
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 进入控制器之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authentication = request.getHeader(beyondProperties.getHeader());
        if (!StringUtils.isEmpty(authentication) && authentication.startsWith(beyondProperties.getPrefix())) {
            try {
                // 过滤掉 token 的前缀
                authentication = authentication.replace(beyondProperties.getPrefix(), "");
                // 解析
                Claims claims = JwtUtil.parseJwt(authentication);
                if (claims != null) {
                    // ???
                    request.setAttribute("username", claims.getSubject());
                    return true;
                }
                return false;
            } catch (Exception ignored) {
                error(response, "Token has expired or does not exist");
                return false;
            }
        } else {
            error(response, "You are not logged in");
            return false;
        }
    }

    /**
     * 执行控制器之后
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }


    private void error(HttpServletResponse response, String message) {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");
        final int code = 401;
        try (PrintWriter out = response.getWriter()) {
            String responseJson = "{\"code\": " + code + "," + "\"message\":\"" + message + "\"}";
            out.print(responseJson);
        } catch (IOException ignored) {
        }
    }
}
