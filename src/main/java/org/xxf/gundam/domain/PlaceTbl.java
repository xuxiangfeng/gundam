package org.xxf.gundam.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 场所
 *
 * @author: xxf
 * @date: 2019/1/7 0007 下午 3:42
 */
@Data
@Entity
@Table(name = "c_place_tbl")
public class PlaceTbl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 是否删除 0否 1是
     */
    @Column(name = "is_delete")
    private Integer isDelete;

}
