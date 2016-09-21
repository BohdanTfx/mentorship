package com.epam.mentorship.util;

import org.modelmapper.ModelMapper;

import com.epam.mentorship.model.User;
import com.epam.mentorship.model.dto.UserDto;

public class DtoEntityConverter {
	private static ModelMapper mapper = new ModelMapper();
	
	public static User convert(UserDto userDto) {
		return mapper.map(userDto, User.class);
	}
}
