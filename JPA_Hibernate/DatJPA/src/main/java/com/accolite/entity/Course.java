package com.accolite.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseId;
	private String title;
	private Integer credit;
	
	
	@OneToOne(mappedBy = "course")
	private CourseMaterial courseMaterial;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="teacher_id",referencedColumnName = "teacherId")
	private Teacher teacher;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="course_student_map",
			joinColumns = @JoinColumn(name="course_id",referencedColumnName = "courseId"),
			inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName = "studentId")
			)
	private List<Student> students;
	
	public void addStudents(Student student) {
		if(student==null) students=new ArrayList<Student>();
		students.add(student);
		
		
	}
	
	
	
	public Course(String title, Integer credit,  Teacher teacher,
			List<Student> students) {
		super();
		this.title = title;
		this.credit = credit;
		//this.courseMaterial = courseMaterial;
		this.teacher = teacher;
		this.students = students;
	}



	public Course(String title, Integer credit, Teacher teacher) {
		super();
		this.title = title;
		this.credit = credit;
		this.teacher = teacher;
	}
	public Course() {
		super();
	}
	public Course(String title, int credit) {
		this.title = title;
		this.credit = credit;
	}
	
	public Course( String title, Integer credit, CourseMaterial courseMaterial) {
		super();
		
		this.title = title;
		this.credit = credit;
		this.courseMaterial = courseMaterial;
	}
	
	
	
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", credit=" + credit + ", courseMaterial="
				+ courseMaterial + ", teacher=" + teacher + ", students=" + students + "]";
	}

	
	
	
	

}
