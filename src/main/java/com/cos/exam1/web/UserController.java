package com.cos.exam1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.exam1.domain.user.UserRepository;
import com.cos.exam1.web.dto.JoinReqDto;

@Controller
public class UserController {
	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/home")
	public String home() {
		return "home"; 
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@PostMapping("/join")
	public String join(JoinReqDto dto) {
		userRepository.save(dto.toEntity());
		return "redirect:/loginForm";
	}
}
