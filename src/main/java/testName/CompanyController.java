package main.java.testName;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CompanyController {
	public ModelAndView signIn(){
		return new ModelAndView("redirect:profile");
	}

	public ModelAndView profile() {
		return new ModelAndView("WEB-INF/views/coProfile.jsp");
	}
	
	@RequestMapping(value="/postJob",method=RequestMethod.GET)
	public ModelAndView postJob(){
		return new ModelAndView("WEB-INF/views/postJob.jsp");
	}
	
	@RequestMapping(value="/jobResults",method=RequestMethod.GET)
	public ModelAndView jobResults(){
		return new ModelAndView("WEB-INF/views/jobResults.jsp");
	}
}
