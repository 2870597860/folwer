package com.flower.entitles;

public class User {
	private int id;
	private String userName;
	private String passWord;
	private String realName;
	private String address;
	private int photoNum;
	
	
	
	public User(String userName, String passWord, 
			String realName, String address, int photoNum) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.realName = realName;
		this.address = address;
		this.photoNum = photoNum;
	}
	
	
	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}


	public User() {
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public  String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhotoNum() {
		return photoNum;
	}
	public void setPhotoNum(int photoNum) {
		this.photoNum = photoNum;
	}
	
	
}
