package net.springboot.javaproject.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.springboot.javaproject.entity.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long>{
	List<Module> findByName(String name);
}
