package study.datajpa.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.DeptInfo;
import study.datajpa.entity.UserInfo;

@SpringBootTest
@Transactional
@Rollback(value = false)
@Slf4j
class UserRepositoryTest {

    @Autowired
    UserInfoRepository userInfoRepository;
    @Autowired
    DeptInfoRepository deptInfoRepository;

    @Test
    public void returnType() {
//        UserInfo user01 = userInfoRepository.findOneByUserId("user01");
//        log.debug(user01.getUserDesc().toString());
//        log.debug(user01.getDeptInfo().toString());
//        log.debug(user01.toString());

        DeptInfo deptInfo =  deptInfoRepository.findByDeptCd("00001");
        log.debug(deptInfo.toString());




    }

}