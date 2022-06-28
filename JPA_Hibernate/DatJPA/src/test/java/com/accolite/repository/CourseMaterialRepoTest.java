package com.accolite.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.accolite.entity.Course;
import com.accolite.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepoTest {
	
	@Autowired
	private CourseMaterialRepo courseMaterialRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Test
	public void saveCourseMaterial() {
		Course course=new Course( "DBA", 7);
		CourseMaterial courseMaterial=new CourseMaterial("rthjoi.com",course);
		courseMaterialRepo.save(courseMaterial);
	}
	
	@Test
	public void printCourseMaterial() {
		
		List<CourseMaterial> courseMaterial=courseMaterialRepo.findAll();
		System.out.println("course Material "+courseMaterial);
	}

}
