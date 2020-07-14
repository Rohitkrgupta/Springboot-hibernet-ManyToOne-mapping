package in.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.nit.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{

	public Department findDepartmentByName(String name);
}
