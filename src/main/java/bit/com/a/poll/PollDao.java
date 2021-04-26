package bit.com.a.poll;

import java.util.List;

public interface PollDao {
	
	List<PollDto> getPollAllList();
	
	int isVote(Voter voter);
	
	void makePoll(PollDto poll);
	
	void makePollSub(PollSubDto pollSub);
	
	PollDto getPoll(PollDto poll);
	List<PollSubDto> getPollSubList(PollDto poll);
	
}
