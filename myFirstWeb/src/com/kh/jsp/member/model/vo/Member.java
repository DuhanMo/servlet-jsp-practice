package com.kh.jsp.member.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6946062357741025709L;
	
	// 1. 필드변수 / 멤버변수
	private String userId;	// 사용자 아이디
	private String userPwd; // 사용자 비밀번호
	private String userName;// 사용자 이름
	private String gender;  // 성별
	private int age;        // 나이
	private String email;   // 이메일
	private String phone;   // 연락처
	private String address; // 주소 
	private String hobby;   // 취미
	private Date enrollDate;// 가입일
	
	public Member() {
	}

	public Member(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}

	public Member(String userId, String userPwd, String userName, String gender, int age, String email, String phone,
			String address, String hobby) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
	}

	public Member(String userId, String userPwd, String userName, String gender, int age, String email, String phone,
			String address, String hobby, Date enrollDate) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.hobby = hobby;
		this.enrollDate = enrollDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", gender=" + gender
				+ ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address + ", hobby=" + hobby
				+ ", enrollDate=" + enrollDate + "]";
	}
	
	
	
}
