package bit.com.a.poll;

import java.util.List;

public interface PollService {
	
	List<PollDto> getPollAllList(String id);	//id값을 받는다.
	
	void makePoll(PollBean pBean);
	
	PollDto getPoll(PollDto poll);
	List<PollSubDto> getPollSubList(PollDto poll);
	
	void polling(Voter voter);

}
