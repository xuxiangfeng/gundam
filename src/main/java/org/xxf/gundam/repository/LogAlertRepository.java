package org.xxf.gundam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xxf.gundam.domain.LogAlertTbl;

/**
 * @author: xxf
 * @date: 2019/1/7 0007 下午 3:51
 */
public interface LogAlertRepository extends JpaRepository<LogAlertTbl,Integer> {
}
