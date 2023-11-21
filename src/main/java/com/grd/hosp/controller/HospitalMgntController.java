package com.grd.hosp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grd.hosp.dto.HospitalInqPrnReptSbDto;
import com.grd.hosp.dto.HospitalLoginInpDto;
import com.grd.hosp.entity.HospitalEntity;
import com.grd.hosp.service.HospitalMgntService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HospitalMgntController {
	
	@Autowired
	HospitalMgntService hospitalService;

	@GetMapping("/api/hospital")
	public @ResponseBody List<HospitalInqPrnReptSbDto> retreiveHospital() throws Exception{
		return hospitalService.retreiveHospital();
	}
	
	@GetMapping("/form/login")
	public String loginForm(@ModelAttribute HospitalLoginInpDto input) throws Exception{
		return "login";
	}
	
	@GetMapping("/form/join")
	public String joinForm() throws Exception{
		return "join";
	}
	
	@PostMapping("/web/join")
	public String join(@ModelAttribute HospitalEntity input) throws Exception{
		return hospitalService.join(input);
	}
	
	@PostMapping("/web/login")
	public String HospitalLogin(@ModelAttribute HospitalLoginInpDto input) throws Exception{
		return hospitalService.login(input);
	}
}
