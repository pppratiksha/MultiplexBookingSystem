package com.example.demo.Vo;


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
public class Hall implements Serializable {

	@Id
	private long id;
	private String halldesc;
	private int totalcapacity;
	private int availableSeats;
	private Show show;
	private List<SeatType> seattype;


	public Hall(long hallid, String halldesc, @NotNull int totalcapacity,@NotNull int availableseats) {
		super();
		this.id = hallid;
		this.halldesc = halldesc;
		this.totalcapacity = totalcapacity;
		this.availableSeats=availableseats;
	}

	public Hall(long hallid, @NotNull int totalcapacity) {
		super();
		this.id = hallid;
		this.totalcapacity = totalcapacity;
	}

	@Override
	public String toString() {
		return "Hall [hallid=" + id + ", halldesc=" + halldesc + ", totalcapacity=" + totalcapacity + "]";
	}


	

}

