package ftn.ticketX.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenUtil {

	@Value("${secret}")
	private String secret;
	
	@Value("${token-expiration}")
	private Long expiration;
	
	
	
	public String extractUsername(String token) {
		String username;
		try {
			username = this.getClaimsFromToken(token).getSubject();
		} catch (Exception e) {
			System.out.println("Something went wrong in JwtTokenUtil.extractUsername(String token)");
			username = null;
		}
		
		return username;
	}
	
	
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(this.secret)
									.parseClaimsJws(token).getBody();
		} catch (Exception e) {
			System.out.println("Something went wrong in JwtTokenUtil.getClaimsFromToken(String token)");
			claims = null;
		}
		
		return claims;
	}
	
	
	public Date extractExpirationDate(String token) {
		Date date;
		try {
			date = this.getClaimsFromToken(token).getExpiration();
		} catch (Exception e) {
			System.out.println("Something went wrong in JwtTokenUtil.extractExpirationDate(String token)");
			date = null;
		}
		return date;
	}
	
	
	public boolean isTokenExpired(String token) {
		return this.extractExpirationDate(token).before(new Date());
	}
	
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		
		return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
							.setExpiration(new Date(System.currentTimeMillis() + this.expiration * 1000))
							.signWith(SignatureAlgorithm.HS256, secret).compact();
	}
	
	
	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = this.extractUsername(token);
		return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}
}
