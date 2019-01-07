package org.xxf.gundam.util;

import lombok.Data;

/**
 * @author: xxf
 * @date: 2019/1/5 0005 下午 6:08
 */
@Data
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

}
