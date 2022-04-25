package com.example.demo.model;



import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
	
	 @OneToMany(mappedBy = "movie", cascade = {CascadeType.ALL})
	 @JsonIgnore
	 private List<Show> show;
	 
	 

	
	public Movie(@NotNull long id, @NotNull String movieName, @NotNull String movieDescription) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
	}

	@Override
	public String toString() {
		return "Movie [movieid=" + id + ", movieName=" + movieName + ", movieDescription=" + movieDescription
				+ "]";
	}
	
	
	

	

}
