package org.xxf.gundam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xxf.gundam.domain.UserTbl;

/**
 * @author: xxf
 * @date: 2019/1/7 0007 下午 3:52
 */
public interface UserRepository extends JpaRepository<UserTbl,Integer> {
}
