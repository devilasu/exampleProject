package com.grd.hosp.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberEntity {
	private String id;
	private String pw;
	private String name;
	private String address;
	private String phone;
	private String gender;
}
