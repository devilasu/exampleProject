package com.grd.hosp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grd.hosp.dto.LoginInpDto;
import com.grd.hosp.dto.MemberRegInpDto;
import com.grd.hosp.dto.MemberInqPrnDto;
import com.grd.hosp.dto.MemberPutInpDto;
import com.grd.hosp.service.MemberMgntService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberMgntController {

	@Autowired
	MemberMgntService memberMgntService;
	
	@PostMapping("/api/login")
	public @ResponseBody boolean login(@RequestBody LoginInpDto input) throws Exception {
		
		return memberMgntService.login(input);
	}
	
	@GetMapping("/api/member")
	public @ResponseBody MemberInqPrnDto retreiveMember() throws Exception {
		
		return memberMgntService.retrieveMe();
	}
	
	@PostMapping("/api/join")
	public @ResponseBody boolean joinMember(@RequestBody MemberRegInpDto input) throws Exception {
		
		return memberMgntService.registMember(input);
	}
	
	@PutMapping("/api/member")
	public @ResponseBody boolean updateMember(@RequestBody MemberPutInpDto input) throws Exception {
		
		return memberMgntService.updateMember(input);
	}
}
