package bit.com.a.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;


@Repository
public class BbsDaoImpl implements BbsDao {
	
	@Autowired
	SqlSession sqlSession;
	
	String ns = "Bbs.";

	@Override
	public List<BbsDto> getBbsList() {
		return sqlSession.selectList(ns+"bbslist");
	}
	
	@Override
	public List<BbsDto> getBbsPagingList(BbsParam bbsParam) {
		return sqlSession.selectList(ns+"bbsPagingList", bbsParam);
	}
	
	@Override
	public int getAllBbs(BbsParam bbsParam) {
		return sqlSession.selectOne(ns+"allBbs", bbsParam);
	}
	
	@Override
	public int writeBbs(BbsDto dto) {
		return sqlSession.insert(ns+"write", dto);
	}
	
	@Override
	public BbsDto getDetail(int seq) {
		return sqlSession.selectOne(ns+"detail", seq);
	}
	
	@Override
	public boolean delete(int seq) {
		int i = sqlSession.update(ns+"delete", seq);
		
		return i>0?true:false;
	}
	
	@Override
	public boolean update(BbsDto dto) {
		int i = sqlSession.update(ns+"update", dto);
		
		return i>0?true:false;
	}
	
	
	@Override
	public boolean answerUpdate(int seq) {
		int i = sqlSession.update(ns+"answerUpdate", seq);
		return i>0?true:false;
	}
	
	@Override
	public boolean answerInsert(BbsDto dto) {
		int i = sqlSession.insert(ns+"answerInsert", dto);
		return i>0?true:false;
	}
	
	

}
