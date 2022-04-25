package com.example.demo.model;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="show")
public class Show implements Serializable {

	@Id
	@Column(name="ShowId")
	private long showid;
	
	@Column(name="SlotNo")
	@NotNull(message="Please Enter slotNo Id")	
	@Min(value = 1, message = "ID can't be zero or null")
	private long slotNo;
	
	@Column(name="ToDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Please provide show toDate.")
	private String toDate;
	
	@Column(name="FromDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="Please provide show fromDate.")
	private String fromDate;
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "MovieId")
	private Movie movie;
	
	
//	 @OneToOne(mappedBy = "show",cascade = CascadeType.ALL)
//	 @JsonIgnore
//	 private Hall hall;
	   
	   
	 
	 
	 
	public @NotNull String getToDate() {
		return toDate;
	}

	public void setToDate(@NotNull String toDate) {
		this.toDate = toDate;
	}

	public @NotNull String getFromDate() {
		return fromDate;
	}

	public void setFromDate(@NotNull String fromDate) {
		this.fromDate = fromDate;
	}

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
		return "Show [showid=" + showid + ", slotNo=" + slotNo + ", toDate=" + toDate + ", fromDate=" + fromDate + "]";
	}

	

	
	
	
	

}

