package com.grd.hosp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReservationEntity {
	private String reserve_no;
	private String member_id;
	private String hospital_member_id;
	private String reserve_date;
	private String symptom;
	private String accept;
}
