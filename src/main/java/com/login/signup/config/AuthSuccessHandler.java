package com.login.signup.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		boolean isAdmin = authentication
				.getAuthorities()
				.stream()
				.anyMatch(grantAuth -> grantAuth
						.getAuthority()
						.equals("ROLE_ADMIN"));
		if(isAdmin) {
			setDefaultTargetUrl("/admin");
		}else {
			setDefaultTargetUrl("/user");
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
