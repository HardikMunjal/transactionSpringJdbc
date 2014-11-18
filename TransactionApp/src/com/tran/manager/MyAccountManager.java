package com.tran.manager;


import org.springframework.transaction.annotation.Transactional;

import com.tran.dao1.AccDao;

public class MyAccountManager implements AccuntManager {
	AccDao dao;
	public void setDao(AccDao dao) {
	this.dao = dao;
	}
	@Transactional(rollbackFor={java.lang.Exception.class})	
public void transfer(int src, int target, int amount) 
		throws Exception
	{ 
		
		dao.credit(target, amount);
		dao.debit(src, amount);
	}

}
