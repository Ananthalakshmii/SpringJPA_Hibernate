package com.accolite.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.accolite.entity.Course;
import com.accolite.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepo teacherRepo;

	
	@Test
	public void saveTeacher() {
		
		Course course1=new Course("DB",6);
		Course course2=new Course("MS",5);
		//Teacher teacher=new Teacher("rani","fwe",List.of(course1,course2));
		//teacherRepo.save(teacher);
				
				
	}
}
