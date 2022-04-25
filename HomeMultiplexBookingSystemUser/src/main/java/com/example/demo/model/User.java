package com.example.demo.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User implements Serializable {

	@Id
//    @GeneratedValue(generator = "user_seq")
	@Column(name="userid")
	private long userid;
	
	@Column(name="username")
	@NotNull(message="Please Enter user name")
	@NotEmpty(message="Please Enter user Name. Name can not be blank.")
	private String username;
	
	@Column(name="usertype")
	private char usertype;
	
	@Column(name="emailid", unique=true)
	@NotNull(message="Please Enter Email")
	@NotEmpty(message="Please Enter Email. Email can not be blank.")
	@Email
	private String emailid;
	
	@Column(name="password")
	@Size(min = 6, message = "Password must be a greater than 6 characters")
	@Pattern(regexp="[a-zA-z0-9]{6,}",message="must match proper format.")
	private String password;
	
	@Column(name="mobilenumber",unique=true)
	@Size(min = 11, max = 11, message = "Mobile number must be a 11-digit string.")
	@Pattern(regexp="0[0-9]{10}",message="Contact should start with 0 and enter proper contact.") 
	private String mobileno;
	

	public User(String username, char usertype, String emailid, String password, String mobileno) {
		super();
		this.username = username;
		this.usertype = usertype;
		this.emailid = emailid;
		this.password = password;
		this.mobileno = mobileno;
	}
}