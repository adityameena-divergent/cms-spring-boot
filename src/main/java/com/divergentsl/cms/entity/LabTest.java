package com.divergentsl.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "labtest")
@Getter
@Setter
@ToString
public class LabTest {

	@Id
	@Column(name = "test_id")
	private int testId;
	
	@Column(name = "test_name")
	private String testName;
	
	@Column(name = "test_fee")
	private int testFee;
	
}
