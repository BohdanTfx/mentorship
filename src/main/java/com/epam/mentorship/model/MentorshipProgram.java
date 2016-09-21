package com.epam.mentorship.model;

import java.util.List;

public class MentorshipProgram extends BaseEntity<Long> {
	private String title;
	private List<User> participants;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<User> getParticipants() {
		return participants;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}
}
