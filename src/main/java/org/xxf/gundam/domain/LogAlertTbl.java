package org.xxf.gundam.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 操作日志
 *
 * @author: xxf
 * @date: 2019/1/7 0007 下午 3:45
 */
@Data
@Entity
@Table(name = "log_alert_tbl")
public class LogAlertTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 操作人ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 描述
     */
    @Column(name = "remark")
    private String remark;


    @Column(name = "create_time")
    private Date createTime;

}
