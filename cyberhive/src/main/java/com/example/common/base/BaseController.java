package com.example.common.base;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.common.util.UtilDateTime;

public class BaseController {
	
	public void utildatetime(BaseVo vo) {
		vo.setShDateStart(vo.getShDateStart() == null || vo.getShDateStart() == "" ? null : UtilDateTime.add00TimeString(vo.getShDateStart()));
		vo.setShDateEnd(vo.getShDateEnd() == null || vo.getShDateEnd() == "" ? null : UtilDateTime.add59TimeString(vo.getShDateEnd()));
	}
	
	public String encodeBcrypt(String planeText, int strength) {
		  return new BCryptPasswordEncoder(strength).encode(planeText);
	}

			
	public boolean matchesBcrypt(String planeText, String hashValue, int strength) {
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
	  return passwordEncoder.matches(planeText, hashValue);
	}
	
	protected void setSearch(BaseVo vo) {
        if (vo.getSearchKeyword() != null) {
            vo.setSearchKeyword(vo.getSearchKeyword().trim());
        }

        // 필요 시 검색 구분 값 등 추가 설정 가능
        if (vo.getSearchOption() != null) {
            vo.setSearchOption(vo.getSearchOption().trim());
        }

        // 날짜 검색 등 공통 조건 처리도 여기에 넣을 수 있음
    }
}
