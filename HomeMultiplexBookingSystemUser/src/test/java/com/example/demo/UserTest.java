package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
@SpringBootTest
public class UserTest {
	@MockBean
	UserRepository repository;
	@Autowired
	UserService service;
	@Test
	public void addUserDetails()
	{
		when(repository.findAll()).thenReturn(Stream.of(new User(12,"p@gmail.com",'f',"03895369982","pP12345678","pratiksh"),new User(1,"p1@gmail.com",'f',"03893369982","pP12245678","praatiksh")).collect(Collectors.toList()));
	assertEquals(2, service.getAllUsers().size());
	}
	@Test
	public void getAllUsers()
	{
//		User user=new User(12,"p@gmail.com",'f',"03895369982","pP12345678","pratiksh");
//		when(repository.save(user)).thenReturn(user);
//		assertEquals(user, service.updateUserDetails(user));
		when(repository.findAll()).thenReturn(Stream.of(new User(12,"p@gmail.com",'f',"03895369982","pP12345678","pratiksh")).collect(Collectors.toList()));
		assertEquals(1, service.getAllUsers().size());
		
	}
	
//	@Test
//	public void loginUser() {
//	String emailid="p@gmail.com";
//	String password="pP12345678";
//			
//		when(repository.findByEmailidAndPassword(emailid, password)).thenReturn((User) Stream.of(new User(12,"p@gmail.com",'f',"03895369982","pP12345678","pratiksh")).collect(Collectors.toList()));
//	assertEquals(0, ((List<User>) service.fetchUserByEmailIdAndPassword(emailid, password)).size());
//	}

}
