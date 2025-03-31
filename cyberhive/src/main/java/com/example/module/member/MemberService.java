package com.example.module.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public List<MemberDto> selectList(MemberVo vo){
		return memberDao.selectList(vo);
	}
	
	public int seletOneCount(){
		return memberDao.selectOneCount();
	}
	
	public Object selectOne(MemberDto memberDto) {
		return memberDao.selectOne(memberDto);
	}
		
	public int insert(MemberDto memberDto) {
		return memberDao.insert(memberDto);
	}
	
	public int update(MemberDto memberDto) {
		return memberDao.update(memberDto);
	}
	
	public int delete(MemberDto memberDto) {
		return memberDao.delete(memberDto);
	}
	
	public int uelete(MemberDto memberDto) {
		return memberDao.uelete(memberDto);
	}
	
	public MemberDto signinChk(MemberDto memberDto){
		return memberDao.signinChk(memberDto);
	}
	
}