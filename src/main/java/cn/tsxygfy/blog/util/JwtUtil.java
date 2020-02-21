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
 * @author feiyang
 * @version v1.0
 * @className JwtUtils
 * @description
 * @date 2020/01/05 周日 18:36
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
