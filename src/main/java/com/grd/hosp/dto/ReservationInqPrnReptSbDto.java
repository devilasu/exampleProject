package com.grd.hosp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReservationInqPrnReptSbDto {
	private String reserve_no;
	private String member_id;
	private String hospital_member_id;
	private String reserve_date;
	private String accept;
	private String name;
}