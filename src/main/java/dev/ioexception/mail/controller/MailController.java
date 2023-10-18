package dev.ioexception.mail.controller;

import dev.ioexception.mail.service.MailSend;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {
    private final MailSend mailSend;

    @GetMapping("/")
    public void mailSend() throws MessagingException {
        mailSend.sendMail();
    }
}
