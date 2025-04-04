package com.example.module.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGroupService {

	@Autowired
	CodeGroupDao codeGroupDao;
	
	public List<CodeGroupDto> selectList(CodeGroupVo vo){
		return codeGroupDao.selectList(vo);
	}
	
	public int selectOneCount(){
		return codeGroupDao.selectOneCount();
	}
	
	public Object selectOne(CodeGroupDto codeGroupDto) {
		return codeGroupDao.selectOne(codeGroupDto);
	}
	
	public Object selectOne(CodeGroupVo codeGroupVo) {
		return codeGroupDao.selectOne(codeGroupVo);
	}
	
	public int insert(CodeGroupDto codeGroupDto) {
		return codeGroupDao.insert(codeGroupDto);
	}
	
	public int update(CodeGroupDto codeGroupDto) {
		return codeGroupDao.update(codeGroupDto);
	}
	
	public int delete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.delete(codeGroupDto);
	}
	
	public int uelete(CodeGroupDto codeGroupDto) {
		return codeGroupDao.uelete(codeGroupDto);
	}
	
	public int selectListWithoutPaging(CodeGroupVo codeGroupVo) {
		return codeGroupDao.selectListWithoutPaging(codeGroupVo);
	}
}
