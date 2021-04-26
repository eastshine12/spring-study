package bit.com.a.dao;

import java.util.List;

import bit.com.a.dto.MemberDto;

public interface MemberDao {
	
	public String idCheck(String id);
	
	public int addMember(MemberDto dto);
	
	public MemberDto login(MemberDto dto);

}
