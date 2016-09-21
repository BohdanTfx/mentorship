package com.epam.mentorship.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentorship.dao.MentorshipProgramDao;
import com.epam.mentorship.model.MentorshipProgram;

@Service
public class MentorshipProgramServiceImpl {
	@Autowired
	private MentorshipProgramDao mentorshipProgramDao;

	public MentorshipProgram save(MentorshipProgram entity) {
		return mentorshipProgramDao.save(entity);
	}

	public MentorshipProgram update(MentorshipProgram entity) {
		return mentorshipProgramDao.update(entity);
	}

	public void delete(Long id) {
		mentorshipProgramDao.delete(id);
	}

	public MentorshipProgram findById(Long id) {
		return mentorshipProgramDao.getById(id);
	}

	public List<MentorshipProgram> findMentorshipPrograms() {
		return mentorshipProgramDao.getAll();
	}
}
