package org.fivesoft.annotion;


import org.fivesoft.pojo.base.wrapper.BaseWrapper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 结果包装的注解，一般用在Controller层，给最后响应结果做包装
 *
 * @author fengshuonan
 * @date 2020/7/24 17:10
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Wrapper {

    /**
     * 具体包装类
     */
    Class<? extends BaseWrapper<?>>[] value();

}
