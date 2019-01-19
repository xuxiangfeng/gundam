package org.xxf.gundam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xxf.gundam.dto.user.RegisterDto;
import org.xxf.gundam.exception.CustomerException;
import org.xxf.gundam.form.user.CheckPwdForm;
import org.xxf.gundam.form.user.RegisterForm;
import org.xxf.gundam.service.IUserService;
import org.xxf.gundam.util.Result;
import org.xxf.gundam.util.ResultCode;
import org.xxf.gundam.util.ResultUtil;

import javax.validation.Valid;

/**
 * @author: xxf
 * @date: 2019/1/14 0014 下午 2:55
 */
@RestController
@RequestMapping(name = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 注册
     *
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping(name = "/v1/register")
    public Result<RegisterDto> register(@RequestBody @Valid RegisterForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.putError(ResultCode.ILLEGAL_ARGUMENT,bindingResult.getFieldError().getDefaultMessage());
        }
        try{
            RegisterDto dto = userService.register(form);
            return ResultUtil.success(dto);
        }catch (CustomerException ce){
            return ResultUtil.putError(ce.getCode(),ce.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.putError(ResultCode.SYSTEM_ERROR,e.getMessage());
        }
    }

    /**
     * 登录
     *
     * @param form
     * @param bindingResult
     * @return
     */
    @PostMapping(name = "/v1/register")
    public Result<RegisterDto> login(@RequestBody @Valid CheckPwdForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.putError(ResultCode.ILLEGAL_ARGUMENT,bindingResult.getFieldError().getDefaultMessage());
        }
        try{
            RegisterDto dto = userService.checkPwd(form);
            return ResultUtil.success(dto);
        }catch (CustomerException ce){
            return ResultUtil.putError(ce.getCode(),ce.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.putError(ResultCode.SYSTEM_ERROR,e.getMessage());
        }
    }



}
