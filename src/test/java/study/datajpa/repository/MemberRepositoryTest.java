package study.datajpa.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import javax.print.attribute.standard.PageRanges;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(value = false)
@Slf4j
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TeamRepository teamRepository;

/* ---username----age---team--------------
   | "member1A"|  21 |  teamA
   | "member2A"|  22 |
   | "member3B"|  22 |  teamB
   | "member4B"|  23 |
----------------------------------------- */

    @Test
    public void paging() {
        PageRequest pageRequest = PageRequest.of(0,5, Sort.by(Sort.Direction.DESC, "username"));

        //총건수
        Page<Member> page1 = memberRepository.findP1ByUsernameStartingWith("member", pageRequest);
//        List<Member> page1Members = page1.getContent();
        log.debug("전체카운트 : {}", page1.getTotalElements() );


        //이전다음 paging (total count 구하지 않음)
        Slice<Member> page2 = memberRepository.findP2ByUsernameStartingWith("member", pageRequest);
//        List<Member> page2Members = page2.getContent();
        log.debug("다음 페이지 여부 : {}", page2.hasNext());

        //총건수(총건수 SQL 분리)
        Page<Member> page3 = memberRepository.findP3ByUsernameStartingWith("member", pageRequest);
//        List<Member> page3Members = page3.getContent();
        log.debug("전체카운트 : {}", page3.getTotalElements() );

        log.debug("end");

    }

    @Test
    public void returnType() {

        //조건에 해당하는 값이 없을경우

        Member member1 = memberRepository.findOneByUsername("BLANK"); //CASE1 (Return type : Member)
        if(member1 == null) log.debug("NULL");

        Optional<Member> oMember = memberRepository.findOptionalOneByUsername("BLANK"); //CASE1 (Return type : Member)
        Member member2 = oMember.orElseGet(Member::new);//값이 없다면 빈 객체 생성
//      Member member3 = oMember.orElseThrow(() -> new NoSuchElementException("No value present!"));//값이 없다면 NoSuchElementException 발생
        Member member4 = oMember.orElseGet(() -> null);//값이 없다면 null
        log.debug(member2.getUsername());

        List<Member> members1 = memberRepository.findManyByUsername("BLANK"); //CASE1 (Return type : Member)
        //값이 없다면 members1은 Null이 아니며 members1.size() == 0 임
        log.debug("members1 is null : {}"  , members1 == null);
        if(members1 != null) {
            log.debug("members1.size() : {}", members1.size());
        }
    }


//    @Test
//    public void basicCRUD() {
//        Member member1 = new Member("member1");
//        Member member2 = new Member("member2");
//        memberRepository.save(member1);
//        memberRepository.save(member2);
//
//        //단건조회 검증
//        Member findMember1 = memberRepository.findById(member1.getId()).get();
//        Member findMember2 = memberRepository.findById(member2.getId()).get();
//        Assertions.assertEquals(findMember1, member1);
//        Assertions.assertEquals(findMember2, member2);
//
//        //리스트조회 검증
//        List<Member> all = memberRepository.findAll();
//        Assertions.assertEquals(all.size(), 2);
//
//        //카운트조회 검증
//        long count = memberRepository.count();
//        Assertions.assertEquals(count, 2);
//
//        //삭제 검증
//        memberRepository.delete(member1);
//        memberRepository.delete(member2);
//        long deletedCount = memberRepository.count();
//        Assertions.assertEquals(deletedCount, 0);
//    }
}