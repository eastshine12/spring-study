package bit.com.a.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import bit.com.a.dto.BbsDto;
import bit.com.a.dto.BbsParam;

public interface BbsDao {
	
	List<BbsDto> getBbsList();
	
	public List<BbsDto> getBbsPagingList(BbsParam bbsParam);
	
	public int getAllBbs(BbsParam bbsParam);
	
	public int writeBbs(BbsDto dto);
	
	public BbsDto getDetail(int seq);
	
	public boolean delete(int seq);
	
	public boolean update(BbsDto dto);
	
	public boolean answerUpdate(int seq);
	
	public boolean answerInsert(BbsDto dto);

}
