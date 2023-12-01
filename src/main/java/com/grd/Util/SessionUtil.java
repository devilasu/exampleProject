package com.grd.Util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.grd.hosp.entity.MemberEntity;

import jakarta.servlet.http.HttpSession;

public class SessionUtil {
	public static Object getAttribute(String key) {
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
	    return httpSession.getAttribute(key);
	}
	
	public static void setAttribute(String key, Object data) {
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
	    httpSession.setAttribute(key, data);
	}
	
	public static void removeAttribute(String key) {
		ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
	    httpSession.removeAttribute(key);
	}
}
