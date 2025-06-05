package com.example.module.product;

import com.example.module.filesupload.FilesUploadDto;

public class ProductDto extends FilesUploadDto {

	private String prdtSeq;
	private String prdtName;
	private Integer prdtCateCd;
	private String prdtStatus;
	private Integer prdtPrice;
	private Integer  prdtUseNy = 1;
	private Integer  prdtDelNy = 0;
	private String prdtRegDate;
	private String prdtModDate;
	private String prdtDesc;
	private Double abv;
	private Integer ibu;
	private String volume;
	private Integer countryCode;
	private String brewery;
	
	private String path; // 이미지
	
	private int uploadImg1Type = 1001;
	private int uploadImg1MaxNumber = 1001;
//-----
	public String getPrdtSeq() {
		return prdtSeq;
	}
	public void setPrdtSeq(String prdtSeq) {
		this.prdtSeq = prdtSeq;
	}
	public String getPrdtName() {
		return prdtName;
	}
	public void setPrdtName(String prdtName) {
		this.prdtName = prdtName;
	}
	public Integer getPrdtCateCd() {
		return prdtCateCd;
	}
	public void setPrdtCateCd(Integer prdtCateCd) {
		this.prdtCateCd = prdtCateCd;
	}
	public String getPrdtStatus() {
		return prdtStatus;
	}
	public void setPrdtStatus(String prdtStatus) {
		this.prdtStatus = prdtStatus;
	}
	public Integer getPrdtPrice() {
		return prdtPrice;
	}
	public void setPrdtPrice(Integer prdtPrice) {
		this.prdtPrice = prdtPrice;
	}
	public Integer getPrdtUseNy() {
		return prdtUseNy;
	}
	public void setPrdtUseNy(Integer prdtUseNy) {
		this.prdtUseNy = prdtUseNy;
	}
	public Integer getPrdtDelNy() {
		return prdtDelNy;
	}
	public void setPrdtDelNy(Integer prdtDelNy) {
		this.prdtDelNy = prdtDelNy;
	}
	public String getPrdtRegDate() {
		return prdtRegDate;
	}
	public void setPrdtRegDate(String prdtRegDate) {
		this.prdtRegDate = prdtRegDate;
	}
	public String getPrdtModDate() {
		return prdtModDate;
	}
	public void setPrdtModDate(String prdtModDate) {
		this.prdtModDate = prdtModDate;
	}
	public String getPrdtDesc() {
		return prdtDesc;
	}
	public void setPrdtDesc(String prdtDesc) {
		this.prdtDesc = prdtDesc;
	}
	public Double getAbv() {
		return abv;
	}
	public void setAbv(Double abv) {
		this.abv = abv;
	}
	public Integer getIbu() {
		return ibu;
	}
	public void setIbu(Integer ibu) {
		this.ibu = ibu;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public Integer getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(Integer countryCode) {
		this.countryCode = countryCode;
	}
	public String getBrewery() {
		return brewery;
	}
	public void setBrewery(String brewery) {
		this.brewery = brewery;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getUploadImg1Type() {
		return uploadImg1Type;
	}
	public void setUploadImg1Type(int uploadImg1Type) {
		this.uploadImg1Type = uploadImg1Type;
	}
	public int getUploadImg1MaxNumber() {
		return uploadImg1MaxNumber;
	}
	public void setUploadImg1MaxNumber(int uploadImg1MaxNumber) {
		this.uploadImg1MaxNumber = uploadImg1MaxNumber;
	}

}
