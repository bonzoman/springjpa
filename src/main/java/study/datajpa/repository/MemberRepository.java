package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findOneByUsername(String username);
    Optional<Member> findOptionalOneByUsername(String username);
    List<Member> findManyByUsername(String username);

}
