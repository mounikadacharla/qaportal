package com.alacriti.qaportal.model.vo;

public class EditAnswerModel {
	public int sid_answer;
	public String answer;

	public EditAnswerModel() {

	}

	public EditAnswerModel(int sid_answer, String answer) {
		super();
		this.sid_answer = sid_answer;
		this.answer = answer;
	}

	public int getSid_answer() {
		return sid_answer;
	}

	public void setSid_answer(int sid_answer) {
		this.sid_answer = sid_answer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
