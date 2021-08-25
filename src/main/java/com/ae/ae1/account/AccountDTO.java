package com.ae.ae1.account;

import java.sql.Date;

public class AccountDTO {
	
	private long account_num;
	private String id;
	private long book_num;
	private Date account_date;
	private long account_balance;
	public long getAccount_num() {
		return account_num;
	}
	public void setAccount_num(long account_num) {
		this.account_num = account_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getBook_num() {
		return book_num;
	}
	public void setBook_num(long book_num) {
		this.book_num = book_num;
	}
	public Date getAccount_date() {
		return account_date;
	}
	public void setAccount_date(Date account_date) {
		this.account_date = account_date;
	}
	public long getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(long account_balance) {
		this.account_balance = account_balance;
	}
	
	
	
}
