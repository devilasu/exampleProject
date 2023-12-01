package com.grd.hosp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.grd.Util.SessionUtil;
import com.grd.hosp.controller.HospitalMemberMgntController;
import com.grd.hosp.dao.HospitalMapper;
import com.grd.hosp.dto.HospitalInqPrnReptSbDto;
import com.grd.hosp.dto.HospitalLoginInpDto;
import com.grd.hosp.entity.HospitalEntity;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class HospitalMgntService {
	
	@Autowired
	HospitalMapper hospitalMapper;
	
	public List<HospitalInqPrnReptSbDto> retreiveHospital() throws Exception{
		List<HospitalInqPrnReptSbDto> output = new ArrayList<HospitalInqPrnReptSbDto>();
		List<HospitalEntity> result = new ArrayList<HospitalEntity>();
		
		try {
			result = hospitalMapper.retreiveHospital();
		}catch(Exception e) {
			return new ArrayList<HospitalInqPrnReptSbDto>();
		}
		
		for(HospitalEntity entity : result) {
			HospitalInqPrnReptSbDto tmp = new HospitalInqPrnReptSbDto();
			BeanUtils.copyProperties(entity, tmp);
			output.add(tmp);
		}
		
		return output;
	}
	
	public String join(HospitalEntity input) throws Exception{
		int output = 0;
		try {
			output = hospitalMapper.join(input);
		}catch(Exception e) {
			return "redirect:/form/join";
		}
		if(output > 0) {
			return "redirect:/form/login";
		}else {
			return "redirect:/form/join";
		}
	}
	
	public String login(HospitalLoginInpDto input) throws Exception{
		HospitalEntity output;
		try {
			output = hospitalMapper.login(input);
		}
		catch(Exception e){
			return "redirect:/form/login"; 
		}
		
		if(output != null && output.getName() != "" && output.getName() != null) {
			//세션 등록
			SessionUtil.setAttribute("loginEntity", output);
			return "redirect:/";
		}
		return "redirect:/form/login";
	}
	
	public String logout() throws Exception{
		SessionUtil.removeAttribute("loginEntity");
		return "redirect:/form/login";
	}
}
