package study.datajpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor //(access = AccessLevel.PROTECTED)
@ToString(of = {"deptCd", "deptNm", "uppDeptCd"})
public class DeptInfo {

    @Id
    private String deptCd;

    private String deptNm;

    private String uppDeptCd;

    @OneToMany(mappedBy = "deptInfo")
//    @JoinColumn(name = "userId")
    private List<UserInfo> members = new ArrayList<>();


//    @OneToOne(cascade = CascadeType.ALL) //default FetchType.EAGER(즉시로딩). LAZY(지연로딩) 권장 (성능관점) 사용할때 sql 날려서 가져옴
//    @JoinColumn(name = "userId")
//    private UserDesc userDesc;

    public DeptInfo(String deptCd, String deptNm, String uppDeptCd) {
        this.deptCd = deptCd;
        this.deptNm = deptNm;
        this.uppDeptCd = uppDeptCd;
    }

//    public DeptInfo(String userId, String userNm, UserDesc userDesc) {
//        this.userId = userId;
//        this.userNm = userNm;
//        this.userDesc = userDesc;
//    }

//    public void changeTeam(Team team) {
//        this.team = team; //내꺼만 바꾸는게 아니라
//        team.getMembers().add(this); //반대쪽 객체에도 바꿔줌
//    }
}
