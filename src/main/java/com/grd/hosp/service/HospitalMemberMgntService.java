package com.grd.hosp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grd.hosp.dao.HospitalMemberMapper;
import com.grd.hosp.dto.HospitalMemberInqPrnReptSbDto;
import com.grd.hosp.entity.HospitalMemberEntity;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class HospitalMemberMgntService {
	
	@Autowired
	HospitalMemberMapper hospitalMemberMapper;
	
	public List<HospitalMemberInqPrnReptSbDto> retreiveHospitalMember(HospitalMemberEntity input) throws Exception{
		List<HospitalMemberInqPrnReptSbDto> output = new ArrayList<HospitalMemberInqPrnReptSbDto>();
		List<HospitalMemberEntity> result = new ArrayList<HospitalMemberEntity>();
		try {
			result = hospitalMemberMapper.retreiveHospitalMember(input);
		}catch(Exception e) {
			return output;
		}
		for(HospitalMemberEntity entity : result) {
			HospitalMemberInqPrnReptSbDto tmp = new HospitalMemberInqPrnReptSbDto();
			BeanUtils.copyProperties(entity, tmp);
			output.add(tmp);
		}
		
		return output;
	}
	
	public List<HospitalMemberInqPrnReptSbDto> retreiveHospitalDept(HospitalMemberEntity input) throws Exception{
		List<HospitalMemberInqPrnReptSbDto> output = new ArrayList<HospitalMemberInqPrnReptSbDto>();
		List<HospitalMemberEntity> result = new ArrayList<HospitalMemberEntity>();
		try {
			result = hospitalMemberMapper.retreiveHospitalDept(input);
		}catch(Exception e) {
			return output;
		}
		for(HospitalMemberEntity entity : result) {
			HospitalMemberInqPrnReptSbDto tmp = new HospitalMemberInqPrnReptSbDto();
			BeanUtils.copyProperties(entity, tmp);
			output.add(tmp);
		}
		
		return output;
	}
}
