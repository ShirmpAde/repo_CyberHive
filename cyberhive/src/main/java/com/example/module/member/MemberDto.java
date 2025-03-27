package com.example.module.member;

public class MemberDto {
	private String seq;
	private String id;
	private String name;
	private Integer gender_code;
	private Integer telecom_code;
	private String password;
//-----
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender_code() {
		return gender_code;
	}
	public void setGender_code(Integer gender_code) {
		this.gender_code = gender_code;
	}
	public Integer getTelecom_code() {
		return telecom_code;
	}
	public void setTelecom_code(Integer telecom_code) {
		this.telecom_code = telecom_code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
