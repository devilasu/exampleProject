package com.grd.hosp.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grd.Util.SessionUtil;
import com.grd.hosp.dao.MemberMapper;
import com.grd.hosp.dto.LoginInpDto;
import com.grd.hosp.dto.MemberRegInpDto;
import com.grd.hosp.dto.MemberInqPrnDto;
import com.grd.hosp.dto.MemberPutInpDto;
import com.grd.hosp.entity.MemberEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberMgntService {
	
	@Autowired
	MemberMapper memberMapper;
	
	//회원가입
	public boolean registMember(MemberRegInpDto input) throws Exception {
		MemberEntity joinInput = new MemberEntity();
		
		BeanUtils.copyProperties(input, joinInput);
		try {
			memberMapper.join(joinInput);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
	
	
	
	//개인정보 조회
	public MemberInqPrnDto retrieveMe() throws Exception {
		MemberInqPrnDto output = new MemberInqPrnDto();
		
		if(SessionUtil.getSession("loginEntity") == null) {
			log.info("로그인 정보가 없습니다");
			return null;
		}
		
		MemberEntity result = memberMapper.selectById(((MemberEntity)SessionUtil.getSession("loginEntity")).getId());
		
		BeanUtils.copyProperties(result, output);
		
		return output;
	}
	
	
	
	//개인정보 수정
	public boolean updateMember(MemberPutInpDto input) throws Exception {
		MemberEntity loginEntity = (MemberEntity)SessionUtil.getSession("loginEntity");
		if(loginEntity == null) {
			log.info("로그인 정보가 없습니다");
			return false;
		}
		
		MemberEntity updateInput = new MemberEntity();
		
		BeanUtils.copyProperties(input, updateInput);
		updateInput.setId(loginEntity.getId());
		try {
			memberMapper.updateMember(updateInput);
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean login(LoginInpDto input) throws Exception{
		MemberEntity loginInput = new MemberEntity();
		MemberEntity loginData = new MemberEntity();
		BeanUtils.copyProperties(input, loginInput);
		try {
			loginData = memberMapper.login(loginInput);
		}catch(Exception e) {
			return false;
		}
		if(loginData != null) {
			SessionUtil.setSession("loginEntity", loginData);
			return true;
		}else {
			return false;
		}
		
	}
}
