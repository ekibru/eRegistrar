package edu.miu.cs425.eRegistrar.repository;

import edu.miu.cs425.eRegistrar.enitity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long>{
}
