package com.example.module.payment;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.common.base.BaseService;

public class PayService extends BaseService {
	
	@Autowired
	PayDao payDao;
	
	public int insert(PayDto payDto) {
		return payDao.insert(payDto);
	}
}
