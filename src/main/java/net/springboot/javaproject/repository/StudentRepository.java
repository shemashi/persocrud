package net.springboot.javaproject.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.springboot.javaproject.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findByName(String name);
}
