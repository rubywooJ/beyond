package cn.tsxygfy.blog.util;

import cn.tsxygfy.blog.properties.BeyondProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ruby woo
 * @version v1.0.0
 * @since 2020-02-21 15:06:42
 * @see cn.tsxygfy.blog.util
 *
 */
@Slf4j
@Component
public class JwtUtil {

    @Autowired
    private BeyondProperties bp;

    public String createJwt(String id, String subject){
        long now = System.currentTimeMillis();
        long exp = now + bp.getTtl()*1000;
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setExpiration(new Date(exp))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, bp.getKey());
        log.debug("token was enabled and expiration time is {}", new Date(exp));
        return jwtBuilder.compact();
    }

    public Claims parseJwt(String token){
        return Jwts.parser().setSigningKey(bp.getKey()).parseClaimsJws(token).getBody();
    }

}
