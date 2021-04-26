package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.PdsDto;

public interface PdsDao {
	
	List<PdsDto> getPdsList();
	
	boolean uploadPds(PdsDto dto);
	
	public String getFileName(String newFilename);
	
	public boolean readCount(int seq);
	
	public boolean downCount(int seq);
	
	public PdsDto getDetail(int seq);
	
	public boolean deletePds(int seq);	
	
	public boolean updatePds(PdsDto dto);
	
}
