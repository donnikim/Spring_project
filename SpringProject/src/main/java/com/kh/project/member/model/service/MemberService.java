package com.kh.project.member.model.service;

import com.kh.project.member.model.vo.Member;

public interface MemberService {

	Member login(Member m);

	int insertMember(Member m);

}
