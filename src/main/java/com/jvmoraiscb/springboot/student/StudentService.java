package com.jvmoraiscb.springboot.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}

    public List<Student> getStudents() {
		return studentRepository.findAll();
	}

    public void addNewStudent(Student student) {
		Optional<Student> studentOptional =  studentRepository.findStudentByEmail(student.getEmail());
		if(studentOptional.isPresent()){
			throw new IllegalStateException("The email has already taken.");
		}
		studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if(!exists) {
			throw new IllegalStateException("The student whit id " + studentId + " does not exists.");
		}
		studentRepository.deleteById(studentId);
    }

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("The student with id " + studentId + "does not exists."));

		if(name != null && name.length() > 0 && !Objects.equals((student.getName()), name)){
			student.setName(name);
		}
		if(email != null && email.length() > 0 && !Objects.equals((student.getEmail()), email)){
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
			if(studentOptional.isPresent()){
				throw new IllegalStateException("The email has already taken.");
			}
			student.setEmail(email);
		}
	}
}
