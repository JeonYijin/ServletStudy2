package com.ae.ae1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ae.ae1.util.DBConnector;

public class MemberDAO {
	
	private DBConnector dbConnector;
	
	public MemberDAO() {
		dbConnector= new DBConnector();
	}
	
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		con = dbConnector.getConnect();
		String sql = "Insert Into member(ID, PW, NAME, PHONE, EMAIL)"
				+ "VALUES(?,?,?,?,?)";
		
		st = con.prepareStatement(sql);
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getPhone());
		st.setString(5, memberDTO.getEmail());
			
		result = st.executeUpdate();
			
		
		return result;
		
	}
	
	
	
	
}
