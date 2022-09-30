
package com.zlabs;

public class UserPojo {
	public UserPojo(String user_name, String mail_id, String password) {
		super();
		this.user_name = user_name;
		this.mail_id = mail_id;
		this.password = password;
		//this.invitecode=invitecode;
	}
	private String user_name;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getMail_id() {
		return mail_id;
	}
	public void setMail_id(String mail_id) {
		this.mail_id = mail_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String mail_id;
	public int getInvitecode() {
		return invitecode;
	}
	public void setInvitecode(int invitecode) {
		this.invitecode = invitecode;
	}
	private String password;
	private int invitecode;
	

}
