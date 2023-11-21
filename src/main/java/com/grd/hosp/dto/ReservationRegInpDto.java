package com.grd.hosp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReservationRegInpDto {
	private String memberId;
	private String hospitalMemberId;
	private String reserveDate;
}
