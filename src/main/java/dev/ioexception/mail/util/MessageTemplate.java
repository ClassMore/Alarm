package dev.ioexception.mail.util;

import dev.ioexception.mail.entitiy.Lecture;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageTemplate {
    private final JavaMailSender javaMailSender;

    public void mailSend(String email, List<Lecture> lectures) throws MessagingException {
        MimeMessage message = this.javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(email);
        helper.setSubject("신청하신 강의의 할인정보가 갱신되었습니다.");

        StringBuilder sb = new StringBuilder();
        sb.append("안녕하세요. classmoa입니다! 신청하신 강의의 가격이 변동되어 소식을 보내드립니다.\n");
        sb.append("<table border=\"1\">");
        sb.append("<tr>")
                .append("<th>").append("강의명").append("</th>")
                .append("<th>").append("원가").append("</th>")
                .append("<th>").append("할인가").append("</th>")
                .append("</tr>");

        for (Lecture l : lectures) {
            sb.append("<tr>");
            sb.append("<td>").append("<a href=\"").append(l.getSiteLink()).append("\" target=\"_blank\"> ").append(l.getTitle())
                    .append("</a>").append("</td>");
            sb.append("<td>").append(l.getOrdinaryPrice()).append("원").append("</td>");
            sb.append("<td>").append(l.getSalePrice()).append("원").append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("앞으로도 classmoa 많은 관심 부탁드립니다. 감사합니다.");

        helper.setText(sb.toString(), true);

        this.javaMailSender.send(message);
    }
}

