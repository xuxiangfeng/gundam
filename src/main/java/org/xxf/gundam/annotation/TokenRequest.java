package org.xxf.gundam.annotation;

import java.lang.annotation.*;

/**
 * @author: xxf
 * @date: 2019/1/14 0014 下午 2:44
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TokenRequest {
}
