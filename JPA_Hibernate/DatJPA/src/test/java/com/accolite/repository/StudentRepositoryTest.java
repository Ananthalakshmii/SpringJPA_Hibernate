package com.accolite.repository;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.accolite.entity.Guardian;
import com.accolite.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void saveStudent() {
		/*
		 * Student student=Student.builder() .emailId("asd@gmail.com")
		 * .firstName("dsfc") .lastName("sdfwe") .guardianName("Nijfsd")
		 * .guardianEmail("dscd@gmail.com") .guardianMobile("3428764239") .build();
		 */
		//(Long studentId, String firstName, String lastName, String emailId, String guardianName,String guardianEmail, String guardianMobile)
		
		
		/*
		 * divided student into student and guardian Student student=new Student(
		 * "anu","dfs","ewf@gmail.com","edw","ewf@gmail.com","3244355");
		 * studentRepository.save(student);
		 */
	}
	
	@Test
	public void printAllStudent() {
		List<Student> studentList= studentRepository.findAll();
		System.out.println("studentList "+studentList);
	}
	
	@Test
	public void studentguaridan() {
		Guardian guardian=new Guardian("sdsdf", "df@dsm.cmcx", "435435");
		Student student=new Student("ddfs","asf","tffh",guardian);
		//System.out.println("inside method");
		//System.out.println(student.getFirstName()+" "+student.getLastName()+" "+student.getEmailId()+" ");
		//System.out.println(guardian.getGuardianName()+" "+guardian.getGuardianEmail()+" "+guardian.getGuardianMobile());
		studentRepository.save(student);
	}

	
	@Test
	public void printStudent() {
		List<Student> student=studentRepository.findByFirstName("anu");
		System.out.println("student "+student);
			}
	
	@Test
	public void printStudentComparing() {
		List<Student> student=studentRepository.findByFirstNameContaining("an");
		System.out.println("student "+student);
	}
	
	@Test
	public void printStudentLastName() {
		List<Student> student=studentRepository.findByLastName("dfs");
		System.out.println("student "+student);
	}
	
	@Test
	public void printGuardian() {
		List<Student> student=studentRepository.findByGuardianGuardianName("sdsdf");
		System.out.println("student "+student);
		
	}
	
	@Test
	public void printFirstNameAndLastName() {
		Student student=studentRepository.findByFirstNameAndLastName("anu","dfs");
		System.out.println("student "+student);
	}
	
	@Test
	public void printStudentByEmailAddress() {
		Student student=studentRepository.getStudentByEmailAddress("farf");
		System.out.println("student "+student);
	}
	
	@Test
	public void printStudentFirstNameByEmailAddress() {
		String string=studentRepository.getStudentFirstNameByEmailAddress("farf");
		System.out.println("first name "+string);
	}
	
	
	@Test
	public void printStudentByEmailAddressSql() {
		Student student=studentRepository.getStudentByEmailAddressSql("farf");
		System.out.println("student "+student);
	}
	
	@Test
	public void printStudentByEmailNativeParam() {
		List<Student> student=studentRepository.getStudentByEmailNativeParam("farf");
		System.out.println("student "+student);
	}
	
	
	@Test
	public void updateStudentFirstNameByEmail() {
		studentRepository.updateStudentFirstNameByEmail("farf","amar");
		
	}
	
	
}




