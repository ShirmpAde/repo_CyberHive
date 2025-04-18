package com.example.module.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface CodeGroupDao {
	
	public int selectOneCount();
	public List<CodeGroupDto> selectList(CodeGroupVo vo);
	public CodeGroupDto selectOne(CodeGroupDto codeGroupDto);
	public CodeGroupDto selectOne(CodeGroupVo codeGroupVo);
	public int insert(CodeGroupDto codeGroupDto);
	public int update(CodeGroupDto codeGroupDto);
	public int delete(CodeGroupDto codeGroupDto);
	public int uelete(CodeGroupDto codeGroupDto);
	public int selectListWithoutPaging(CodeGroupVo codeGroupVo);
}
