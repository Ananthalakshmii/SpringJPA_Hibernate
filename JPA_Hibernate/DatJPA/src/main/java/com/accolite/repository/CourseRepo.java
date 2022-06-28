package com.accolite.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{

	//Slice<Course> findByTitleContaining(String string, Pageable firstPageWithTenRecords);

	Page<Course> findByTitleContaining(String string, Pageable firstPageWithTenRecords);

}
