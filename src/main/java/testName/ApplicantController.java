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
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(String s: user.getBadges()){
			sb.append("\'"+s+"\',");
		}
		sb.replace(sb.length()-1, sb.length(),"" );
		sb.append("];");
		mav.addObject("badges",sb.toString());
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
		if(answer==null){
			return question();
		}
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Applicant){
			return new ModelAndView("reditect:503");
		}
		
		qdoa.answerQuestion(user,qdoa.getUserQuesition(user),answer);
		return question();
	}
}
