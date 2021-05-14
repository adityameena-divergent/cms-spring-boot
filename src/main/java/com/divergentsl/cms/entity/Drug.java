package com.divergentsl.cms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "drug")
@Getter
@Setter
@ToString
public class Drug {

	@Id
	private int id;
	
	private String name;
	
	private String description;
	
}
