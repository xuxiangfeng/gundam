package org.xxf.gundam.util;

/**
 * @author cheng
 */

public enum ResultCode {
	SUCCESS(0, "success"),
	
	/**
	 * 通用异常
	 */
	SYSTEM_ERROR(10000, "内部异常出错"), 
	DAO_ERROR(10001, "数据层异常出错"), 
	ILLEGAL_ARGUMENT(10002, "非法参数"),
	ERROR_BUSINESS(10005,"业务处理异常"),
	ERROR_DATA_HAS_NOT_INIT(10031, "数据还未被初始化")

	;



	private int code;

	private String msg;

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return code + ":" + msg;
	}

	private ResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
