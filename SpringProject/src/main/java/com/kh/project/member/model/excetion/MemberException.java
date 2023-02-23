package com.kh.project.member.model.excetion;

public class MemberException extends RuntimeException {
	public MemberException() {}
	
	public MemberException(String msg) {
		super(msg);
	}
}
