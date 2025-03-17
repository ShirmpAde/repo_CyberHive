package com.example.module.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeService {
	
	@Autowired
	CodeDao codeDao;
	
	public List<CodeDao> selectList(){
		return codeDao.selectList();
	}
	
	public int seletOneCount(){
		return codeDao.selectOneCount();
	}
	
	public Object selectOne(CodeDao codeDao) {
		return codeDao.selectOne(codeDao);
	}
	
	public int insert(CodeDao codeDao) {
		return codeDao.insert(codeDao);
	}
	
	public int update2(CodeDao codeDao) {
		return codeDao.update(codeDao);
	}
	
	public int delete2(CodeDao codeDao) {
		return codeDao.delete(codeDao);
	}
	
	public int uelete2(CodeDao codeDao) {
		return codeDao.uelete(codeDao);
	}
}

