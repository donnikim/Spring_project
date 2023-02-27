package com.kh.project.member.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.project.member.model.vo.Member;

@Repository("mDAO")
public class MemberDAOImpl implements MemberDAO {

	@Override
	public Member login(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.login",m);
	}

	@Override
	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("memberMapper.insertMember", m);
	}

	@Override
	public ArrayList<HashMap<String,Object>> selectMyList(SqlSessionTemplate sqlSession, String id) {
		ArrayList<HashMap<String,Object>> list= (ArrayList)sqlSession.selectList("memberMapper.selectMyList",id);
		System.out.println(list); //vo를 만들지 않고 맵을 활용하여 만들 수 있다.
		return list;
	}

}
