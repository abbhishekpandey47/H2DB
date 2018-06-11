package com.demo.H2.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.H2.format.Student;

@Repository
public interface StudentDB extends JpaRepository<Student, Long>{

}
