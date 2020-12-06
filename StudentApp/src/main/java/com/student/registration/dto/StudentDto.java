package com.student.registration.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_reg")
public class StudentDto {
     
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stuId;
	
	private String stuName;
	
	private int  stuAge;
	
	private String  branch;
	
	private String  college;
	
	private String  collegeCode;
	
	private String  stuAddress;
	
	private String collegeAddress;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public String getCollegeAddress() {
		return collegeAddress;
	}

	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}

	@Override
	public String toString() {
		return "StudentDto [stuId=" + stuId + ", stuName=" + stuName + ", stuAge=" + stuAge + ", branch=" + branch
				+ ", college=" + college + ", collegeCode=" + collegeCode + ", stuAddress=" + stuAddress
				+ ", collegeAddress=" + collegeAddress + "]";
	}



}

