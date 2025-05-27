package com.java.main.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.models.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@GetMapping("/login")
	public ResponseEntity<AuthResponse> login(
			@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
			@AuthenticationPrincipal OidcUser user,
			 Model model,Exception ex
			){
			
			logger.info("User Email Id : {}", user.getEmail());
			ex.printStackTrace();
			AuthResponse authresponse = new AuthResponse();
			
			authresponse.setUserid(user.getEmail());
			
			authresponse.setAccessToken(client.getAccessToken().getTokenValue());
			
			authresponse.setRefreshToken(client.getRefreshToken().getTokenValue());
			
			authresponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());
			
			List<String> authorities = user.getAuthorities().stream().map(grantedAuthority ->{
				return grantedAuthority.getAuthority();
			}).collect(Collectors.toList());
			
			authresponse.setAuthorities(authorities);
			return new ResponseEntity<>(authresponse, HttpStatus.OK);
	}
	
	
}
