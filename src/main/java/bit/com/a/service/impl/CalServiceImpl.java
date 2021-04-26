package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.CalendarDao;
import bit.com.a.dto.CalParam;
import bit.com.a.dto.CalendarDto;
import bit.com.a.service.CalService;

@Service
public class CalServiceImpl implements CalService {
	
	
	@Autowired
	CalendarDao calDao;

	@Override
	public List<CalendarDto> getCalList(CalParam param) {
		return calDao.getCalList(param);
	}
	
	@Override
	public CalendarDto calDetail(int seq) {
		return calDao.calDetail(seq);
	}
	
	@Override
	public int calWrite(CalendarDto dto) {
		return calDao.calWrite(dto);
	}
	
	@Override
	public int calDelete(int seq) {
		return calDao.calDelete(seq);
	}
	
	@Override
	public int calUpdate(CalendarDto dto) {
		return calDao.calUpdate(dto);
	}
	
	@Override
	public List<CalendarDto> getDayList(CalParam param) {
		return calDao.getDayList(param);
	}

}