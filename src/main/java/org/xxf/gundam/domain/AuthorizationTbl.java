package org.xxf.gundam.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户登录相关
 *
 * @author: xxf
 * @date: 2019/1/7 0007 下午 3:35
 */
@Data
@Entity
@Table(name = "c_authorization_tbl")
public class AuthorizationTbl {

    @Id
    @Column(name = "id",unique = true)
    private Integer id;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * token
     */
    @Column(name = "token")
    private String token;

    /**
     * salt
     */
    @Column(name = "salt")
    private String salt;
}
