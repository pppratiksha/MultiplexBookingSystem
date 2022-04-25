package com.example.demo.Vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseTemplateVo {

	private User user;
	private Movie movie;
	private Booking bookin;
	private Hall hall;
	private SeatType seatType;
	//@Autowired
	private Show show;
}
