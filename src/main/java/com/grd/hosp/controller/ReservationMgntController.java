package com.grd.hosp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.grd.Util.SessionUtil;
import com.grd.hosp.dto.ReservationInqInpDto;
import com.grd.hosp.dto.ReservationInqPrnReptSbDto;
import com.grd.hosp.dto.ReservationRegInpDto;
import com.grd.hosp.entity.HospitalEntity;
import com.grd.hosp.entity.ReservationEntity;
import com.grd.hosp.service.ReservationMgntService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ReservationMgntController {

	@Autowired
	ReservationMgntService reservationMgntService;
	
	@GetMapping("/api/reservation")
	public @ResponseBody List<ReservationInqPrnReptSbDto> retreiveReservation(@RequestBody ReservationInqInpDto input) throws Exception{
		return reservationMgntService.retreiveReservation(input);
	}
	
	@PostMapping("/api/reservation")
	public @ResponseBody boolean registReservation(@RequestBody ReservationRegInpDto input) throws Exception{
		return reservationMgntService.registReservation(input);
	}
	
	@GetMapping("/web/reservation")
	public String retreiveReservationFromHospital(HttpServletRequest request, @ModelAttribute ReservationInqInpDto input) throws Exception{
		HospitalEntity loginData = (HospitalEntity)SessionUtil.getSession("loginEntity");
		List<ReservationInqPrnReptSbDto> output = new ArrayList<ReservationInqPrnReptSbDto>();
		
		if(loginData == null) {
			return "login";
		}
		
		input.setHospitalId(loginData.getId());
		
		try {
			output = reservationMgntService.retreiveReservation(input);
		}catch(Exception e) {
			return "redirect:/";
		}
		
		request.setAttribute("loginData", loginData);
		request.setAttribute("reservations", output);
		return "reservation";
	}
	
	@PostMapping("/web/reservation")
	public String updateReservation(HttpServletRequest request, @ModelAttribute ReservationEntity reservationValue) throws Exception{
		HospitalEntity loginData = (HospitalEntity)SessionUtil.getSession("loginEntity");
		
		boolean output = reservationMgntService.updateReservation(reservationValue);
		
		if(loginData != null) {
			request.setAttribute("loginData", loginData);
		}
		return "redirect:/web/reservation";
	}
	
}
