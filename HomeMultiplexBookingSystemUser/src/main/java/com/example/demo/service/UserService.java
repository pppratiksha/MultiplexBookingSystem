package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Vo.Booking;
import com.example.demo.Vo.Hall;
import com.example.demo.Vo.Movie;
import com.example.demo.Vo.ResponseTemplateVo;
import com.example.demo.Vo.SeatType;
import com.example.demo.Vo.Show;
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
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService{

	public UserService() {
			}
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	//@Override
	public User addUserDetails(User user) throws UserAlreadyExistException {
		Optional<User> optionalUser =  userRepository.findById(user.getUserid());
        if(optionalUser.isPresent()) {
        	throw new UserAlreadyExistException("User already exists..!!");
        }
        
		return userRepository.save(user);

	}

	//@Override
	public User updateUserDetails(User user) throws UserNotFoundException {
		Optional<User> optionalUser =  userRepository.findById(user.getUserid());
        if(!(optionalUser.isPresent())) {
        	throw new UserNotFoundException("This user does not exists..!! Please enter correct details");
        }
		return userRepository.save(user);

	}

	//@Override
	public User showUserDetails(Long userid) throws UserNotFoundException {
		Optional<User> optionalUser =  userRepository.findById(userid);
        if(!(optionalUser.isPresent())) {
        	throw new UserNotFoundException("The with user id: "+userid+" does not exists..!! Please enter correct details");
        }
        return optionalUser.get();
	}

	//@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();

	}
	public User fetchUserByEmailIdAndPassword(String emailid, String passward) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailidAndPassword(emailid,passward);
		//return null;
	}

	//@Override
	public User updateUserDetailsById(Long userid, User user) throws UserNotFoundException {
		if(!(userRepository.existsById(userid))) {
        	throw new UserNotFoundException("The with user id: "+userid+" does not exists..!! Please enter correct details");
		}
		return userRepository.save(user);
	}

	//@Override
	public User showUserDetailsByName(String username) throws UserNotFoundException {
		List<User> users =userRepository.findAll();
		for(User i : users) {
		if(i.getUsername()!=username){
			throw new UserNotFoundException("User with user name: "+username+" does not exist");
		}
		}
		return userRepository.findByUsername(username);
	}
	
}

