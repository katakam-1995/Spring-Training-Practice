package com.otsi.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.otsi.model.ApiResponse;
import com.otsi.model.AuthToken;
import com.otsi.model.LoginUser;
import com.otsi.model.User;
import com.otsi.security.util.JwtTokenUtil;
import com.otsi.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/token")
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/generate-token", method = RequestMethod.POST)
	public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser){

		Authentication auth = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
		final User user = userService.findByUserName(loginUser.getUsername());

		final String token = jwtTokenUtil.generateToken(user.getUsername());

		return new ApiResponse<>(200, "success", new AuthToken(token, auth.getName().toString()));
	}

}
