package duda.repository;

import duda.domain.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PupilRepository extends JpaRepository<Pupil, Long> {
}
