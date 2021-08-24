package com.ae.ae1.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ae.ae1.util.DBConnector;

public class BankbookDAO {
	
	private DBConnector dbConnector;
	
	
	public BankbookDAO() {
		dbConnector = new DBConnector();
	}
	
	
	public ArrayList<BankbookDTO> getList() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<BankbookDTO> ar = new ArrayList<BankbookDTO>();
		
		try {
			con = dbConnector.getConnect();
			String sql = "SELECT * FROM PRODUCT";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				BankbookDTO bankbookDTO = new BankbookDTO();
				bankbookDTO.setPro_num(rs.getInt("Pro_num"));
				bankbookDTO.setPro_name(rs.getString("Pro_name"));
				bankbookDTO.setInterest_rate(rs.getDouble("Interest_rate"));
				bankbookDTO.setOn_sale(rs.getInt("ON_SALE"));
				ar.add(bankbookDTO);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(rs, st, con);
		}
		return ar;
	}
	
	
	
	public BankbookDTO getSelect(BankbookDTO bankbookDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		BankbookDTO result = null;
		
		try {
			con = dbConnector.getConnect();
			String sql = "Select * from PRODUCT WHERE PRO_NUM=?";
			st = con.prepareStatement(sql);
			st.setInt(1, bankbookDTO.getPro_num());
			rs = st.executeQuery();
			
			if(rs.next()) {
				result = new BankbookDTO();
				result.setPro_num(rs.getInt("Pro_num"));
				result.setPro_name(rs.getString("Pro_name"));
				result.setInterest_rate(rs.getDouble("Interest_rate"));
				result.setOn_sale(rs.getInt("ON_SALE"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnector.disConnect(rs, st, con);
		}
		
		return result;
		
	}
	
}
