package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.Department;
import in.nit.model.Student;
import in.nit.repository.DepartmentRepository;
import in.nit.repository.StudentRepository;

@RestController
public class StudentRestController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@PostMapping("/savestudent")
	public String saveStudentData(@RequestBody Student student)
	{
		Department d = student.getDepartment();
		student.setDepartment(departmentRepository.findDepartmentByName(d.getName()));
		long  id = studentRepository.save(student).getId();
		return "Your Data id saved with id :"+id;
	}
	
	@GetMapping("/getstudent")
	public List<Student> getAllStudentData()
	{
		return studentRepository.findAll();
	}
	
	@GetMapping("/onestudent/{name}")
	public ResponseEntity<Student> getOneStudentId(@PathVariable("name") String name)
	{
		Student s = studentRepository.findByName(name);
		return new ResponseEntity<Student>(s,HttpStatus.OK);
	}
	
	@GetMapping("/alldepartment")
	public List<Department> getAllDepartment()
	{
		return departmentRepository.findAll();
	}
	
	@PostMapping("/savedepartment")
	public String saveDepartmentData(@RequestBody Department department)
	{
		 long id  = departmentRepository.save(department).getId();
		 return "Your Department data stored with :"+id;
	}
}
