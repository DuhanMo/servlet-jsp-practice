package com.kh.jsp.member.exception;

public class MemberException extends Exception{
	
	// 사용자 정의 예외처리를 구현
	public MemberException() {
		super();
	}

	public MemberException(String msg) {
		super(msg);
	}

}
