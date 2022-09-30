
package com.zlabs;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class TransactionLogsPojo {
	private String mailid;
	private String date;
	private String acc_no;
	
	public String getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(String acc_no) {
		this.acc_no = acc_no;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public TransactionLogsPojo(String mailid,String acc_no, String transaction_type, double amt,String date) {
		super();
		this.mailid = mailid;
		this.acc_no=acc_no;
		this.transaction_type = transaction_type;
		this.amt = amt;
		this.date=date;
		
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	

	
	private String transaction_type;
	private double amt;
	 
	
}
