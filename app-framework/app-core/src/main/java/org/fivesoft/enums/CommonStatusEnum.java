package org.fivesoft.enums;

import lombok.Getter;
import org.fivesoft.common.exception.ServiceException;
import org.fivesoft.common.exception.enums.StatusExceptionEnum;

/**
 * 公共状态
 *
 * @author stylefeng
 * @date 2017/1/22 12:14
 */
@Getter
public enum CommonStatusEnum {

    /**
     * 正常
     */
    ENABLE(0, "正常"),

    /**
     * 停用
     */
    DISABLE(1, "停用"),

    /**
     * 删除
     */
    DELETED(2, "删除");

    private final Integer code;

    private final String message;

    CommonStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 检查请求参数的状态是否正确
     *
     * @author stylefeng
     * @date 2020/4/30 22:43
     */
    public static void validateStatus(Integer code) {
        if (code == null) {
            throw new ServiceException(StatusExceptionEnum.REQUEST_EMPTY);
        }
        if (ENABLE.getCode().equals(code) || DISABLE.getCode().equals(code)) {
            return;
        }
        throw new ServiceException(StatusExceptionEnum.NOT_WRITE_STATUS);
    }

}
