package org.xxf.gundam.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * 物品移动日志
 *
 * @author: xxf
 * @date: 2019/1/7 0007 下午 3:46
 */
@Data
@Entity
@Table(name = "log_goods_move_tbl")
public class LogGoodsMoveTbl {

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
     * 物品ID,逗号隔开
     */
    @Column(name = "goods_id")
    private String goodsId;

    /**
     * 场所ID（移动前）
     */
    @Column(name = "place_id_before")
    private Integer placeIdBefore;

    /**
     * 场所ID（移动后）
     */
    @Column(name = "place_id_after")
    private Integer placeIdAfter;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;


}
