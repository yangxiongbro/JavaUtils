package com.common.java.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.MacAlgorithm;
import io.jsonwebtoken.security.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.security.Key;
import java.security.KeyPair;
import java.util.Date;
import java.util.Map;

/**
 * <b><code>JwtUtils</code></b>
 * <p/>
 * JWT
 * <p/>
 * <b>Creation Time:</b> 2024/6/20 22:00
 *
 * @author yang xiong
 * @since CommonJava 1.0
 */
public class JwtUtils {
    
    /**
     * @description: 非对称签名算法 Jwts.SIG.RS256, RS384, RS512, PS256, etc...
     * @param: signAlgorithm - [SignatureAlgorithm]
     * @return: java.security.KeyPair
     * @throws 
     * @author yang xiong
     * @date 2024/6/20 22:19
     **/
    public KeyPair generateKeyPair(SignatureAlgorithm signAlgorithm){
        return signAlgorithm.keyPair().build();
    }

    /**
     * @description: 获取mac签名密钥 Jwts.SIG.HS256, HS384, HS512, etc...
     * @param: macAlgorithm - [MacAlgorithm]
     * @return: javax.crypto.SecretKey
     * @throws 
     * @author yang xiong
     * @date 2024/6/20 22:30
     **/
    public SecretKey generateKeyPair(MacAlgorithm macAlgorithm){
         return macAlgorithm.key().build();
    }

    /**
     * @description: 将密钥转为字符串
     * @param: key - [Key]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2024/6/20 22:33
     **/
    public String convert2String(Key key){
        return Encoders.BASE64.encode(key.getEncoded());
    }

    /**
     * @description: 获取 jwt token
     * @param: key - [Key]
     * @param: headerMap - [String]
     * @param: claims - [Object>]
     * @param: id - [String]
     * @param: subject - [Object>]
     * @param: expireSec - [String]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2024/6/20 22:20
     **/
    public String generateJwtToken(Key key, Map<String, Object> headerMap, Map<String, Object> claims, String id, String subject, long expireSec){
        JwtBuilder jwtBuilder = Jwts.builder()
                .id(id)
                .subject(subject)
                .issuedAt(new Date())
                .signWith(key)
                .expiration(new Date(System.currentTimeMillis() + expireSec * 1000)) // token 过期时间，不设置则不会过期
                ;
        if(null != headerMap){
            jwtBuilder.header().add(headerMap);
        }
        if(null != claims){
            jwtBuilder.claims(claims);
        }
        return jwtBuilder.compact();
    }

    /**
     * @description: 获取 jwt token
     * @param: key - [Key]
     * @param: id - [String]
     * @param: subject - [String]
     * @param: expireSec - [long]
     * @return: java.lang.String
     * @throws
     * @author yang xiong
     * @date 2024/6/20 22:20
     **/
    public String generateJwtToken(Key key, String id, String subject, long expireSec){
        return generateJwtToken(key, null, null, id, subject, expireSec);
    }

}
