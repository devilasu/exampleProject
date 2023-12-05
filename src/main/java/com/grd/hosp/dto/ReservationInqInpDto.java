package com.grd.hosp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReservationInqInpDto {
	private String accept;
	private String hospitalId;
	private String memberId;
}
