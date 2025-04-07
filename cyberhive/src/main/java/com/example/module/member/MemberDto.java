package com.example.module.member;

public class MemberDto {
	private String seq;
	private Integer authLevel;
	private String id;
	private String password;
	private String surName;
	private String name;
	private Integer gender_code;
	private Integer telecom_code;
	private String birthDate;
//-----
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public Integer getAuthLevel() {
		return authLevel;
	}
	public void setAuthLevel(Integer authLevel) {
		this.authLevel = authLevel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
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
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
}