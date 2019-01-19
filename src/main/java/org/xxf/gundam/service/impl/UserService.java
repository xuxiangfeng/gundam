package org.xxf.gundam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xxf.gundam.config.LogicEnum;
import org.xxf.gundam.domain.AuthorizationTbl;
import org.xxf.gundam.domain.UserTbl;
import org.xxf.gundam.dto.user.RegisterDto;
import org.xxf.gundam.exception.CustomerException;
import org.xxf.gundam.form.user.CheckPwdForm;
import org.xxf.gundam.form.user.RegisterForm;
import org.xxf.gundam.repository.AuthorizationRepository;
import org.xxf.gundam.repository.UserRepository;
import org.xxf.gundam.service.IUserService;
import org.xxf.gundam.util.EncryptionUtil;
import org.xxf.gundam.util.StringUtil;
import org.xxf.gundam.util.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: xxf
 * @date: 2019/1/14 0014 上午 11:02
 */
@Service
public class UserService extends BaseService implements IUserService {

    private final String TOKEN_DATE_FORMAT = "YYYYMMddHHmmss";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorizationRepository authorizationRepository;

    /**
     * 注册
     *
     * @param form
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RegisterDto register(RegisterForm form) throws Exception{
        UserTbl userTbl = new UserTbl();
        userTbl.setName(form.getName());
        userTbl.setIsDelete(LogicEnum.NO.getValue());
        userTbl.setCreateTime(new Date());
        userRepository.saveAndFlush(userTbl);

        Integer userId = userTbl.getId();

        AuthorizationTbl authorizationTbl = new AuthorizationTbl();
        authorizationTbl.setId(userId);
        authorizationTbl.setSalt(createSalt());
        authorizationTbl.setPassword(getPasswordMd5(form.getPassword()));
        reflashToken(authorizationTbl);

        authorizationRepository.saveAndFlush(authorizationTbl);

        RegisterDto dto = new RegisterDto();
        dto.setToken(authorizationTbl.getToken());
        dto.setUserId(userId);
        return dto;
    }

    /**
     * 验证口令
     *
     * @param form
     * @return
     * @throws Exception
     */
    @Override
    public RegisterDto checkPwd(CheckPwdForm form) throws Exception{
        String passwordMd5 = getPasswordMd5(form.getPassword());

        AuthorizationTbl authorizationTbl = authorizationRepository.findTopByPassword(passwordMd5);
        if(authorizationTbl == null){
            throw new CustomerException("口令错误");
        }
        reflashToken(authorizationTbl);
        authorizationRepository.saveAndFlush(authorizationTbl);

        RegisterDto dto = new RegisterDto();
        dto.setUserId(authorizationTbl.getId());
        dto.setToken(authorizationTbl.getToken());
        return dto;
    }

    /**
     * 校验token
     *
     * @param token
     * @return
     */
    @Override
    public boolean auth(String token){
        if(StringUtil.isEmpty(token)){
            return false;
        }
        AuthorizationTbl authorizationTbl = authorizationRepository.findTopByToken(token);
        if(authorizationTbl == null){
            return false;
        }

        return true;
    }

    /**
     * 更新token
     *
     * @param authorizationTbl
     * @throws Exception
     */
    private void reflashToken(AuthorizationTbl authorizationTbl) throws Exception{
        authorizationTbl.setToken(getToken(authorizationTbl.getPassword(),authorizationTbl.getSalt()));
    }

    /**
     * 创建salt
     *
     * @return
     */
    private String createSalt(){
        return Utils.getRandomStr(6);
    }

    /**
     * 加密密码
     *
     * @param password
     * @return
     * @throws Exception
     */
    private String getPasswordMd5(String password) throws Exception{
        return EncryptionUtil.md5(password);
    }

    /**
     * 获取token
     *
     * @param passwordMd5
     * @param salt
     * @return
     * @throws Exception
     */
    private String getToken(String passwordMd5,String salt) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat(TOKEN_DATE_FORMAT);
        String dateStr = format.format(new Date());
        String message = StringUtil.checkStrNull(passwordMd5) + StringUtil.checkStrNull(salt) + dateStr;
        return EncryptionUtil.md5(message);
    }

}
