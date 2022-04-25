package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Vo.Booking;
import com.example.demo.Vo.Movie;
import com.example.demo.Vo.ResponseTemplateVo;
//import com.cg.multiplexbookingsystem.entity.Booking;
//import com.cg.multiplexbookingsystem.entity.Movie;
//import com.cg.multiplexbookingsystem.entity.Show;
//import com.example.demo.model.*;
import com.example.demo.exceptions.BookingAlreadyExistException;
import com.example.demo.exceptions.BookingDetailNotFoundException;
import com.example.demo.exceptions.CapacityExceededException;
import com.example.demo.exceptions.HallNotFoundException;
import com.example.demo.exceptions.LessSeatsAvailableException;
import com.example.demo.exceptions.MovieNotFoundException;
import com.example.demo.exceptions.SeatTypeNotFoundException;
import com.example.demo.exceptions.ShowNotFoundException;
import com.example.demo.exceptions.UserAlreadyExistException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.exceptions.WrongCredentialsException;
//import com.example.demo.model.Booking;
//import com.example.demo.model.Movie;
//import com.example.demo.model.Show;
import com.example.demo.model.User;
//import com.cg.multiplexbookingsystem.repository.HallRepository;
//import com.cg.multiplexbookingsystem.repository.MovieRepository;
//import com.cg.multiplexbookingsystem.repository.SeatTypeRepository;
//import com.cg.multiplexbookingsystem.repository.ShowRepository;
import com.example.demo.service.UserService;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	 UserService userService;
	
	@Autowired
	RestTemplate restTemplate;
	@PostMapping("/addUserDetails")
	public User addUserDetails(@RequestBody User user) throws UserAlreadyExistException {
		return userService.addUserDetails(user);
	}
	
	@PostMapping("/userLogin/{emailid}/{password}")
	public String loginUser(@PathVariable String emailid, @PathVariable String password) throws WrongCredentialsException{
		String tempEmailId = emailid;
		String tempPass = password;

		User userObj = null;
		if (tempEmailId != null && tempPass != null) {
			userObj = userService.fetchUserByEmailIdAndPassword(emailid, password);
		}

		if (userObj == null) {
			throw new WrongCredentialsException("WrongCredentials");
		}
		return "Login Successfull";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/showUserDetails/{userid}")
	public User showUserDetails(@PathVariable("userid") Long userid) throws UserNotFoundException {
		return userService.showUserDetails(userid);
	}
	
	
	
	@PutMapping("/updateUserDetails")
	public User updateUserDetails(@RequestBody User user) throws UserNotFoundException {
		return userService.updateUserDetails(user);
	}
}