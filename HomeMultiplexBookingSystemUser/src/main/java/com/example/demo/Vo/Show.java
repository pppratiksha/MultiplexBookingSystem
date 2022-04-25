package com.example.demo.Vo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.example.demo.Vo.Hall;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Show implements Serializable {
	@Id

	private long id;
	private long slotNo;
	private String toDate;
	private String fromDate;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "MovieId")
	private Movie movie;

	private Hall hall;
	
	
//	 @OneToOne(mappedBy = "show",cascade = CascadeType.ALL)
//	 @JsonIgnore
//	 private Hall hall;
	   
	   
	 
	
	public Show( @NotNull long slotNo, @NotNull @NotNull String toDate, @NotNull @NotNull String fromDate) {
		super();
		
		this.slotNo = slotNo;
		this.toDate = toDate;
		this.fromDate = fromDate;
	}

	
	public Show( @NotNull long slotNo, @NotNull @NotNull String toDate, @NotNull @NotNull String fromDate, Movie movie) {
		super();
		
		this.slotNo = slotNo;
		this.toDate = toDate;
		this.fromDate = fromDate;
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Show [showid=" + id + ", slotNo=" + slotNo + ", toDate=" + toDate + ", fromDate=" + fromDate + "]";
	}

	

	
	
	
	

}

