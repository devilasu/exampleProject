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
	private String reserve_time;
	private String accept;
	private String symptom;
	private String name;
	private String doctor_name;
	private String doctor_dept;
	private String hospital_name;
}
