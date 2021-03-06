package com.epam.mentorship.dao.jpa;

import org.springframework.stereotype.Repository;

import com.epam.mentorship.dao.MentorshipProgramDao;
import com.epam.mentorship.model.MentorshipProgram;

@Repository
public class MentorshipProgramJpaDao extends GenericJpaDao<MentorshipProgram, Long> implements MentorshipProgramDao {

}
