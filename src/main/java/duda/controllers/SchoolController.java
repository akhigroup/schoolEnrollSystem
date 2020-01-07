package duda.controllers;

import duda.domain.School;
import duda.repository.SchoolRepository;
import duda.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    SchoolController(SchoolService service) {
        this.schoolService = service;
    }

    @GetMapping("/school")
    List<School> all() {
        return schoolService.findAll();
    }

    @PostMapping("/school")
    Long newSchool(@RequestBody School newSchool) {
        return schoolService.addSchool(newSchool).getId();
    }

}
