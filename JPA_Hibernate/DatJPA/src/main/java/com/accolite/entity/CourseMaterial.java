package com.accolite.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CourseMaterial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseMaterialId;
	private String url;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false/* ,fetch = FetchType.LAZY */)
	@JoinColumn(name="course_id",referencedColumnName = "courseId")
	private Course course;
	
	
	public Long getCourseMaterialId() {
		return courseMaterialId;
	}
	public void setCourseMaterialId(Long courseMaterialId) {
		this.courseMaterialId = courseMaterialId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public CourseMaterial(String url,Course course) {
		super();
	
		this.url = url;
		this.course=course;
	}
	@Override
	public String toString() {
		return "CourseMaterial [courseMaterialId=" + courseMaterialId + ", url=" + url + "]";
		//, course=" + course + "
	}
	public CourseMaterial() {
		super();
	}
	
	
}
