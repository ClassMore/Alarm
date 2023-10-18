package dev.ioexception.mail.repository;

import dev.ioexception.mail.entitiy.Alarm;
import dev.ioexception.mail.repository.queryDSL.AlarmRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long>, AlarmRepositoryCustom {
}
