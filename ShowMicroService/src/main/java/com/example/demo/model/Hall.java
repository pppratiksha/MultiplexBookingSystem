package com.example.demo.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="hall")
public class Hall implements Serializable {


	@Id
	@Column(name="hallid")
	@NotNull(message="Please Enter Hall Id")	
	@Min(value = 1, message = "ID can't be zero or null")
	private long hallid;
	
	@Column(name="halldesc")
	@NotNull(message="Please Enter Hall Description")
	@NotEmpty(message="Please Enter Hall Description. Hall Description can not be blank.")
	private String halldesc;
	
	@Column(name="totalcapacity")
	@NotNull(message="Please Enter totalcapacity")
	@Min(value = 1, message = "capacity can't be zero or null")
	@Max(value = 250, message = "capacity can't exceed more than 250")
	private int totalcapacity;
	
	@Column(name="availableSeats")
	@NotNull(message="Please Enter seatcount")
	@Max(value = 250, message = "available Seats can't be more than totalcapacity")
	private int availableSeats;
//	
//	@OneToOne(cascade=CascadeType.MERGE)
//	@JoinColumn(name = "Show")
	private Show show;
	
//	@OneToMany(mappedBy="hall",cascade = CascadeType.ALL)
//	@JsonIgnore
//	private List<SeatType> seattype;

	

	

	public Hall(long hallid, String halldesc, @NotNull int totalcapacity,@NotNull int availableseats) {
		super();
		this.hallid = hallid;
		this.halldesc = halldesc;
		this.totalcapacity = totalcapacity;
		this.availableSeats=availableseats;
	}

	public Hall(long hallid, @NotNull int totalcapacity) {
		super();
		this.hallid = hallid;
		this.totalcapacity = totalcapacity;
	}

	@Override
	public String toString() {
		return "Hall [hallid=" + hallid + ", halldesc=" + halldesc + ", totalcapacity=" + totalcapacity + "]";
	}

	

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	
	
	

}

