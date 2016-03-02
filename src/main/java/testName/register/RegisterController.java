package main.java.testName.register;

import javax.mail.MessagingException;

import main.java.testName.Group;
import main.java.testName.userService.User;
import main.java.testName.userService.UserLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	@Autowired
	private UserLoginService uls;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView profile(String person, String company, String username, String password) throws MessagingException{
		if(!uls.nameFree(username)){
			return new ModelAndView("redirect:/register?error=username_taken");
		}
		
		System.out.println("username: "+username+ "password: "+ password);
		
		User user = new User((person.equals("on")?Group.Applicant:Group.Company),username,password);
		
		System.out.println("created:  username: "+user.getUsername()+ " password: "+ user.getPassword());
		
		ServletRequestAttributes atter = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		atter.setAttribute("User", user, atter.SCOPE_SESSION);
		
		if(person.equals("on")){
			return new ModelAndView("WEB-INF/views/appSignup.jsp");
		}
		return new ModelAndView("WEB-INF/views/coSignup.jsp");
		
		
		/*
		//future email verification template, need SMTP server
		
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("jobscam.ru");
		
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(j_username);
		helper.setText("To confirm your account go to this adress:");
		
		sender.send(message);
		return null;
		*/
		
		
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView profile() throws MessagingException{
		return new ModelAndView("WEB-INF/views/register.jsp");
	}
	
	@RequestMapping(value="/registerFinalize", method=RequestMethod.POST)
	public ModelAndView createUser(String name, int ssn, String address, int number){
		ServletRequestAttributes atter = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		User user=(User)atter.getAttribute("User", atter.SCOPE_SESSION);
		
		uls.finalizeUser(user);
		
		System.out.println("Finalized:  username: "+user.getUsername()+ " password: "+ user.getPassword());
		return new ModelAndView("redirect:/");
		
	}
}
