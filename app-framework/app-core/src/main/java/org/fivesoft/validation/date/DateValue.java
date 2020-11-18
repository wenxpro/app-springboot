package org.fivesoft.validation.date;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 校验日期格式 yyyy-MM-dd
 *
 * @author xuyuxiang
 * @date 2020/5/26 14:48
 */
@Documented
@Constraint(validatedBy = DateValueValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateValue {

    String message() default "日期格式不正确，正确格式应为yyyy-MM-dd";

    Class[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.FIELD, ElementType.PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        DateValue[] value();
    }
}
