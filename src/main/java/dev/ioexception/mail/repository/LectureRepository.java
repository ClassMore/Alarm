package dev.ioexception.mail.repository;


import dev.ioexception.mail.entitiy.Lecture;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    Lecture findByLectureIdAndDate(String lectureId, LocalDate date);
}
