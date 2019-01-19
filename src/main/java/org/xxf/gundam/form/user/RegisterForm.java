package org.xxf.gundam.form.user;

import lombok.Data;
import org.xxf.gundam.annotation.TrimNotEmpty;

/**
 * @author: xxf
 * @date: 2019/1/14 0014 上午 11:03
 */
@Data
public class RegisterForm {

    @TrimNotEmpty(message = "名称不能为空")
    private String name;

    @TrimNotEmpty(message = "口令不能为空")
    private String password;

}
