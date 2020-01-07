package duda.controllers;

import duda.service.PupilService;
import duda.service.EnrollmentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    EnrollmentController(EnrollmentService service) {
        this.enrollmentService = service;
    }

    @PostMapping("enroll/{pupilId}")
    void enrollToSchool(@PathVariable Long pupilId) {
        enrollmentService.enrollPupil(pupilId);
    }
}
