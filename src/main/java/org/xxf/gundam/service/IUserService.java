package org.xxf.gundam.service;

import org.xxf.gundam.dto.user.RegisterDto;
import org.xxf.gundam.form.user.CheckPwdForm;
import org.xxf.gundam.form.user.RegisterForm;

/**
 * @author: xxf
 * @date: 2019/1/14 0014 上午 11:00
 */
public interface IUserService {

    /**
     * 注册用户
     *
     * @param form
     * @throws Exception
     */
    RegisterDto register(RegisterForm form) throws Exception;

    /**
     * 验证口令
     *
     * @param form
     * @return
     * @throws Exception
     */
    RegisterDto checkPwd(CheckPwdForm form) throws Exception;

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    boolean auth(String token);
}
