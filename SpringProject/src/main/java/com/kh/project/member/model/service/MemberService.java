package com.kh.project.member.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.project.member.model.vo.Member;

public interface MemberService {

	Member login(Member m);

	int insertMember(Member m);

	ArrayList<HashMap<String,Object>> selectMyList(String id);



}
