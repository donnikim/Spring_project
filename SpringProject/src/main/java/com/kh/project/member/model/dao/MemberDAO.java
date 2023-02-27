package com.kh.project.member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.project.member.model.vo.Member;

public interface MemberDAO {

	Member login(SqlSessionTemplate sqlSession, Member m);

	int insertMember(SqlSessionTemplate sqlSession, Member m);

	ArrayList<HashMap<String,Object>> selectMyList(SqlSessionTemplate sqlSession, String id);

}
