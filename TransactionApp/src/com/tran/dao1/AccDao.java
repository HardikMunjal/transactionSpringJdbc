package com.tran.dao1;

public interface AccDao {
	public void credit(int id,int amount) throws Exception;
	public void debit(int id,int amount) throws Exception;
}
