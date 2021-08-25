package com.ae.ae1.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ae.ae1.util.DBConnector;

public class AccountDAO {
	
	private DBConnector dbConnector;
	
	public AccountDAO() {
		dbConnector = new DBConnector();
	}
	
	public ArrayList<AccountDTO> getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<AccountDTO> ar = new ArrayList<AccountDTO>();
		
		try {
			con = dbConnector.getConnect();
			String sql = "SELECT * FROM ACCOUNT";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				AccountDTO accountDTO = new AccountDTO();
				accountDTO.setAccount_num(rs.getLong("account_num"));
				accountDTO.setId(rs.getString("id"));
				accountDTO.setBook_num(rs.getLong("book_num"));
				accountDTO.setAccount_date(rs.getDate("account_date"));
				accountDTO.setAccount_balance(rs.getLong("account_balance"));
				ar.add(accountDTO);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dbConnector.disConnect(rs, st, con);
		}
		
		return ar;
	}
	
	
}
