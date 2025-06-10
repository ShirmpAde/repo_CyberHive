package com.example.module.product;

import com.example.common.base.BaseVo;

public class ProductVo extends BaseVo {
	
private String seq = "0";
	private String ifbnSeq;
//	-----
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getIfbnSeq() {
		return ifbnSeq;
	}
	public void setIfbnSeq(String ifbnSeq) {
		this.ifbnSeq = ifbnSeq;
	}

}