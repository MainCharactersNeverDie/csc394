package main.java.testName.jobs;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import main.java.testName.userService.User;

public class JobDAO {
	private static volatile ConcurrentHashMap<User,List<Job>> jobs = new ConcurrentHashMap<>();
	
	public void addJob(User u, Job j){
		System.out.println(jobs);
		if(!jobs.containsKey(u)){
			jobs.put(u,new LinkedList<Job>());
		}
		jobs.get(u).add(j);
		System.out.println("posted job"+ j.getTitle());
	}
	
	public List<Job> getJobsList(User u){
		System.out.println(jobs);
		if(!jobs.containsKey(u)){
			jobs.put(u,new LinkedList<Job>());
		}
		return jobs.get(u);
	}
}
