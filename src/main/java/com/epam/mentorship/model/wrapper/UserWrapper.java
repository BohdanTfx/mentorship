package com.epam.mentorship.model.wrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.epam.mentorship.model.User;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class UserWrapper {
	private List<User> users;

	public UserWrapper() {
	}

	public UserWrapper(List<User> users) {
		this.users = users;
	}

	@XmlElement(name = "user")
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
