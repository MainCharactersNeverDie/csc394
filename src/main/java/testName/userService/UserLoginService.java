package main.java.testName.userService;

import static main.java.testName.Group.Applicant;
import static main.java.testName.Group.Company;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import main.java.testName.Group;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserLoginService implements UserDetailsService{

	private static volatile ConcurrentHashMap<String, User> users = new ConcurrentHashMap<>();
	private static volatile ConcurrentHashMap<User, UserDetails> usersDetails = new ConcurrentHashMap<>();
	
	static {
		finalizeUser(new User(Applicant,"app@app.app","apppass"), new UserDetails("app",555,"test",444));
		finalizeUser(new User(Company,"co@co.co","copass"), new UserDetails("co",565,"test",432));
		// Added Users
		finalizeUser(new User(Applicant,"CatherineFloyd29577@gmail.com","password1"), new UserDetails("Catherine Floyd", 200427606, "835246 Rooz Way UvumejuzuDC 96911", "9663070811"));
		finalizeUser(new User(Applicant,"IsabelGrant83919@gmail.com","password1"), new UserDetails("Isabel Grant", "497146081, "601288 Zaup Point FuhfazidMA 90113", "7203075579"));
		finalizeUser(new User(Applicant,"FloydBenson58583@gmail.com","password1"), new UserDetails("Floyd Benson", "227129422, "693429 Guzho Mill CimcadohOR 71974", "6272790902"));
		finalizeUser(new User(Applicant,"GabrielTurner06856@gmail.com","password1"), new UserDetails("Gabriel Turner", "991801871, "714833 Tiche Turnpike FahkinsidWV 48199", "7166989673"));
		finalizeUser(new User(Applicant,"NelleMcGuire93252@gmail.com","password1"), new UserDetails("Nelle McGuire", "289907962, "261917 Siges Parkway FusekajMT 34301", "8053491018"));
		finalizeUser(new User(Applicant,"WayneDaniels78028@gmail.com","password1"), new UserDetails("Wayne Daniels", "478958924, "762153 Hapku Glen HetivsesTN 07383", "6189611925"));
		finalizeUser(new User(Applicant,"SallyCrawford74210@gmail.com","password1"), new UserDetails("Sally Crawford", "512373950, "294524 Ohli Mill DudogutNV 39774", "5498531424"));
		finalizeUser(new User(Applicant,"GussieBall70982@gmail.com","password1"), new UserDetails("Gussie Ball", "481642864, "323561 Voki Mill AwehemoDE 04737", "6054166735"));
		finalizeUser(new User(Applicant,"CeliaJones19517@gmail.com","password1"), new UserDetails("Celia Jones", "151245069, "944328 Ediri Turnpike EphiolTN 01686", "4229346264"));
		finalizeUser(new User(Applicant,"KeithFarmer56960@gmail.com","password1"), new UserDetails("Keith Farmer", "348605926, "256204 Ofkid Drive PebocigOK 50184", "9999537391"));
		finalizeUser(new User(Applicant,"CatherineSalazar41682@gmail.com","password1"), new UserDetails("Catherine Salazar", 681393645, "600149 Zikut Boulevard MeegafLA 11082", 2600280552));
		finalizeUser(new User(Applicant,"WinniePope02863@gmail.com","password1"), new UserDetails("Winnie Pope", 663769692, "565931 Nihguj Terrace VudtufiNM 24493", 5318714728));
		finalizeUser(new User(Applicant,"DonaldRussell42320@gmail.com","password1"), new UserDetails("Donald Russell", 931834932, "180194 Webok Avenue KanlezdoSC 40367", 1641976528));
		finalizeUser(new User(Applicant,"MariaBlake54619@gmail.com","password1"), new UserDetails("Maria Blake", 459286165, "171474 Seru Grove HuzkehaMI 80977", 9728969132));
		finalizeUser(new User(Applicant,"JesusJohnson83846@gmail.com","password1"), new UserDetails("Jesus Johnson", 546013087, "941794 Jeib Loop UcpulwuME 64922", 8940003381));
		finalizeUser(new User(Applicant,"VernonGibbs75476@gmail.com","password1"), new UserDetails("Vernon Gibbs", 844842030, "578440 Suije Way AwisenecaNV 88170", 8818586324));
		finalizeUser(new User(Applicant,"ErnestOsborne92416@gmail.com","password1"), new UserDetails("Ernest Osborne", 961062861, "264611 Nahju Heights CeicbagNM 15232", 3738721818));
		finalizeUser(new User(Applicant,"JeremiahWaters93077@gmail.com","password1"), new UserDetails("Jeremiah Waters", 271353472, "552643 Jenaz Extension GafocurVA 83371", 1286431979));
		finalizeUser(new User(Company,"hr@Zundax.com","password1"), new UserDetails("Zundax", 522773380, "861275 Virwic Terrace LawogriNJ 56132", 2801085664));
		finalizeUser(new User(Company,"information@Quotelane.com","password1"), new UserDetails("Quotelane", 855484823, "584889 Lojpam Park InaretpeWA 17183", 3406547198));
		finalizeUser(new User(Company,"humanresource@Singlefan.com","password1"), new UserDetails("Singlefan", 773325413, "5655 Dopac Park TadfamkusIN 24684", 1802478589));
		finalizeUser(new User(Company,"info@Flexzone.com","password1"), new UserDetails("Flexzone", 803315933, "446 Noboc Point VaktupziWI 84054", 1904938572));
		finalizeUser(new User(Company,"hr@Quotax.com","password1"), new UserDetails("Quotax", 916890035, "37146 Cewha Highway PamedemWV 25656", 9309813126));
		finalizeUser(new User(Company,"info@Newtax.com","password1"), new UserDetails("Newtax", 423229849, "93 Obtor Circle JubremiME 88171", 5034023102));
		finalizeUser(new User(Company,"hr@Vilaunadox.com","password1"), new UserDetails("Vilaunadox", 875522731, "42377 Kagmom Heights TocbahuCA 10299", 9148737289));
		finalizeUser(new User(Company,"humanresource@Daltdom.com","password1"), new UserDetails("Daltdom", 918415453, "9048 Ufazu Center FobwoisGA 13780", 9987882653));
		finalizeUser(new User(Company,"humanresource@Carecode.com","password1"), new UserDetails("Carecode", 652521901, "6495 Rezsog Pass CejzuhoMO 77995", 3950446760));
		finalizeUser(new User(Company,"info@Flexunalax.com","password1"), new UserDetails("Flexunalax", 457453689, "4692 Zopfuv Court LugomamNH 69814", 6154560164));
		finalizeUser(new User(Company,"hr@Zaptrax.com","password1"), new UserDetails("Zaptrax", 133287438, "7558 Fazba Pass RobbaheNY 69457", 2348345467));
		finalizeUser(new User(Company,"information@Transdexon.com","password1"), new UserDetails("Transdexon", 921378800, "863 Ladah View KedkizseMI 84196", 6008022991));
		finalizeUser(new User(Company,"info@Zaamice.com","password1"), new UserDetails("Zaamice", 956349069, "46912 Riik Pike DegawePA 72969", 9508893456));
		finalizeUser(new User(Company,"information@techfind.com","password1"), new UserDetails("techfind", 828450339, "39724 Wiwos Grove AfizajuPA 96042", 5327230946));
		finalizeUser(new User(Company,"information@Vivafax.com","password1"), new UserDetails("Vivafax", 492954900, "10798 Wurwa Path FitetawilDE 43067", 8855843125));
		finalizeUser(new User(Company,"hr@Toughron.com","password1"), new UserDetails("Toughron", 183434971, "316 Tuszin Point LivtuwoSD 47750", 3999902883));
		finalizeUser(new User(Company,"humanresource@Itquote.com","password1"), new UserDetails("Itquote", 333750460, "53 Tacak Loop WowikbocVT 74961", 6168350097));
		finalizeUser(new User(Company,"hr@Jobjob.com","password1"), new UserDetails("Jobjob", 174933911, "652 Ziddus Path RofopezID 92663", 4132307333));
		finalizeUser(new User(Company,"humanresource@Vaiatechi.com","password1"), new UserDetails("Vaiatechi", 563705489, "20332 Jeguv Junction LemtoabNJ 48226", 9285165604));
		finalizeUser(new User(Company,"hr@Statzim.com","password1"), new UserDetails("Statzim", 693841598, "793 Gefi Place CibufmuIL 28861", 5322259590));
	}
	
	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		if(!users.containsKey(username)){
			throw new UsernameNotFoundException(username);
		}
		User user=users.get(username);
		addUserToSecurityContext(user);
		return user;
	}
	
	private void addUserToSecurityContext(User user) {

	}
	
	public User getLogedInUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth==null){
			return null;
		}
	    String name = auth.getName();
	    return users.get(name);
	}
	
	public boolean nameFree(String username){
		return !users.containsKey(username);
	}
	
	public static void finalizeUser(User user, UserDetails userDs){
		users.put(user.getUsername(),user);
		usersDetails.put(user,userDs);
	}
	
	public List<User> applicantlist(){
		List<User> res= new LinkedList<User>();
		for(User u:users.values()){
			if(u.getUserGroup()==Group.Applicant){
				res.add(u);
			}
		}
		return res;
	}
	
	public UserDetails getUserDetails(User u){
		return usersDetails.get(u);
	}
}
