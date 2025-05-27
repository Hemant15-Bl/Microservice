package com.java.main.models;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
	
	private String userid;
	private String accessToken;
	private String refreshToken;
	private long expireAt;
	private Collection<String> authorities;
	
}
