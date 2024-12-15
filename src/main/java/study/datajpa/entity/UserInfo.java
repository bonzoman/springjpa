package study.datajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor //(access = AccessLevel.PROTECTED)
@ToString(of = {"userId", "userNm"})
public class UserInfo {

    @Id
    private String userId;

    private String userNm;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private UserDesc userDesc;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //default FetchType.EAGER(즉시로딩). LAZY(지연로딩) 권장 (성능관점) 사용할때 sql 날려서 가져옴
    @JoinColumn(name = "deptCd")
    private DeptInfo deptInfo;


    public UserInfo(String userId, String userNm, UserDesc userDesc, DeptInfo deptInfo) {
        this.userId = userId;
        this.userNm = userNm;
        this.userDesc = userDesc;
        this.deptInfo = deptInfo;
    }

//    public void changeTeam(Team team) {
//        this.team = team; //내꺼만 바꾸는게 아니라
//        team.getMembers().add(this); //반대쪽 객체에도 바꿔줌
//    }
}
