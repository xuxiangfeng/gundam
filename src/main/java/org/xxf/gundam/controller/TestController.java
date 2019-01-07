package org.xxf.gundam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xxf.gundam.util.Result;
import org.xxf.gundam.util.ResultUtil;

/**
 * @author: xxf
 * @date: 2019/1/5 0005 下午 6:08
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @GetMapping(value = "/v1/test")
    public Result<Boolean> test(){
        return ResultUtil.success(true);
    }

}
