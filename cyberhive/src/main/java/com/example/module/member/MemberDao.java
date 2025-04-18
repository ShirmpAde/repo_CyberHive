package com.example.module.member;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao {
	public int selectOneCount();
	public List<MemberDto> selectList(MemberVo vo);
	public MemberDto selectOne(MemberDto memberDto);
	public MemberVo selectOne(MemberVo memberVo);
	public int insert(MemberDto memberDto);
	public int update(MemberDto memberDto);
	public int delete(MemberDto memberDto);
	public int uelete(MemberDto memberDto);
	public MemberDto signinChk(MemberDto memberDto);
	public MemberDto selectId(MemberDto memberDto);
}