package com.grd.hosp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grd.hosp.dto.HospitalMemberInqPrnReptSbDto;
import com.grd.hosp.entity.HospitalMemberEntity;
import com.grd.hosp.service.HospitalMemberMgntService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class HospitalMemberMgntController {

	@Autowired
	HospitalMemberMgntService hospitalMemberMgntService;
	
	@GetMapping("/api/hospitalmember")
	public @ResponseBody List<HospitalMemberInqPrnReptSbDto> retreiveHospitalMember(@RequestBody HospitalMemberEntity input) throws Exception{
		return hospitalMemberMgntService.retreiveHospitalMember(input);
	}
	
	@GetMapping("/api/hospitaldept")
	public @ResponseBody List<HospitalMemberInqPrnReptSbDto> retreiveHospitalDept(@RequestBody HospitalMemberEntity input) throws Exception{
		return hospitalMemberMgntService.retreiveHospitalDept(input);
	}
	
	@PostMapping("/web/doctor")
	public String joinDoctor(@ModelAttribute HospitalMemberEntity input) throws Exception{
		return hospitalMemberMgntService.joinDoctor(input);
	}
	
	@GetMapping("/form/doctor")
	public String formJoinDoctor() throws Exception{
		return "/joinDoctor";
	}
}
