package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.MemberDao;
import bit.com.a.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "Member.";
	
	
	@Override
	public String idCheck(String id) {
		String s = sqlSession.selectOne(namespace + "idcheck", id);
		return s;
	};
	
	
	
	@Override
	public int addMember(MemberDto dto) {
		int i = sqlSession.insert(namespace + "addMember", dto);
		return i;
	};
	
	
	@Override
	public MemberDto login(MemberDto dto) {
		MemberDto mem = sqlSession.selectOne(namespace + "login", dto);
		return mem;
	}
	
	

}
