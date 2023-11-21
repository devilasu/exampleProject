package com.grd.hosp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.grd.hosp.entity.HospitalMemberEntity;

@Mapper
public interface HospitalMemberMapper {
	public List<HospitalMemberEntity> retreiveHospitalMember(HospitalMemberEntity input) throws Exception;
	public List<HospitalMemberEntity> retreiveHospitalDept(HospitalMemberEntity input) throws Exception;
}
