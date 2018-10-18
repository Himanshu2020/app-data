package musipo.controllerblock;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import musipo.modelobj.Feedback;
import musipo.serviceblock.FeedbackService;

@Controller
public class FeedBackController {
	@Autowired
	FeedbackService fbs;

	@RequestMapping("/feedbackblock")
	@ResponseBody
	public List<Feedback> getfeedback() {

		return fbs.getFeedback();

	}

}
