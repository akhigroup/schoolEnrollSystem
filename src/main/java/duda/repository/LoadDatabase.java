package duda.repository;

import duda.domain.Grade;
import duda.domain.Pupil;
import duda.repository.PupilRepository;
import duda.repository.GradeRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(GradeRepository repository) {
        return args -> {

//            repository.save(new Grade("bible", 80));
        };
    }
}