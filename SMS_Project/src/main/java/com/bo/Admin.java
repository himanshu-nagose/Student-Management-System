package com.bo;

public class Admin {
	private String adminPasskey;
	private String adminName;
	private String adminEmail;
	private String adminUsername;
	private String adminPassword;
	
	public Admin() {
		
	}
	
	public Admin(String adminPasskey, String adminName, String adminEmail, String adminUsername, String adminPassword) {
		super();
		this.adminPasskey = adminPasskey;
		this.adminName = adminName;
		this.adminEmail = adminEmail;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}
	
	public String getAdminPasskey() {
		return adminPasskey;
	}
	public void setAdminPasskey(String adminPasskey) {
		this.adminPasskey = adminPasskey;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminUsername() {
		return adminUsername;
	}
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
}
