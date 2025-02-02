package com.estuate.Test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estuate.Test.dto.Users;
import com.estuate.Test.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping
	public Users save(@RequestBody Users user)
	{
		return service.createUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getRecommendations(@PathVariable int id)
	{
		List<String> potentialUsers = service.getRecommendations(id) ;
		return new ResponseEntity<>(potentialUsers, HttpStatus.OK);
	}
	
}
