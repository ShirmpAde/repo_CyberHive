package com.example.module.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	public MemberDto selectOneLogin(MemberDto memberDto) {
		return memberDao.selectOneLogin(memberDto);
	}
	
	public MemberDto getIdPass(MemberDto memberDto) {
		return memberDao.getIdPass(memberDto);
	}
	
	public List<MemberDto> selectList(MemberVo vo){
		return memberDao.selectList(vo);
	}
	
	public int selectOneCount(MemberVo vo) {
		return memberDao.selectOneCount(vo);
	}
	
	public Object selectOne(MemberDto memberDto) {
		return memberDao.selectOne(memberDto);
	}
	
	public Object selectOne(MemberVo memberVo) {
		return memberDao.selectOne(memberVo);
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
	
	public boolean isIdDuplicate(String id) {
	    MemberDto memberDto = new MemberDto();
	    memberDto.setId(id);
	    return memberDao.selectId(memberDto) != null;  // 존재하면 true
	}

}