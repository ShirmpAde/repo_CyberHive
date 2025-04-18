package com.example.module.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	MemberDao memberDao;
	
//	회원가입 축하 메일
    public void sendMailWelcome(MemberDto memberDto) throws Exception{
    	
    	MimeMessage mimeMessage = javaMailSender.createMimeMessage();
    	MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
    	mimeMessageHelper.setTo("jiho6202@gmail.com"); 
    	mimeMessageHelper.setSubject("안녕하세요");
    	mimeMessageHelper.setText("ㅎㅇ", true); 
    	javaMailSender.send(mimeMessage);
    	
    }
}
