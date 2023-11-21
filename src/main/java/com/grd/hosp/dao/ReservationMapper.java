package com.grd.hosp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.grd.hosp.dto.ReservationInqInpDto;
import com.grd.hosp.dto.ReservationInqPrnReptSbDto;
import com.grd.hosp.entity.ReservationEntity;

@Mapper
public interface ReservationMapper {
	public List<ReservationInqPrnReptSbDto> retreiveReservation(ReservationInqInpDto input) throws Exception;
	public boolean registReservation(ReservationEntity input) throws Exception;
	public boolean updateReservation(ReservationEntity input) throws Exception;
}
