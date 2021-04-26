package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.PdsDao;
import bit.com.a.dto.PdsDto;
import bit.com.a.service.PdsService;

@Service
public class PdsServiceImpl implements PdsService {
	
	
	@Autowired
	PdsDao dao;
	
	
	@Override
	public List<PdsDto> getPdsList() {
		return dao.getPdsList();
	}
	
	
	@Override
	public boolean uploadPds(PdsDto dto) {
		return dao.uploadPds(dto);
	}
	
	
	@Override
	public String getFileName(String newFilename) {
		return dao.getFileName(newFilename);
	}
	
	@Override
	public boolean readCount(int seq) {
		return dao.readCount(seq);
	}
	
	@Override
	public boolean downCount(int seq) {
		return dao.downCount(seq);
	}
	
	@Override
	public PdsDto getDetail(int seq) {
		return dao.getDetail(seq);
	}
	
	@Override
	public boolean deletePds(int seq) {
		return dao.deletePds(seq);
	}
	
	@Override
	public boolean updatePds(PdsDto dto) {
		return dao.updatePds(dto);
	}
	

}
