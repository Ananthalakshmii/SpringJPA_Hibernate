package com.accolite.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accolite.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByFirstName(String string);

	List<Student> findByFirstNameContaining(String string);

	List<Student> findByLastName(String string);

	//List<Student> findByGuardianName(String string);

	List<Student> findByGuardianGuardianName(String string);

	Student findByFirstNameAndLastName(String string, String string2);
	
	//JPQL
	@Query("select s from Student s where s.emailId=?1")
	Student getStudentByEmailAddress(String string);

	@Query("select s.firstName from Student s where s.emailId=?1")
	String getStudentFirstNameByEmailAddress(String string);

	//SQL
	@Query(value="select * from tbl_student s where s.email_address=?1",nativeQuery = true)
	Student getStudentByEmailAddressSql(String string);

	//Native param
	@Query(value="select * from tbl_student s where s.email_address= :emailId1",nativeQuery = true)
	List<Student> getStudentByEmailNativeParam(@Param("emailId1")String string);

	@Modifying
	@Transactional
	@Query(value="update tbl_student s set s.first_name=?2 where s.email_address=?1",nativeQuery=true)
	void updateStudentFirstNameByEmail(String string, String string2);

}
