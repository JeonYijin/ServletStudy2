package com.ae.ae1.test;

import java.sql.Connection;
import java.util.ArrayList;

import com.ae.ae1.account.AccountDAO;
import com.ae.ae1.account.AccountDTO;
import com.ae.ae1.bankbook.BankbookDAO;
import com.ae.ae1.bankbook.BankbookDTO;
import com.ae.ae1.util.DBConnector;

public class DBTest {

	public static void main(String[] args) {
		
		//Test
//		DBConnector dbConnector = new DBConnector();
//		Connection con = dbConnector.getConnect();
//		System.out.println(con);
		
		
		//BankbookDAO getSelect Test
		BankbookDAO bankbookDAO = new BankbookDAO();
		BankbookDTO bankbookDTO = new BankbookDTO();
//		bankbookDTO.setPro_num(1000);
//		
//		BankbookDTO result = new BankbookDTO();
//		result = bankbookDAO.getSelect(bankbookDTO);
//		
//		System.out.println(result.getPro_num());
//		System.out.println(result.getPro_name());
//		System.out.println(result.getInterest_rate());
//		System.out.println(result.getOn_sale());
		
		
		//getList test - account
//		AccountDAO accountDAO = new AccountDAO();
//		ArrayList<AccountDTO> ar = accountDAO.getList();
//		for(AccountDTO accountDTO: ar) {
//			System.out.println(accountDTO.getAccount_num());
//			System.out.println(accountDTO.getAccount_date());
//			System.out.println(accountDTO.getAccount_balance());
//			System.out.println("--------------");
//		}
		
		
		//getList test
		
//		ArrayList<BankbookDTO> ar = bankbookDAO.getList();
//		for(int i=0; i<ar.size(); i++) {
//			System.out.println(ar.get(i).getBook_name());
//		}
//		
		
	}

}
