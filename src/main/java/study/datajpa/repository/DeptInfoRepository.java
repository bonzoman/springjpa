package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.entity.DeptInfo;
import study.datajpa.entity.UserInfo;

public interface DeptInfoRepository extends JpaRepository<DeptInfo, String> {
    DeptInfo findByDeptCd(String deptCd);

}
