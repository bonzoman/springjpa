package study.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberJpaRepositoryTest {

    @Autowired
    MemberJpaRepository memberJpaRepository;

    @Test
    public void testMember() {
//        Member member = new Member("");
//        member.setUsername("memberB");
//        Member savedMember = memberJpaRepository.save(member);
//
//        Member findMember = memberJpaRepository.find(member.getId());
//        Assertions.assertEquals(findMember.getId(), savedMember.getId());
    }

//    @Test
//    public void basicCRUD() {
//        Member member1 = new Member("member1");
//        Member member2 = new Member("member2");
//        memberJpaRepository.save(member1);
//        memberJpaRepository.save(member2);
//
//        //단건조회 검증
//        Member findMember1 = memberJpaRepository.findById(member1.getId()).get();
//        Member findMember2 = memberJpaRepository.findById(member2.getId()).get();
//        Assertions.assertEquals(findMember1, member1);
//        Assertions.assertEquals(findMember2, member2);
//
//        //리스트조회 검증
//        List<Member> all = memberJpaRepository.findAll();
//        Assertions.assertEquals(all.size(), 2);
//
//        //카운트조회 검증
//        long count = memberJpaRepository.count();
//        Assertions.assertEquals(count, 2);
//
//        //삭제 검증
//        memberJpaRepository.delete(member1);
//        memberJpaRepository.delete(member2);
//        long deletedCount = memberJpaRepository.count();
//        Assertions.assertEquals(deletedCount, 0);
//    }


}