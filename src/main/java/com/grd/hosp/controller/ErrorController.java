package com.grd.hosp.controller;

import javax.security.sasl.AuthenticationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ErrorController {
	
	@GetMapping("/api/error")
	public @ResponseBody void error(HttpServletRequest request) throws  Exception {
		String message = (String) request.getAttribute("message");
        String exception = (String) request.getAttribute("exception");
        
        if ("Exception".equals(exception)) {
        	log.info("에러");
            throw new AuthenticationException(message);
        }
	}
	
	@GetMapping("/web/error")
	public @ResponseBody void webError(HttpServletRequest request) throws  Exception {
		String message = (String) request.getAttribute("message");
        String exception = (String) request.getAttribute("exception");
        
        if ("Exception".equals(exception)) {
            throw new AuthenticationException(message);
        }
	}
}
