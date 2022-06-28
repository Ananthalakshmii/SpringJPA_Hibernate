package com.accolite.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.accolite.entity.Course;
import com.accolite.entity.CourseMaterial;
import com.accolite.entity.Guardian;
import com.accolite.entity.Student;
import com.accolite.entity.Teacher;

@SpringBootTest
public class CourseRepoTest {

	@Autowired
	private CourseRepo courseRepo;
	
	@Test
	public void printCourses() {
		List<Course> course= courseRepo.findAll();
		System.out.println("course "+course);
	}
	
	@Test
	public void saveCourseWithTeacher() {
		
		Teacher teacher=new Teacher("ramu", "krish");
		Course course=new Course("Maths", 9,teacher);
		courseRepo.save(course);
		
	}
	
	
	@Test
	public void findAllPagination() {
		Pageable firstPageWithThreeRecords=PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords=PageRequest.of(1, 2);
		
		List<Course> courses= courseRepo.findAll(firstPageWithThreeRecords).getContent();
		System.out.println("courses in first page: "+courses);
		System.out.println("total page in 1 page "+courseRepo.findAll(firstPageWithThreeRecords).getTotalPages());
		System.out.println("total elements "+courseRepo.findAll(firstPageWithThreeRecords).getTotalElements());
		
		List<Course> courses1=courseRepo.findAll(secondPageWithTwoRecords).getContent();
		System.out.println("Courses in second page "+courses1);
		System.out.println("total page in 2 page "+courseRepo.findAll(secondPageWithTwoRecords).getTotalPages());
		System.out.println("total elements "+courseRepo.findAll(secondPageWithTwoRecords).getTotalElements());
		
		
	}
	
	@Test
	public void findAllSorting() {
		Pageable sortByTitle=PageRequest.of(0, 3,Sort.by("title"));
		Pageable sortByCreditDesc=PageRequest.of(0, 3, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc=PageRequest.of(0, 3, Sort.by("title").descending().and(Sort.by("credit")).descending());
		
		//List<Course> courses=courseRepo.findAll(sortByTitle).getContent();
		
		System.out.println("sort by title "+courseRepo.findAll(sortByTitle).getContent());
		System.out.println("sort by credit desc "+courseRepo.findAll(sortByCreditDesc).getContent());
		System.out.println("sort by title and credit desc "+courseRepo.findAll(sortByTitleAndCreditDesc).getContent());
	}
	
	
	@Test
	public void printFindByTitleContaining() {
		Pageable firstPageWithTenRecords=PageRequest.of(0, 10);
		List<Course> courses=courseRepo.findByTitleContaining("D",firstPageWithTenRecords).getContent();
		System.out.println("courses "+courses);
	}
	
	@Test
	public void saveCourseWithStudentAndTeacher() {
		//String title, Integer credit, CourseMaterial courseMaterial, Teacher teacher,List<Student> students
		Guardian guardian=new Guardian("ananthu", "ananthu@gmail.com", "32435546");
		Student student=new Student("vruthu", "ananthu", "vruthu@gmail.com", guardian);
		Teacher teacher=new Teacher("anu", "vruthu");
		Course course=new Course("Python",6,teacher,List.of(student));
		
		courseRepo.save(course);
	}
	
	
	
	
}
