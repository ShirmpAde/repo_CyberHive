package com.example.module.product;

import com.example.common.base.BaseVo;

public class ProductVo extends BaseVo {
	
	private String seq;
	
	private String prdtSeq;
	
	private Integer prdtUseNy = 1;
	private Integer prdtDelNy = 0;
//	-----
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getPrdtSeq() {
		return prdtSeq;
	}
	public void setPrdtSeq(String prdtSeq) {
		this.prdtSeq = prdtSeq;
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
	
}
