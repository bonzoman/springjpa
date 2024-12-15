package study.datajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor //(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    private int age;

    @ManyToOne(fetch = FetchType.LAZY) //default FetchType.EAGER(즉시로딩). LAZY(지연로딩) 권장 (성능관점) 사용할때 sql 날려서 가져옴
    @JoinColumn(name = "team_id")
    private Team team;


    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        this.team = team;

    }

    public void changeTeam(Team team) {
        this.team = team; //내꺼만 바꾸는게 아니라
        team.getMembers().add(this); //반대쪽 객체에도 바꿔줌
    }
}
