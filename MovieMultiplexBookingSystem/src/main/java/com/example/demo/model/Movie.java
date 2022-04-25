package com.example.demo.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="movie")
public class Movie implements Serializable{
	

	@Id
	@Column(name="MovieId",updatable=false)
	@NotNull(message="Please Enter Movie Id")	
	@Min(value = 1, message = "ID can't be zero or null")
	private long id;
	
	@Column(name="moviename")
	@NotNull(message="Please Enter Movie Name")
	@NotEmpty(message="Please Enter Movie Name. Name can not be blank.")
	private String movieName;
	
	@Column(name="moviedesc")
	@NotNull(message="Please Enter Movie Description")
	@NotEmpty(message="Please Enter Movie Description. Description can not be blank.")
	private String movieDescription;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	
	@Override
	public String toString() {
		return "Movie [movieid=" + id + ", movieName=" + movieName + ", movieDescription=" + movieDescription
				+ "]";
	}
	
	
	

	

}
