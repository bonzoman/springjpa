package study.datajpa;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.*;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct //desc 호출하지 않아도 Spring 구동시 의존성주입으로 인해 1번 호출됨
    public void init() {
        initService.dbInit1();
        initService.dbInit2();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit1() {
            System.out.println("Init1" + this.getClass());
            Team teamA = new Team("teamA");
            Team teamB = new Team("teamB");
            em.persist(teamA);
            em.persist(teamB);

            Member member1 = new Member("member1A", 21, teamA);
            Member member2 = new Member("member2A", 22, teamA);
            Member member3 = new Member("member3B", 22, teamB);
            Member member4 = new Member("member4B", 23, teamB);
            em.persist(member1);
            em.persist(member2);
            em.persist(member3);
            em.persist(member4);
        }

        public void dbInit2() {

            DeptInfo deptInfo1 = new DeptInfo("00001","1팀","00010");
            DeptInfo deptInfo2 = new DeptInfo("00002","2팀","00020");
            em.persist(deptInfo1);
            em.persist(deptInfo2);

            UserDesc userDesc1 = new UserDesc("user01","hongNic01","01011112221");
            UserDesc userDesc2 = new UserDesc("user02","hongNic02","01011112222");
            UserDesc userDesc3 = new UserDesc("user03","hongNic03","01011112223");
            UserDesc userDesc4 = new UserDesc("user04","hongNic04","01011112224");
            em.persist(userDesc1);
            em.persist(userDesc2);
            em.persist(userDesc3);
            em.persist(userDesc4);

            UserInfo userInfo1 = new UserInfo("user01","홍길동1", userDesc1, deptInfo1);
            UserInfo userInfo2 = new UserInfo("user02","홍길동2", userDesc2, deptInfo1);
            UserInfo userInfo3 = new UserInfo("user03","홍길동3", userDesc3, deptInfo2);
            UserInfo userInfo4 = new UserInfo("user04","홍길동4", userDesc4, deptInfo2);
            em.persist(userInfo1);
            em.persist(userInfo2);
            em.persist(userInfo3);
            em.persist(userInfo4);
        }

    }
}

