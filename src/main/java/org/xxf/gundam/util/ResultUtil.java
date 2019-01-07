package org.xxf.gundam.util;

import org.apache.commons.lang.StringUtils;

/**
 * @author: xxf
 * @date: 2019/1/5 0005 下午 6:09
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result putError(ResultCode error) {
        Result result = new Result();
        result.setCode(error.getCode());
        result.setMsg(error.getMsg());
        return result;
    }

    public static Result putError(ResultCode error, String msg) {
        Result result = new Result();
        result.setCode(error.getCode());
        if (StringUtils.isBlank(msg)) {
            result.setMsg(error.getMsg());
        } else {
            result.setMsg(msg);
        }
        return result;
    }

    public static Result putError(ResultCode error, String msg,Object object) {
        Result result = new Result();
        result.setCode(error.getCode());
        result.setData(object);
        if (StringUtils.isBlank(msg)) {
            result.setMsg(error.getMsg());
        } else {
            result.setMsg(msg);
        }
        return result;
    }


}
