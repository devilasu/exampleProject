package com.grd.hosp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class HospitalEntity {
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String address;
}
