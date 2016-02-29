package main.java.testName;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
public class testName {
	
	
	@RequestMapping(value="/loggedIn", method=RequestMethod.GET)
	public ModelAndView signIn(Model model, String userName, String password){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
	      System.out.println("name Is: "+name);
        return new ModelAndView("WEB-INF/views/userProfile.jsp");
	}

	@RequestMapping("/profile")
    public ModelAndView profile(Model model) {
		model.addAttribute("message", "Hello World!");
        
        return new ModelAndView("WEB-INF/views/userProfile.jsp");
    }
	
	@RequestMapping("/")
    public ModelAndView root(Model model) {
		model.addAttribute("message", "Hello World!");
        System.out.println("\n\n\n\n\n\n\n Got HERE \n\n\n\n\n\n!!!");
        return new ModelAndView("WEB-INF/views/root.jsp");
    }
	
	@RequestMapping("/signup")
    public ModelAndView signup(Model model) {
		model.addAttribute("message", "Hello World!");
        
        return new ModelAndView("WEB-INF/views/signup.jsp");
    }
	
	@RequestMapping("/jobs")
    public ModelAndView postJobs(Model model) {
		model.addAttribute("message", "Hello World!");
        
        return new ModelAndView("WEB-INF/views/postJobs.jsp");
    }

}
