package com.grd.hosp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.grd.hosp.dto.HospitalLoginInpDto;
import com.grd.hosp.entity.HospitalEntity;

@Mapper
public interface HospitalMapper {
	public List<HospitalEntity> retreiveHospital() throws Exception;
	public int join(HospitalEntity input) throws Exception;
	public HospitalEntity login(HospitalLoginInpDto input) throws Exception;
}
