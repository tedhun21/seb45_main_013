package shop.petmily.domain.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Petsitter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "petsitter_id")
    private Long petsitterId;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 10)
    private PossiblePetType possiblePetType;

    @Column(length = 7)
    private String possibleLocation;

    @Column(length = 7)
    private String possibleDay;

    @Column(length = 255)
    private Time possibleTimeStart;

    @Column(length = 255)
    private Time possibleTimeEnd;

    @Column
    private double star;

    public enum PossiblePetType {

        PET_DOG("강아지"),
        PET_CAT("고양이"),
        PET_ALL("강아지고양이");

        @Getter
        private String petType;

        PossiblePetType(String petType) {
            this.petType = petType;
        }
    }

    public Petsitter(Member member) {
        this.member = member;
    }
}
