package bit.com.a.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BbsDao;
import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;
import bit.com.a.service.BbsService;


@Service
public class BbsServiceImpl implements BbsService {
	
	
	@Autowired
	BbsDao bbsDao;

	@Override
	public List<BbsDto> getBbsList() {
		return bbsDao.getBbsList();
	}
	
	@Override
	public List<BbsDto> getBbsPagingList(BbsParam bbsParam) {
	return bbsDao.getBbsPagingList(bbsParam);
	}
	
	@Override
	public int getAllBbs(BbsParam bbsParam) {
		return bbsDao.getAllBbs(bbsParam);
	}
	
	@Override
	public int writeBbs(BbsDto dto) {
		return bbsDao.writeBbs(dto);
	}
	
	
	@Override
	public BbsDto getDetail(int seq) {
		return bbsDao.getDetail(seq);
	}
	
	
	@Override
	public boolean delete(int seq) {
		return bbsDao.delete(seq);
	}
	
	
	@Override
	public boolean update(BbsDto dto) {
		return bbsDao.update(dto);
	}
	
	@Override
	public boolean answerUpdate(int seq) {
		return bbsDao.answerUpdate(seq);
	}
	
	@Override	
	public boolean answerInsert(BbsDto dto) {
		return bbsDao.answerInsert(dto);
	}	
	

}
