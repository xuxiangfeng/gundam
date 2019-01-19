package org.xxf.gundam.exception;

import lombok.Getter;
import org.xxf.gundam.util.ResultCode;

/**
 * @author: xxf
 * @date: 2019/1/14 0014 上午 11:28
 */
@Getter
public class CustomerException extends RuntimeException {

    private Object data;
    private ResultCode code;

    public CustomerException(){
        this(ResultCode.ERROR_BUSINESS,ResultCode.ERROR_BUSINESS.getMsg(),null);
    }

    public CustomerException(String msg){
        this(ResultCode.ERROR_BUSINESS,msg,null);
    }

    public CustomerException(String msg,Object data){
        this(ResultCode.ERROR_BUSINESS,msg,data);
    }

    public CustomerException(ResultCode code,String msg){
        this(code,msg,null);
    }

    public CustomerException(ResultCode code,String msg,Object data){
        super(msg);
        this.code = code;
        this.data = data;
    }

}
