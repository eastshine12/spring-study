package bit.com.a.poll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PollServiceImpl implements PollService {

	@Autowired
	PollDao dao;
	
	
	@Override
	public List<PollDto> getPollAllList(String id) {
		
		//모든 투표 목록을 가지고 온다.
		List<PollDto> list = dao.getPollAllList();
		
		//투표 참여했는지 확인 후 넘겨줄 목록 (한번만 참여 가능해야 하므로)
		List<PollDto> pList = new ArrayList<PollDto>();
		
		
		/* Voter 테이블에 기록이 있다면 해당 투표에 참여한 것 */
		for (PollDto poll : list) {
			int pollId = poll.getPollId();	// 투표글 번호를 꺼낸다.
			//투표했음 : 1, 투표안했음 : 2
			int count = dao.isVote(new Voter(pollId, 0, id));
			if (count == 1) {
				poll.setVote(true);
			} else {
				poll.setVote(false);
			}
			pList.add(poll);
		}
		
		return pList;
	}


	@Override
	public void makePoll(PollBean pBean) {
		
		// 투표 주제
		PollDto poll = new PollDto(pBean.getId(), pBean.getQuestion(), pBean.getsDate(), pBean.geteDate(), pBean.getItemCount(), 0);
		dao.makePoll(poll);
		
		//투표 보기들
		String answer[] = pBean.getPollNum();
		for (int i = 0; i < pBean.getItemCount(); i++) {
			PollSubDto pollSub = new PollSubDto();
			pollSub.setAnswer(answer[i]);
			dao.makePollSub(pollSub);
		}
	}


	@Override
	public PollDto getPoll(PollDto poll) {
		return dao.getPoll(poll);
	}


	@Override
	public List<PollSubDto> getPollSubList(PollDto poll) {
		return dao.getPollSubList(poll);
	}


	@Override
	public void polling(Voter voter) {
		
		dao.pollingVoter(voter);
		dao.pollingPoll(voter);
		dao.pollingSub(voter);
		
	}
	
	
	
	
	
}
