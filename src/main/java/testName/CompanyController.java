package main.java.testName;

import main.java.testName.alg.Algorithm;
import main.java.testName.jobs.Job;
import main.java.testName.jobs.JobDAO;
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
	private JobDAO jdao;
	
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
	
	@RequestMapping(value="/postJob",method=RequestMethod.POST)
	public ModelAndView postJobSubmit(String title, String desc, String address, String culscore, String ed, String exp){
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Company){
			return new ModelAndView("reditect:503");
		}
		
		jdao.addJob(user, new Job(title,desc,address,culscore,ed,exp));
		
		return new ModelAndView("redirect:/jobResults");
	}
	
	@RequestMapping(value="/jobResults",method=RequestMethod.GET)
	public ModelAndView jobResults(){
		User user=uls.getLogedInUser();
		if(user.getUserGroup()!=Group.Company){
			return new ModelAndView("reditect:503");
		}
		
		ModelAndView mav= new ModelAndView("WEB-INF/views/jobResults.jsp");
		mav.addObject("res", alg.getMatches(jdao.getJobsList(user)));
		return mav;
	}
}
