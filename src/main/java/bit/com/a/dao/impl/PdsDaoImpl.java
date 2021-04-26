package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.PdsDao;
import bit.com.a.dto.PdsDto;


@Repository
public class PdsDaoImpl implements PdsDao {
	
	
	@Autowired
	SqlSession session;
	
	String ns = "Pds.";
	
	
	
	@Override
	public List<PdsDto> getPdsList() {
		return session.selectList(ns+"getPdsList");
	}
	
	@Override
	public boolean uploadPds(PdsDto dto) {
		int i = session.insert(ns+"uploadPds", dto);
		return i>0?true:false;
	}
	
	@Override
	public String getFileName(String newFilename) {
		return session.selectOne(ns+"getFilename", newFilename);
	}
	
	
	@Override
	public boolean readCount(int seq) {
		int i = session.update(ns+"readCount", seq);
		return i>0?true:false;
	}
	
	
	@Override
	public boolean downCount(int seq) {
		int i = session.update(ns+"downloadCount", seq);
		return i>0?true:false;
	}
	
	
	
	@Override
	public PdsDto getDetail(int seq) {
		return session.selectOne(ns+"getDetail", seq);
	}
	
	
	@Override
	public boolean deletePds(int seq) {
		int i = session.delete(ns+"delete", seq);
		return i>0?true:false;
	}
	
	@Override
	public boolean updatePds(PdsDto dto) {
		int i = session.update(ns+"update", dto);
		return i>0?true:false;
	}
	
	

}
