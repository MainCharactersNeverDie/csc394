package main.java.testName.questions;

import static main.java.testName.Group.Applicant;
import static main.java.testName.Group.Company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import main.java.testName.jobs.Job;
import main.java.testName.jobs.QuestionAnswerPair;
import main.java.testName.userService.User;
import main.java.testName.userService.UserDetails;
import main.java.testName.userService.UserLoginService;

import org.springframework.beans.factory.annotation.Autowired;


public class QuestionDAO {
	private static volatile ConcurrentHashMap<Long,QuestionAnswerPair> questions = new ConcurrentHashMap<>();
	private static volatile ConcurrentHashMap<User,Long> userIndex = new ConcurrentHashMap<>();
	private static volatile ConcurrentHashMap<UserQuestionPair,String> answers= new ConcurrentHashMap<>();

	public final static int NUMBER_OF_QUESTIONS=10;
	private List<QuestionAnswerPair> allQuestions=new ArrayList<>();;
	
	{
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"What is the ideal size of the company that you would want to work for?","A few dedicated people in a garage","A giant corporation with thousands of staff worldwide","An office full of people in one location"),"1"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"When you go to work, what would you prefer to wear?","Super Casual","Business Casual","Business Formal","No preference"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"Whenever you are given a task, there are always resources available to you in the form of your co-workers. How would you utilize those resources?","Work on the task alone","Form a task group to tackle the problem","Use your co-workers on a need basis"),"2"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"What are your ideal work hours?","Nine to five, like the song","Flexibility in when I work is important, as long as I get my 8 hours in","I work all the time, nights, weekends, doesn't matter"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"Is the organization of a company important to you, and if so, how much?","I have no interest in heirarchy","Organization is the key to success","I'm just a cog in the wheel"),"2"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"Are you a people person?","Yes","No","Stop asking me questions!"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"Would you be comfortable reaching out to a client to help them solve their problems, even if your position doesn't necessarily require you to do so?","Yes, I have no problem calling a client","I would prefer to give the fix instructions to Customer Support so they can make contact, but I would if it was necessary","I would refuse to make that call, it wasn't in my original deal"),"2"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"How would you fare in an office cubicle farm?","I would wither and die","I don't have a preference","I like cubicles, it’s a place to keep my stapler"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),false,"When do you feel the most productive?","First thing in the morning, when I have direction","Afternoons after all the meetings are done","I find I'm most productive at night, from home."),"2"));

	}
	//Radial Question answers are strings containing the 0-based index of the right answer.
	{
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"What programming language are you most comfortable with?","Java","Python","XCode"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"How many mobile apps have you published for either iOS or Android?","0 - 10","10-100","100+"),"2"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"What is the most efficient search algorithm to use when your data is unsorted?","Quick Sort","Insertion Sort","Bubble Sort"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"Could you code a website that matches potential employees to companies and their job postings?","Yes","No","Deja Vu"),"2"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"From which school did you get your Computer Science degree?","DePaul","DeVry","Other"),"0"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"How many licks does it take to get to the Tootsie Roll center of a Tootsie Pop?","3","Between 252 and 364","What does this have to do with anything?"),"1"));
		allQuestions.add(new QuestionAnswerPair(new RadialQuestion(Job.getNullJob(),true,"What is your preferred operating system?","Mac","Linux","Windows"),"1"));
	}	
	
	@Autowired
	private UserLoginService uls;
	
	
	private static List<User> fakeUsers= new LinkedList<User>();
	
	static{
		finalizeUser(new User(Applicant,"CatherineFloyd29577@gmail.com","password1"), new UserDetails("Catherine Floyd", 200427606, "835246 Rooz Way Uvumejuzu, DC 96911", 966070811));
		finalizeUser(new User(Applicant,"IsabelGrant83919@gmail.com","password1"), new UserDetails("Isabel Grant", 497146081, "601288 Zaup Point Fuhfazid, MA 90113", 720307579));
		finalizeUser(new User(Applicant,"FloydBenson58583@gmail.com","password1"), new UserDetails("Floyd Benson", 227129422, "693429 Guzho Mill Cimcadoh, OR 71974", 627270902));
		finalizeUser(new User(Applicant,"GabrielTurner06856@gmail.com","password1"), new UserDetails("Gabriel Turner", 991801871, "714833 Tiche Turnpike Fahkinsid, WV 48199", 766989673));
		finalizeUser(new User(Applicant,"NelleMcGuire93252@gmail.com","password1"), new UserDetails("Nelle McGuire", 289907962, "261917 Siges Parkway Fusekaj, MT 34301", 805341018));
		finalizeUser(new User(Applicant,"WayneDaniels78028@gmail.com","password1"), new UserDetails("Wayne Daniels", 478958924, "762153 Hapku Glen Hetivses, TN 07383", 618961925));
		finalizeUser(new User(Applicant,"SallyCrawford74210@gmail.com","password1"), new UserDetails("Sally Crawford", 512373950, "294524 Ohli Mill Dudogut, NV 39774", 549851424));
		finalizeUser(new User(Applicant,"GussieBall70982@gmail.com","password1"), new UserDetails("Gussie Ball", 481642864, "323561 Voki Mill Awehemo, DE 04737", 605416675));
		finalizeUser(new User(Applicant,"CeliaJones19517@gmail.com","password1"), new UserDetails("Celia Jones", 151245069, "944328 Ediri Turnpike Ephiol, TN 01686", 422346264));
		finalizeUser(new User(Applicant,"KeithFarmer56960@gmail.com","password1"), new UserDetails("Keith Farmer", 348605926, "256204 Ofkid Drive Pebocig, OK 50184", 999537391));
		finalizeUser(new User(Applicant,"CatherineSalazar41682@gmail.com","password1"), new UserDetails("Catherine Salazar", 681393645, "600149 Zikut Boulevard Meegaf, LA 11082", 260020552));
		finalizeUser(new User(Applicant,"WinniePope02863@gmail.com","password1"), new UserDetails("Winnie Pope", 663769692, "565931 Nihguj Terrace Vudtufi, NM 24493", 531871478));
		finalizeUser(new User(Applicant,"DonaldRussell42320@gmail.com","password1"), new UserDetails("Donald Russell", 931834932, "180194 Webok Avenue Kanlezdo, SC 40367", 164976528));
		finalizeUser(new User(Applicant,"MariaBlake54619@gmail.com","password1"), new UserDetails("Maria Blake", 459286165, "171474 Seru Grove Huzkeha, MI 80977", 972896912));
		finalizeUser(new User(Applicant,"JesusJohnson83846@gmail.com","password1"), new UserDetails("Jesus Johnson", 546013087, "941794 Jeib Loop Ucpulwu, ME 64922", 894003381));
		finalizeUser(new User(Applicant,"VernonGibbs75476@gmail.com","password1"), new UserDetails("Vernon Gibbs", 844842030, "578440 Suije Way Awiseneca, NV 88170", 881586324));
		finalizeUser(new User(Applicant,"ErnestOsborne92416@gmail.com","password1"), new UserDetails("Ernest Osborne", 961062861, "264611 Nahju Heights Ceicbag, NM 15232", 373721818));
		finalizeUser(new User(Applicant,"JeremiahWaters93077@gmail.com","password1"), new UserDetails("Jeremiah Waters", 271353472, "552643 Jenaz Extension Gafocur, VA 83371", 126431979));
		finalizeUser(new User(Company,"hr@Zundax.com","password1"), new UserDetails("Zundax", 522773380, "861275 Virwic Terrace Lawogri, NJ 56132", 280108564));
		finalizeUser(new User(Company,"information@Quotelane.com","password1"), new UserDetails("Quotelane", 855484823, "584889 Lojpam Park Inaretpe, WA 17183", 340654798));
		finalizeUser(new User(Company,"humanresource@Singlefan.com","password1"), new UserDetails("Singlefan", 773325413, "5655 Dopac Park Tadfamkus, IN 24684", 180478589));
		finalizeUser(new User(Company,"info@Flexzone.com","password1"), new UserDetails("Flexzone", 803315933, "446 Noboc Point Vaktupzi, WI 84054", 190493872));
		finalizeUser(new User(Company,"hr@Quotax.com","password1"), new UserDetails("Quotax", 916890035, "37146 Cewha Highway Pamedem, WV 25656", 930981326));
		finalizeUser(new User(Company,"info@Newtax.com","password1"), new UserDetails("Newtax", 423229849, "93 Obtor Circle Jubremi, ME 88171", 503402302));
		finalizeUser(new User(Company,"hr@Vilaunadox.com","password1"), new UserDetails("Vilaunadox", 875522731, "42377 Kagmom Heights Tocbahu, CA 10299", 914837289));
		finalizeUser(new User(Company,"humanresource@Daltdom.com","password1"), new UserDetails("Daltdom", 918415453, "9048 Ufazu Center Fobwois, GA 13780", 998882653));
		finalizeUser(new User(Company,"humanresource@Carecode.com","password1"), new UserDetails("Carecode", 652521901, "6495 Rezsog Pass Cejzuho, MO 77995", 390446760));
		finalizeUser(new User(Company,"info@Flexunalax.com","password1"), new UserDetails("Flexunalax", 457453689, "4692 Zopfuv Court Lugomam, NH 69814", 615450164));
	}
	
	//DON't Touch this for the love of god.
	public static void finalizeUser(User u, UserDetails ud){
		fakeUsers.add(u);
	}
	
	public synchronized void randomizeAnswers(QuestionAnswerPair qap) {
		transferQuestions();
		for(User u:fakeUsers){
			int rando=(int) (NUMBER_OF_QUESTIONS*Math.random());
			for(int i=0; i<rando; i++){
				answerQuestion(u,qap,""+(int)(4*Math.random()));
			}
		}
	}
	
	//Please don't touch any of this
	
	private static volatile long numOfQs=0L;
	
	private static volatile boolean done=false;
	@PostConstruct
	public synchronized void transferQuestions() {
		if (!done) {
			done = true;
			System.out.println("Adding Questions");
			for (QuestionAnswerPair q : allQuestions) {
				questions.put(numOfQs++, q);
			}
		}
	}
	////////////////ABOVE IS OFF LIMITS TO ANYONE NOT WANTING TO BREAK EVERYTHING
	


	public QuestionAnswerPair getUserQuesition(User u){
		if(!userIndex.containsKey(u)){
			userIndex.put(u,0L);
			System.out.println("User Questions");
		}

		
		return questions.get(userIndex.get(u));
	}
	
	public static void answerQuestion(User u, QuestionAnswerPair q, String answer){
		if(userIndex.get(u)==null){
			userIndex.put(u,0L);
		}
		userIndex.put(u,userIndex.get(u)+1);
		answers.put(new UserQuestionPair(u,q.getQuestion()), answer);
		
		System.out.println(q.getAnswer()+" "+answer);
		if(q.getQuestion().isTechQuestion()){
			u.answeredTechQuestion(q.getQuestion().getJob(),answer.equals(q.getAnswer()));
		}else{
			u.answeredCulQuestion(q.getQuestion().getJob(),answer.equals(q.getAnswer()));
		}
	}
	
	public String getAnswer(User u,Question q){
		String res= answers.get(new UserQuestionPair(u,q));
		return (res!=null)?res:"";
	}
	
	
	public void addQuestion(QuestionAnswerPair qap){
		allQuestions.add(qap);
		questions.put(numOfQs++, qap);
		randomizeAnswers(qap);
	}
}
