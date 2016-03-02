package main.java.testName;

import main.java.testName.alg.Algorithm;
import main.java.testName.userService.User;
import main.java.testName.userService.UserLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyController {
	@Autowired
	private UserLoginService uls;
	
	@Autowired
	private Algorithm alg;
	
	public ModelAndView signIn(){
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Company){
			return new ModelAndView("reditect:503");
		}
		return new ModelAndView("redirect:profile");
	}

	public ModelAndView profile() {
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Company){
			return new ModelAndView("reditect:503");
		}
		return new ModelAndView("WEB-INF/views/coProfile.jsp");
	}
	
	@RequestMapping(value="/postJob",method=RequestMethod.GET)
	public ModelAndView postJob(){
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Company){
			return new ModelAndView("reditect:503");
		}
		return new ModelAndView("WEB-INF/views/postJob.jsp");
	}
	
	@RequestMapping(value="/jobResults",method=RequestMethod.GET)
	public ModelAndView jobResults(){
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Company){
			return new ModelAndView("reditect:503");
		}
		
		ModelAndView mav= new ModelAndView("WEB-INF/views/jobResults.jsp");
		mav.addObject("res", alg.getMatches());
		return mav;
	}
}
