package com.epam.mentorship.controller;

import static com.epam.mentorship.util.DtoEntityConverter.convert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentorship.model.User;
import com.epam.mentorship.model.dto.UserDto;
import com.epam.mentorship.service.UserService;

@Controller
@RequestMapping(path = "/api/users", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE })
public class UserController {
	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
		User entity = convert(userDto);
		return new ResponseEntity<User>(userService.save(entity), HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
		User entity = userService.findById(id);
		return new ResponseEntity<User>(userService.update(entity), HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findById(@PathVariable Long id) {
		return new ResponseEntity<User>(userService.findById(id), HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}

	@RequestMapping
	public ResponseEntity<List<User>> findUsers() {
		return new ResponseEntity<List<User>>(userService.findUsers(), HttpStatus.OK);
	}
}