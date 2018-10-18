package musipo.serviceblock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import musipo.daoblock.FeedBackDAO;
import musipo.modelobj.Feedback;

@Service
public class FeedbackService {
	@Autowired
	FeedBackDAO fbd;

	public List<Feedback> getFeedback() {
		return fbd.getAllFeedback();

	}

}
