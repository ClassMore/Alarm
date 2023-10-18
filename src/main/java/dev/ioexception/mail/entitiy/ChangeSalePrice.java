package dev.ioexception.mail.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
public class ChangeSalePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "lecture_id", referencedColumnName = "lecture_id")
    private Lecture lecture;

    private int oldSalePrice;
    private int newSalePrice;

    @CreationTimestamp
    private LocalDateTime date;

}
