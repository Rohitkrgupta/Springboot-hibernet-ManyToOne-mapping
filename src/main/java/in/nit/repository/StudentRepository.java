package in.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nit.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

	public Student findByName(String name);
}
