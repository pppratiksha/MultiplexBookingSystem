package com.example.demo.Vo;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatType implements Serializable {

	@Id
    private Long id;
	private String seattypedesc;
	private float seatfare;
	private int seatcount;
	private Hall hall;
	

	

	

	
	public SeatType(long seattypeid, @NotNull String seattypedesc, @NotNull float seatfare, @NotNull int seatcount) {
		super();
		this.id = seattypeid;
		this.seattypedesc = seattypedesc;
		this.seatfare = seatfare;
		this.seatcount = seatcount;
	}
	

	public SeatType(long seattypeid,@NotNull String seattypedesc, @NotNull float seatfare, @NotNull int seatcount, Hall hall) {
		super();
		this.id = seattypeid;
		this.seattypedesc = seattypedesc;
		this.seatfare = seatfare;
		this.seatcount = seatcount;
		this.hall = hall;
	}

	@Override
	public String toString() {
		return "SeatType [seattypeid=" + id + ", seattypedesc=" + seattypedesc + ", seatfare=" + seatfare + "]";
	}
	
	
	
	

}
