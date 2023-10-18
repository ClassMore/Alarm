package dev.ioexception.mail.repository;

import dev.ioexception.mail.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
