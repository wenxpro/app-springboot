package org.fivesoft.common.exception;

import lombok.Getter;
import org.fivesoft.common.exception.enums.abs.AbstractBaseExceptionEnum;

/**
 * 请求方法异常
 *
 * @author xuyuxiang
 * @date 2020/3/11 15:35
 */
@Getter
public class RequestMethodException extends RuntimeException {

    private final Integer code;

    private final String errorMessage;

    public RequestMethodException(AbstractBaseExceptionEnum exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }
}
