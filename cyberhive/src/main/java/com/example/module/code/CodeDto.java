package com.example.module.code;

import java.util.ArrayList;
import java.util.List;

public class CodeDto {
//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
	private String seq;
	private String name;
	private Integer delNy;
	private String useNy;
	private Integer codeGroup_seq;
//	-----
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDelNy() {
		return delNy;
	}
	public void setDelNy(Integer delNy) {
		this.delNy = delNy;
	}
	public String getUseNy() {
		return useNy;
	}
	public void setUseNy(String useNy) {
		this.useNy = useNy;
	}
	public Integer getCodeGroup_seq() {
		return codeGroup_seq;
	}
	public void setCodeGroup_seq(Integer codeGroup_seq) {
		this.codeGroup_seq = codeGroup_seq;
	}
	
}
