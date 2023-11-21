package com.grd.hosp.dao;

import org.apache.ibatis.annotations.Mapper;

import com.grd.hosp.entity.MemberEntity;

@Mapper
public interface MemberMapper {
	MemberEntity selectById(String id) throws Exception;
	MemberEntity login(MemberEntity input) throws Exception;
	int join(MemberEntity member) throws Exception;
	int updateMember(MemberEntity member) throws Exception;
}
