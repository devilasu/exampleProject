package com.grd.hosp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class HospitalMemberEntity {
	private String member_id;
	private String hospital_id;
	private String name;
	private String dept;
}
