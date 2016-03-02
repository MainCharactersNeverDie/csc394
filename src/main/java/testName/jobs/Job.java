package main.java.testName.jobs;

public class Job {
	private String title;
	private String discription;
	private String location;
	private String cultureScoreNeeded;
	private String edLevel;
	private String exLevel;
	
	public Job(String titleIn, String discriptionIn, String locationIn,
			String cultureScoreNeededIn, String edLevelIn, String exLevelIn) {
		title = titleIn;
		discription = discriptionIn;
		location = locationIn;
		cultureScoreNeeded = cultureScoreNeededIn;
		edLevel = edLevelIn;
		exLevel = exLevelIn;
	}

	public String getTitle() {
		return title;
	}

}
