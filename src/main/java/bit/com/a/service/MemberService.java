package bit.com.a.service;

import java.util.List;

import bit.com.a.dto.MemberDto;

public interface MemberService {
	
	public String idCheck(String id);

	public int addMember(MemberDto dto);
	
	public MemberDto login(MemberDto dto);
}
