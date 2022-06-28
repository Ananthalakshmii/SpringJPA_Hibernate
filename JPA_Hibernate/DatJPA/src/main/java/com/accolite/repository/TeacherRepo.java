package com.accolite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.entity.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long>{

}
