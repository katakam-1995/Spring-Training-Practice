package com.otsi.security.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.otsi.model.Constants;
import com.otsi.service.impl.UserServiceImpl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -614204219404187444L;

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(Constants.SIGNING_KEY).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	/*
	 * public String generateToken(UsersDTO user) { return
	 * doGenerateToken(user.getUsername()); }
	 */

	public String generateToken(String user) {
		return doGenerateToken(user);
	}

	private String doGenerateToken(String subject) {

		Claims claims = Jwts.claims().setSubject(subject);
		claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));

		return Jwts.builder().setClaims(claims).setIssuer("http://rootzz.com")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + Constants.ACCESS_TOKEN_VALIDITY_SECONDS * 1000))
				.signWith(SignatureAlgorithm.HS256, Constants.SIGNING_KEY).compact();
	}

	@SuppressWarnings("unlikely-arg-type")
	public Boolean validateToken(String token, UserServiceImpl userService) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userService.findByUserName(username)) && !isTokenExpired(token));
	}

}
