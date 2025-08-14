package com.jpahibernate.Student_Management_DB.Repository;

import com.jpahibernate.Student_Management_DB.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {


}