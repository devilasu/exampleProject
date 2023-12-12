package com.grd.hosp.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ErrorController {
	
	@GetMapping("/api/error")
	public @ResponseBody Map<String, String> error(HttpServletRequest request) throws  Exception {
		String message = (String) request.getAttribute("message");
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("result", message);
        return result;
	}
	
	@PostMapping("/api/error")
	public @ResponseBody Map<String, String> perror(HttpServletRequest request) throws  Exception {
		String message = (String) request.getAttribute("message");
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("result", message);
        return result;
	}
}
