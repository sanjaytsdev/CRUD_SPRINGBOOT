package com.hiber.hiberdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiber.hiberdemo.Entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
