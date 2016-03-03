package main.java.testName;

import main.java.testName.userService.User;
import main.java.testName.userService.UserLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	private UserLoginService userLoginService;
	@Autowired
	private ApplicantController applicantController;
	@Autowired
	private CompanyController companyController;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView signIn(Model model, String userName, String password){
		User user= userLoginService.getLogedInUser();
		if(user==null){
			System.out.println("User was null in main controller root");
			return new ModelAndView("WEB-INF/views/root.jsp");
		}
		if (user.getUserGroup() == Group.Applicant) {
			return applicantController.signIn();
		} else {
			return companyController.signIn();
		}
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public ModelAndView profile(){
		User user= userLoginService.getLogedInUser();
		if(user==null){
			return new ModelAndView("redirect:/");
		}
		if (user.getUserGroup() == Group.Applicant) {
			return applicantController.profile();
		} else {
			return companyController.profile();
		}
	}
	
	
}
