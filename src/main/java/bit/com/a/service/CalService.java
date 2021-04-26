package bit.com.a.service;

import java.util.List;

import bit.com.a.dao.CalendarDao;
import bit.com.a.dto.CalParam;
import bit.com.a.dto.CalendarDto;

public interface CalService {

	public List<CalendarDto> getCalList(CalParam param);
	
	public CalendarDto calDetail(int seq);
	
	public int calWrite(CalendarDto dto);
	
	public int calDelete(int seq);
	
	public int calUpdate(CalendarDto dto);
	
	public List<CalendarDto> getDayList(CalParam param);
	
}
