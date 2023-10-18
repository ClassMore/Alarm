package dev.ioexception.mail.entitiy;

import static jakarta.persistence.FetchType.LAZY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "lecture_id", referencedColumnName = "lecture_id")
    private Lecture lecture;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private int customPrice;
    private boolean canceled;
    public Alarm(int customPrice) {
        this.customPrice = customPrice;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Builder(builderMethodName = "canceler", buildMethodName = "cancel")
    public Alarm(Long id) {
        this.id = id;
    }
}
