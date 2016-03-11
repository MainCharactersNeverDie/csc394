package main.java.testName.questions;

import java.util.List;

import main.java.testName.jobs.Job;

public interface Question {
	String getQuestionStyle();
	List<String> getAnswerList();
	boolean isTechQuestion();
	Job getJob();
}
