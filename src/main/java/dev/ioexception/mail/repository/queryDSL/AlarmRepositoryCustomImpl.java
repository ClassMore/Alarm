package dev.ioexception.mail.repository.queryDSL;

import dev.ioexception.mail.entitiy.Alarm;
import dev.ioexception.mail.entitiy.Lecture;
import dev.ioexception.mail.entitiy.Member;
import dev.ioexception.mail.entitiy.QAlarm;
import dev.ioexception.mail.entitiy.QChangeSalePrice;
import dev.ioexception.mail.entitiy.QLecture;
import dev.ioexception.mail.entitiy.QMember;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AlarmRepositoryCustomImpl extends QuerydslRepositorySupport implements AlarmRepositoryCustom {

    public AlarmRepositoryCustomImpl() {
        super(Alarm.class);
    }

    @Override
    public HashMap<Member, List<Lecture>> sendMailMemberList() {
        QAlarm alarm = QAlarm.alarm;
        QLecture lecture = QLecture.lecture;
        QMember member = QMember.member;
        QChangeSalePrice changeSalePrice = QChangeSalePrice.changeSalePrice;

        HashMap<Member, List<Lecture>> map = new HashMap<>();

        List<Alarm> query =
                from(alarm)
                        .innerJoin(alarm.member, member)
                        .innerJoin(changeSalePrice).on(alarm.lecture.lectureId.eq(
                                QChangeSalePrice.changeSalePrice.lecture.lectureId))
                        .innerJoin(alarm.lecture, lecture)
                        .where(lecture.date.eq(LocalDate.now()))
                        .where(alarm.customPrice.goe(QChangeSalePrice.changeSalePrice.newSalePrice)
                                .and(alarm.canceled.eq(false)))
                        .fetchJoin()
                        .stream().toList();

        System.out.println(query.size());

        for (Alarm a : query) {
            map.computeIfAbsent(a.getMember(), k -> new ArrayList<>()).add(a.getLecture());
        }

        return map;
    }
}
