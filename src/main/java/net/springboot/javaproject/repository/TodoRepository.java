package net.springboot.javaproject.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.springboot.javaproject.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
	List<Todo> findByName(String name);
}
