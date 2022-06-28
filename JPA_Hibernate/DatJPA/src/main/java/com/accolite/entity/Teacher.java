package com.accolite.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long teacherId;
	private String firstName;
	private String lastName;
	
	/*
	 * @OneToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="teacher_id",referencedColumnName = "teacherId") private
	 * List<Course> courses;
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * public List<Course> getCourses() { return courses; }
	 * 
	 * public void setCourses(List<Course> courses) { this.courses = courses; }
	 */
	public Long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	
	

	public Teacher() {
		super();
	}

	public Teacher(String firstName, String lastName/* , List<Course> courses */) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		//this.courses = courses;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
		//, courses="+ courses + "
	}
	
	
	
}
