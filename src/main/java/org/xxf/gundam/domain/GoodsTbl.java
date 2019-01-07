package org.xxf.gundam.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * 物品
 *
 * @author: xxf
 * @date: 2019/1/7 0007 下午 3:39
 */
@Data
@Entity
@Table(name = "c_goods_tbl")
public class GoodsTbl {

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
     * 图片
     */
    @Column(name = "photo")
    private String photo;

    /**
     * 场地ID
     */
    @Column(name = "place_id")
    private Integer placeId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后移动时间
     */
    @Column(name = "last_move_time")
    private Date lastMoveTime;

    /**
     * 是否删除 0否 1是
     */
    @Column(name = "is_delete")
    private Integer isDelete;


}
