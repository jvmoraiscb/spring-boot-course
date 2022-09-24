package com.jvmoraiscb.springboot.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            /*
            Student joao = new Student(
						"João Victor",
						"jv.moraiscb@gmail.com",
						LocalDate.of(2003, Month.JUNE, 6)
            );
            Student talles = new Student(
                        "Talles Cavalleiro",
                        "talles.weiler.com",
                        LocalDate.of(2002, Month.DECEMBER, 21)
                        );

            repository.saveAll(List.of(joao, talles));
            */
        };
    }
}
