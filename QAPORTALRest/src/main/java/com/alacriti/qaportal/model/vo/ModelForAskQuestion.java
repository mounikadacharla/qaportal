package com.alacriti.qaportal.model.vo;

public class ModelForAskQuestion {
	public int sid_topic;
	public int sid_person;
	public String question;

	public ModelForAskQuestion() {

	}

	public ModelForAskQuestion(int sid_topic, int sid_person, String question) {
		super();
		this.sid_topic = sid_topic;
		this.sid_person = sid_person;
		this.question = question;
	}

	public int getSid_topic() {
		return sid_topic;
	}

	public void setSid_topic(int sid_topic) {
		this.sid_topic = sid_topic;
	}

	public int getSid_person() {
		return sid_person;
	}

	public void setSid_person(int sid_person) {
		this.sid_person = sid_person;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
