package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.CalendarDao;
import bit.com.a.dto.CalParam;
import bit.com.a.dto.CalendarDto;

@Repository
public class CalendarDaoImpl implements CalendarDao {
	
	@Autowired
	SqlSession sqlSession;
	
	String ns = "Cal.";

	@Override
	public List<CalendarDto> getCalList(CalParam param) {
		return sqlSession.selectList(ns+"callist", param);
	}
	
	
	@Override
	public CalendarDto calDetail(int seq) {
		return sqlSession.selectOne(ns+"detail", seq);
	}
	
	@Override
	public int calWrite(CalendarDto dto) {
		return sqlSession.insert(ns+"write", dto);
	}

	
	@Override
	public int calDelete(int seq) {
		return sqlSession.delete(ns+"delete", seq);
	}
	
	
	@Override
	public int calUpdate(CalendarDto dto) {
		return sqlSession.update(ns+"update", dto);
	}
	
	@Override
	public List<CalendarDto> getDayList(CalParam param) {
		return sqlSession.selectList(ns+"daylist", param);
	}
	
	

}
