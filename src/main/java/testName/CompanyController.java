package main.java.testName;

import main.java.testName.alg.Algorithm;
import main.java.testName.jobs.Job;
import main.java.testName.jobs.JobDAO;
import main.java.testName.jobs.QuestionAnswerPair;
import main.java.testName.questions.Question;
import main.java.testName.questions.RadialQuestion;
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
		
		ModelAndView mav =new ModelAndView("WEB-INF/views/coProfile.jsp");
		mav.addObject("userDetails", uls.getUserDetails(user));
		
		System.out.println(uls.getUserDetails(user));
		mav.addObject("email",user.getUsername());
		return mav;
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

    @RequestMapping(value="/createQuestions",method=RequestMethod.GET)
    public ModelAndView createQuestions(){
        User user=uls.getLogedInUser();
        if(user.getUserGroup()!=Group.Company){
            return new ModelAndView("reditect:503");
        }

        ModelAndView mav= new ModelAndView("WEB-INF/views/cquestions.jsp");
        return mav;
    }
    
    @RequestMapping(value="/createQuestions",method=RequestMethod.POST)
    public ModelAndView createQuestion(String question, String a1, String a2, String a3, String a4, String type){
        User user=uls.getLogedInUser();
        if(user.getUserGroup()!=Group.Company){
            return new ModelAndView("reditect:503");
        }
        
        Question q=null;
        if(a2==null){
        	q= new RadialQuestion(type.equals("tech"),question, a1);
        }else if (a3==null){
        	q= new RadialQuestion(type.equals("tech"),question, a1,a2);
        }else if (a4== null){
        	q= new RadialQuestion(type.equals("tech"),question, a1,a2,a3);
        }else{
        	q= new RadialQuestion(type.equals("tech"),question, a1,a2,a3,a4);
        }
        
        alg.addQuestion(new QuestionAnswerPair(q, a1));

        
        ModelAndView mav= new ModelAndView("WEB-INF/views/cquestions.jsp");
        return mav;
    }
}
