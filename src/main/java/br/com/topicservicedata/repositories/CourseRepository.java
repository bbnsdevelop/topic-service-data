package br.com.topicservicedata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.topicservicedata.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
	@Query("select c from Course c where c.categoria = :categoria")
	List<Course> findByCategoria(@Param("categoria") String categoria);

}
