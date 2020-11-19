package org.fivesoft.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fivesoft.common.exception.enums.abs.AbstractBaseExceptionEnum;

/**
 * 业务异常
 *
 * @author xuyuxiang
 * @date 2020/4/8 15:54
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ServiceException extends RuntimeException {

    private Integer code;

    private String errorMessage;

    public ServiceException(Integer code, String errorMessage) {
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public ServiceException(AbstractBaseExceptionEnum exception) {
        super(exception.getMessage());
        this.code = exception.getCode();
        this.errorMessage = exception.getMessage();
    }
}
