package study.datajpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor //(access = AccessLevel.PROTECTED)
@ToString(of = {"userId", "userNick", "userCelNum"})
public class UserDesc {

    @Id
    private String userId;

    private String userNick;

    private String userCelNum;

//    @ManyToOne(fetch = FetchType.LAZY) //default FetchType.EAGER(즉시로딩). LAZY(지연로딩) 권장 (성능관점) 사용할때 sql 날려서 가져옴
//    @JoinColumn(name = "team_id")
//    private Team team;


//    public User(String username) {
//        this.username = username;
//    }

    public UserDesc(String userId, String userNick, String userCelNum) {
        this.userId = userId;
        this.userNick = userNick;
        this.userCelNum = userCelNum;
    }

//    public void changeTeam(Team team) {
//        this.team = team; //내꺼만 바꾸는게 아니라
//        team.getMembers().add(this); //반대쪽 객체에도 바꿔줌
//    }
}
