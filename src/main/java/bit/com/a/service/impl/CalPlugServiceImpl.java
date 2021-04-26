package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.CalendarPlugDao;
import bit.com.a.dto.CalendarPlugDto;
import bit.com.a.service.CalPlugService;

@Service
public class CalPlugServiceImpl implements CalPlugService {
	
	@Autowired
	CalendarPlugDao dao;
	
	@Override
	public List<CalendarPlugDto> getCalendarPlugList(CalendarPlugDto dto){
		return dao.getCalendarPlugList(dto);
	}
	

}
