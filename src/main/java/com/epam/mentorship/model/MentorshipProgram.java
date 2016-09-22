package com.epam.mentorship.model;

import java.util.List;

public class MentorshipProgram extends BaseEntity<Long> {
	private String title;
	private User head;
	private Technology technology;
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

	public User getHead() {
		return head;
	}

	public void setHead(User head) {
		this.head = head;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}
}
