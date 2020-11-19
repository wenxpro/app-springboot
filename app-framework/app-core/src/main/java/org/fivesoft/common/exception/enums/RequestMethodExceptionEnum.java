package org.fivesoft.common.exception.enums;


import org.fivesoft.annotion.ExpEnumType;
import org.fivesoft.common.consts.ExpEnumConstant;
import org.fivesoft.common.exception.enums.abs.AbstractBaseExceptionEnum;
import org.fivesoft.factory.ExpEnumCodeFactory;

/**
 * 请求方法相关异常枚举
 *
 * @author xuyuxiang
 * @date 2020/3/11 15:33
 */
@ExpEnumType(module = ExpEnumConstant.GUNS_CORE_MODULE_EXP_CODE, kind = ExpEnumConstant.REQUEST_METHOD_EXCEPTION_ENUM)
public enum RequestMethodExceptionEnum implements AbstractBaseExceptionEnum {

    /**
     * 不支持该请求方法，请求方法应为POST
     */
    REQUEST_METHOD_IS_POST(1, "不支持该请求方法，请求方法应为POST"),

    /**
     * 不支持该请求方法，请求方法应为GET
     */
    REQUEST_METHOD_IS_GET(2, "不支持该请求方法，请求方法应为GET");

    private final Integer code;

    private final String message;

    RequestMethodExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return ExpEnumCodeFactory.getExpEnumCode(this.getClass(), code);
    }

    @Override
    public String getMessage() {
        return message;
    }

}
