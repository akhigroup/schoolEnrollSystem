package duda.service;

import duda.domain.Pupil;
import duda.repository.PupilRepository;
import duda.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PupilService {

    @Autowired
    private final PupilRepository repository;

    public PupilService(PupilRepository repo) {
        this.repository = repo;
    }

    public List<Pupil> findAll() {
        return repository.findAll();
    }

    public Pupil getById(Long id) {
        return this.repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    public Pupil addPupil(Pupil newPupil) {
        return this.repository.save(newPupil);
    }

    public void setFriendships(Long firstPupilId, Long secondPupilId) {
        repository.findById(firstPupilId).ifPresent(firstpupil -> {
          repository.findById(secondPupilId).ifPresent(second -> {
              firstpupil.addFriend(second);
              repository.save(firstpupil);
            });
        });
    }

}


