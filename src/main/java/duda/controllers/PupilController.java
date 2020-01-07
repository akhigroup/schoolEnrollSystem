package duda.controllers;

import duda.domain.Pupil;
import duda.repository.PupilRepository;
import duda.service.PupilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PupilController {

    private final PupilService pupilService;

    PupilController(PupilService service) {
        this.pupilService = service;
    }

    @GetMapping("/pupil")
    List<Pupil> all() {
        return pupilService.findAll();
    }

    @PostMapping("/pupil")
    Long newPupil(@RequestBody Pupil newPupil) {
        return pupilService.addPupil(newPupil).getId();
    }

    @PostMapping("setFriendship/{firstPupilId}/{secondPupilId}")
    void setFriendships(@PathVariable Long firstPupilId, @PathVariable Long secondPupilId) {
        pupilService.setFriendships(firstPupilId, secondPupilId);
    }
}
