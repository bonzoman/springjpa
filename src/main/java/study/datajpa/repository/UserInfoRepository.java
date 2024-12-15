package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    UserInfo findOneByUserId(String userId);

}
