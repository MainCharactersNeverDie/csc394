package main.java.testName;

import main.java.testName.jobs.QuestionAnswerPair;
import main.java.testName.questions.QuestionDAO;
import main.java.testName.userService.User;
import main.java.testName.userService.UserLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicantController {
	@Autowired
	private QuestionDAO qdoa;
	@Autowired
	private UserLoginService uls;
	
	public ModelAndView signIn(){
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Applicant){
			return new ModelAndView("reditect:503");
		}
	    return new ModelAndView("redirect:profile");
	}

	public ModelAndView profile() {
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Applicant){
			return new ModelAndView("reditect:503");
		}
		ModelAndView mav =new ModelAndView("WEB-INF/views/appProfile.jsp");
		mav.addObject("userDetails", uls.getUserDetails(user));
		mav.addObject("email",user.getUsername());
		mav.addObject("badges",user.getBadges());
		return mav;
	}
	
	@RequestMapping(value="/question",method=RequestMethod.GET)
	public ModelAndView question(){
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Applicant){
			return new ModelAndView("reditect:503");
		}
		QuestionAnswerPair q=qdoa.getUserQuesition(user);
		if(q==null){
			return new ModelAndView("WEB-INF/views/outOfQuestions.jsp");
		}
		ModelAndView mav= new ModelAndView(q.getQuestion().getQuestionStyle());
		mav.addObject("answerList",q.getQuestion().getAnswerList());
		return mav;
	}
	
	@RequestMapping(value="/question",method=RequestMethod.POST)
	public ModelAndView questionAnswered(String answer){
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Applicant){
			return new ModelAndView("reditect:503");
		}
		
		qdoa.answerQuestion(user,qdoa.getUserQuesition(user),answer);
		return question();
	}
}
