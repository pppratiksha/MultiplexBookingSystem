package com.example.demo.Vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.Vo.Hall;
import com.example.demo.Vo.SeatType;
import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking implements Serializable {
	@Id
	private long bookingId;
    private Calendar createdDate;
	private int seatcount;
	private String showdate;
    private Hall hall;
    private Show show;
	private User user;
	
	public Booking(@NotNull Calendar createdDate, String showdate) {
		super();
		this.createdDate = createdDate;
		this.showdate = showdate;
	}

	public Booking(@NotNull Calendar createdDate) {
		super();
		this.createdDate = createdDate;
	}

	public Booking(@NotNull Calendar createdDate, @NotNull int seatcount, String showdate) {
		super();
		this.createdDate = createdDate;
		this.seatcount = seatcount;
		this.showdate = showdate;
	}
	

}
