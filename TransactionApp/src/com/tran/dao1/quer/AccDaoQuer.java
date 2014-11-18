package com.tran.dao1.quer;


import java.sql.*;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.*;

import com.tran.dao1.*;

 class AccDaoQuer implements AccDao{

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource=dataSource;
	}
	DataSource dataSource;
	@Override
	public void credit(int id, int amount) throws Exception {
		
		Connection con=
				DataSourceUtils.getConnection(dataSource);
			PreparedStatement stmt=
			con.prepareStatement(
		"update Account set balance=balance+? "
		+ "where acno=?");
			stmt.setInt(1,amount);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			
			}
	

	@Override
	public void debit(int id, int amount) throws Exception {
		
		Connection con=
				DataSourceUtils.getConnection(dataSource);
			PreparedStatement stmt=con.prepareStatement(
			"update Account set balance=balance-? "
			+ "where acno=?");
			stmt.setInt(1,amount);
			stmt.setInt(2, id);
			String qr="select balance from Account where acno="+id;
			ResultSet rset=stmt.executeQuery(qr);
			if(rset.next())
			{
				int b=rset.getInt(1);
				if(b-amount<0)
					throw(new Exception("Insufficient Balance."));
				
				stmt.executeUpdate();
			}
			else
			{
				throw(new Exception("Invalid Account."));
				
			}
			
			}
	

}
