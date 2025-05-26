package com.example.module.payment;

import com.example.common.base.BaseDao;

public interface PayDao extends BaseDao {
	
	public int insert(PayDto payDto);
}
