package com.maxfromeverett.misto.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class JwtUtils {

  private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

  @Value("${app.jwtSecret}")
  private String jwtSecret;

  @Value("${app.jwtExpirationSec}")
  public int jwtExpirationSec;

  public String generateJwtToken(UserDetailsImpl userPrincipal) {
    return generateTokenFromUserId(userPrincipal.getUserId());
  }


  public String generateTokenFromUserId(Long user_id_) {
    return Jwts.builder().setSubject(user_id_.toString()).setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationSec * 1000)).signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
  }

  public Long getUserIdFromJwtToken(String token) {
    return Long.valueOf(Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject());
  }

  public boolean isJwtTokenValid(String authToken) {
    return getJwtTokenErrMsg(authToken).isEmpty();
  }

  public String getJwtTokenErrMsg(String authToken) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
    } catch (SignatureException e) {
      return "Invalid JWT signature: " + e.getMessage();
    } catch (MalformedJwtException e) {
      return "Invalid JWT token: " + e.getMessage();
    } catch (ExpiredJwtException e) {
      return "JWT token is expired: " + e.getMessage();
    } catch (UnsupportedJwtException e) {
      return "JWT token is unsupported: " + e.getMessage();
    } catch (IllegalArgumentException e) {
      return "JWT claims string is empty: " + e.getMessage();
    }
    return "";
  }
}