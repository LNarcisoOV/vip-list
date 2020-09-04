package com.viplist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Invited {
	
	@Id
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String telephone;
	

}
