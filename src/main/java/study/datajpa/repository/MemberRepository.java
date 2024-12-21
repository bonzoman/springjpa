package study.datajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import study.datajpa.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findOneByUsername(String username);
    Optional<Member> findOptionalOneByUsername(String username);
    List<Member> findManyByUsername(String username);

    Page<Member>  findP1ByUsernameStartingWith(String username, Pageable pageable);

    Slice<Member> findP2ByUsernameStartingWith(String username, Pageable pageable);

    @Query( value = "select m from Member m where username like ?1%",
            countQuery = "select count(m) from Member m where username like ?1%")
    Page<Member>  findP3ByUsernameStartingWith(String username, Pageable pageable);

}
