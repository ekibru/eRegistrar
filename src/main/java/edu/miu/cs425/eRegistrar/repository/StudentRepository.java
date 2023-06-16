package edu.miu.cs425.eRegistrar.repository;


import edu.miu.cs425.eRegistrar.enitity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
