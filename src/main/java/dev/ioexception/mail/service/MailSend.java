package dev.ioexception.mail.service;

import dev.ioexception.mail.entitiy.Lecture;
import dev.ioexception.mail.entitiy.Member;
import dev.ioexception.mail.repository.AlarmRepository;
import dev.ioexception.mail.util.MessageTemplate;
import jakarta.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailSend {
    private final MessageTemplate messageTemplate;
    private final AlarmRepository alarmRepository;

//    @Scheduled(cron = "0 39 10 * * *")
    public void sendMail() throws MessagingException {
        HashMap<Member, List<Lecture>> map = alarmRepository.sendMailMemberList();

        for (Member m : map.keySet()) {
            messageTemplate.mailSend(m.getEmail(), map.get(m));
        }
    }
}
