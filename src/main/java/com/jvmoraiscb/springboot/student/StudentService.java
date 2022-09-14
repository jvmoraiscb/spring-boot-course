package com.jvmoraiscb.springboot.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public List<Student> getStudents() {
		return List.of(
			new Student(1L,
						"João",
						"jv.moraiscb@gmail.com",
						LocalDate.of(2003, Month.JUNE, 6),
						19)
		);
	}
}
