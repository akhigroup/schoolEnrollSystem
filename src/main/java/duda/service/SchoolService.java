package duda.service;

import duda.domain.Pupil;
import duda.domain.School;
import duda.repository.SchoolRepository;
import duda.utilities.Haversine;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository repository;

    public SchoolService(SchoolRepository repo, PupilService pupilService) {
        this.repository = repo;
    }

    public List<School> findAll() {
        return this.repository.findAll();
    }

    public School getById(Long id) {
        return this.repository.findById(id).
                orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    public School addSchool(School newSchool) {
        return this.repository.save(newSchool);
    }


}
