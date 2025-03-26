package com.example.module.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codeDao;
	
	public List<CodeDto> selectList(CodeVo vo){
		return codeDao.selectList(vo);
	}
	
	public int seletOneCount(){
		return codeDao.selectOneCount();
	}
	
	public Object selectOne(CodeDto codeDto) {
		return codeDao.selectOne(codeDto);
	}
		
	public int insert(CodeDto codeDto) {
		return codeDao.insert(codeDto);
	}
	
	public int update(CodeDto codeDto) {
		return codeDao.update(codeDto);
	}
	
	public int delete(CodeDto codeDto) {
		return codeDao.delete(codeDto);
	}
	
	public int uelete(CodeDto codeDto) {
		return codeDao.uelete(codeDto);
	}
	
}

