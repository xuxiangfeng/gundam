package org.xxf.gundam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xxf.gundam.domain.AuthorizationTbl;

/**
 * @author: xxf
 * @date: 2019/1/7 0007 下午 3:50
 */
public interface AuthorizationRepository extends JpaRepository<AuthorizationTbl,Integer> {
}
