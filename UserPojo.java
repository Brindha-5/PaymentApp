
package com.zlabs;

public class UserPojo {
	public UserPojo(String user_name, String mail_id, String password,String invite_code) {
		super();
		this.user_name = user_name;
		this.mail_id = mail_id;
		this.password = password;
		this.invite_code=invite_code;
	}
	private String user_name;
	private String invite_code;
	public String getInvite_code() {
		return invite_code;
	}
	public void setInvite_code(String invite_code) {
		this.invite_code = invite_code;
	}
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
	private String password;
	
	

}
