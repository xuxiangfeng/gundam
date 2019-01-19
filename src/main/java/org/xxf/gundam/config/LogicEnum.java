package org.xxf.gundam.config;

/**
 * 是否删除 0否 1是
 *
 * @author: xxf
 * @date: 2019/1/14 0014 上午 11:08
 */
public enum LogicEnum {

    YES(1),
    NO(0);

    private Integer value;

    private LogicEnum(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return this.value;
    }

}
