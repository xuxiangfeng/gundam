package org.xxf.gundam.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author: xxf
 * @date: 2019/1/14 0014 上午 11:52
 */
public class StringUtil {

    /**
     * 过滤null值
     *
     * @param message
     * @return
     */
    public static String checkStrNull(String message){
        return message == null ? "" : message;
    }

    public static boolean isEmpty(String message){
        return StringUtils.isEmpty(message) || "null".equals(message);
    }

}
