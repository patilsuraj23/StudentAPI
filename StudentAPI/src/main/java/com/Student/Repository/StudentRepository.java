package com.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.Entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Long>{

}
