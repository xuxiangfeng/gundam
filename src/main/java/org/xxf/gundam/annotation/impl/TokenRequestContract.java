package org.xxf.gundam.annotation.impl;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xxf.gundam.exception.ForbiddenException;
import org.xxf.gundam.service.IUserService;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: xxf
 * @date: 2019/1/14 0014 下午 2:43
 */
@Aspect
@Component
public class TokenRequestContract {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IUserService userService;


    @Pointcut("@annotation(org.xxf.gundam.annotation.TokenRequest)")
    public void token() {
    }

    @Before("token()")
    public void tokenRequireds(JoinPoint joinPoint) {

        String sessinToken = request.getHeader("X-SessionToken-With");

        if (StringUtils.isBlank(sessinToken)) {
            throw new ForbiddenException();
        }

        boolean hasToken = userService.auth(sessinToken);
        if (!hasToken) {
            throw new ForbiddenException();
        }

    }

}
