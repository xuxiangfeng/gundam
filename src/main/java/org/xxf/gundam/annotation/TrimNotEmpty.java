package org.xxf.gundam.annotation;


import org.xxf.gundam.annotation.impl.TrimNotEmptyVaildator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 验证去空格非空
 * @author xxf
 *
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { TrimNotEmptyVaildator.class })
public @interface TrimNotEmpty {
	String message() default "{com.dianwandashi.game.merchantapi.annotation.TrimNotEmpty.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER })
	@Retention( RetentionPolicy.RUNTIME)
	@Documented
	@interface List {

		TrimNotEmpty[] value();
	}
}
