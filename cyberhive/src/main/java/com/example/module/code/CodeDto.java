package com.example.module.code;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.common.base.BaseDto;

public class CodeDto extends BaseDto {
	private String codeSeq;
	private String codeName;
	private Integer codeUseNy;
	private Date codeRegDate;
	private Date codeModDate;
	private Integer codeDelNy;
	private String codegroup_cdgrSeq;
	private String cdgrSeq;
	private String cdgrName;
	
//	for cache
	public static List<CodeDto> cachedCodeArrayList = new ArrayList<CodeDto>();
//	-----

	public String getCodeSeq() {
		return codeSeq;
	}

	public void setCodeSeq(String codeSeq) {
		this.codeSeq = codeSeq;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public Integer getCodeUseNy() {
		return codeUseNy;
	}

	public void setCodeUseNy(Integer codeUseNy) {
		this.codeUseNy = codeUseNy;
	}

	public Date getCodeRegDate() {
		return codeRegDate;
	}

	public void setCodeRegDate(Date codeRegDate) {
		this.codeRegDate = codeRegDate;
	}

	public Date getCodeModDate() {
		return codeModDate;
	}

	public void setCodeModDate(Date codeModDate) {
		this.codeModDate = codeModDate;
	}

	public Integer getCodeDelNy() {
		return codeDelNy;
	}

	public void setCodeDelNy(Integer codeDelNy) {
		this.codeDelNy = codeDelNy;
	}

	public String getCodegroup_cdgrSeq() {
		return codegroup_cdgrSeq;
	}

	public void setCodegroup_cdgrSeq(String codegroup_cdgrSeq) {
		this.codegroup_cdgrSeq = codegroup_cdgrSeq;
	}

	public String getCdgrSeq() {
		return cdgrSeq;
	}

	public void setCdgrSeq(String cdgrSeq) {
		this.cdgrSeq = cdgrSeq;
	}

	public String getCdgrName() {
		return cdgrName;
	}

	public void setCdgrName(String cdgrName) {
		this.cdgrName = cdgrName;
	}

	public static List<CodeDto> getCachedCodeArrayList() {
		return cachedCodeArrayList;
	}

	public static void setCachedCodeArrayList(List<CodeDto> cachedCodeArrayList) {
		CodeDto.cachedCodeArrayList = cachedCodeArrayList;
	}

}
