package com.grd.hosp.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.grd.Util.SessionUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(SessionUtil.getAttribute("loginEntity") != null) {
			return true;
		}else {
			request.setAttribute("message", "로그인이 필요합니다.");
			request.setAttribute("exception", "Exception");
			request.getRequestDispatcher("/form/login").forward(request, response);
			return false;
		}
	}
	
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
