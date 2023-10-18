package dev.ioexception.mail.repository.queryDSL;

import dev.ioexception.mail.entitiy.Lecture;
import dev.ioexception.mail.entitiy.Member;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmRepositoryCustom {
    HashMap<Member, List<Lecture>> sendMailMemberList();
}
