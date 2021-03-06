package com.cos.exam1.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.exam1.domain.user.User;
import com.cos.exam1.domain.user.UserRepository;
import com.cos.exam1.web.dto.JoinReqDto;
import com.cos.exam1.web.dto.LoginReqDto;

@Controller
public class UserController {
	private UserRepository userRepository;
	private HttpSession session;
	
	public UserController(UserRepository userRepository, HttpSession session) {
		this.userRepository = userRepository;
		this.session = session;
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
	
	@PostMapping("/login")
	public String login(LoginReqDto dto) {
		User userEntity = userRepository.mLogin(dto.getUsername(), dto.getPassword());
		if(userEntity == null) {
			return "redirect:/loginForm";
		}else {
			session.setAttribute("principal", userEntity);
			return "redirect:/home";
		}
	}
	
	@PostMapping("/join")
	public String join(JoinReqDto dto) {
		userRepository.save(dto.toEntity());
		return "redirect:/loginForm";
	}
}
