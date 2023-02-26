package com.kh.project.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.project.member.model.vo.Member;

public interface MemberDAO {

	Member login(SqlSessionTemplate sqlSession, Member m);

	int insertMember(SqlSessionTemplate sqlSession, Member m);

}
