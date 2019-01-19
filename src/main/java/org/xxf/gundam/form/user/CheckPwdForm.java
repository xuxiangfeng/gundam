package org.xxf.gundam.form.user;

import lombok.Data;
import org.xxf.gundam.annotation.TrimNotEmpty;

/**
 * @author: xxf
 * @date: 2019/1/14 0014 下午 12:01
 */
@Data
public class CheckPwdForm {

    @TrimNotEmpty(message = "口令不能为空")
    private String password;

}
