package com.cos.exam1.web.dto;

import com.cos.exam1.domain.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinReqDto {
	private String username;
	private String password;
	private String email;
	
	public User toEntity() {
		User user = new User();
		user.setUsername( username);
		user.setPassword(password);
		user.setEmail(email);
		return user;
	}
}
