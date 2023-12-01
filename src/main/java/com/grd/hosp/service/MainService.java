package com.grd.hosp.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.grd.Util.SessionUtil;
import com.grd.hosp.dao.MemberMapper;
import com.grd.hosp.dao.ReservationMapper;
import com.grd.hosp.dto.LoginInpDto;
import com.grd.hosp.dto.MemberRegInpDto;
import com.grd.hosp.dto.ReservationInqInpDto;
import com.grd.hosp.dto.ReservationInqPrnReptSbDto;
import com.grd.hosp.dto.MemberInqPrnDto;
import com.grd.hosp.dto.MemberPutInpDto;
import com.grd.hosp.entity.HospitalEntity;
import com.grd.hosp.entity.MemberEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MainService {
	
	@Autowired
	ReservationMapper reservationMapper;
	
	
	//회원가입
	public String mainPage(Model model) throws Exception {
		HospitalEntity loginData = (HospitalEntity)SessionUtil.getAttribute("loginEntity");
		if(loginData != null) {
			ReservationInqInpDto input = new ReservationInqInpDto();
			input.setHospitalId(loginData.getId());
			input.setAccept("Y");
			List<ReservationInqPrnReptSbDto> output = reservationMapper.retreiveReservation(input);
			
			model.addAttribute("reservations", output);
			
			return "main";
		}else {
			return "redirect:/form/login";
		}
	}
}
