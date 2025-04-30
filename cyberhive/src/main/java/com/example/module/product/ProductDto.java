package com.example.module.product;

import org.springframework.web.multipart.MultipartFile;

import com.example.common.base.BaseDto;

public class ProductDto extends BaseDto {

//	 기본 필드
	private String ifbnSeq;
    private Integer uploadImg1Type;
    private Integer uploadImg1MaxNumber;
    
	private MultipartFile[] uploadImg1;
//-----

	public String getIfbnSeq() {
		return ifbnSeq;
	}

	public void setIfbnSeq(String ifbnSeq) {
		this.ifbnSeq = ifbnSeq;
	}

	public Integer getUploadImg1Type() {
		return uploadImg1Type;
	}

	public void setUploadImg1Type(Integer uploadImg1Type) {
		this.uploadImg1Type = uploadImg1Type;
	}

	public Integer getUploadImg1MaxNumber() {
		return uploadImg1MaxNumber;
	}

	public void setUploadImg1MaxNumber(Integer uploadImg1MaxNumber) {
		this.uploadImg1MaxNumber = uploadImg1MaxNumber;
	}

	public MultipartFile[] getUploadImg1() {
		return uploadImg1;
	}

	public void setUploadImg1(MultipartFile[] uploadImg1) {
		this.uploadImg1 = uploadImg1;
	}

}
