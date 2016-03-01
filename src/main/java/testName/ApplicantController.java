package main.java.testName;

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
		return new ModelAndView("WEB-INF/views/appProfile.jsp");
	}
	
	@RequestMapping(value="/cultureQuiz",method=RequestMethod.GET)
	public ModelAndView culterQuiz(){
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Applicant){
			return new ModelAndView("reditect:503");
		}
		return new ModelAndView("WEB-INF/views/cultureQuiz.jsp");
	}
	
	@RequestMapping(value="/techQuiz",method=RequestMethod.GET)
	public ModelAndView techQuiz(){
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Applicant){
			return new ModelAndView("reditect:503");
		}
		return new ModelAndView("WEB-INF/views/techQuiz.jsp");
	}
}
