package org.fivesoft.consts;

/**
 * aop顺序的常量
 * <p>
 * 顺序越小越靠前
 *
 * @author wenx
 * @date 2020-11-09
 */
public interface AopSortConstant {

    /**
     * 全局异常拦截器
     */
    int GLOBAL_EXP_HANDLER_AOP = -120;

    /**
     * 结果包装的aop
     */
    int WRAPPER_AOP = -110;


    /**
     * 业务日志的AOP
     */
    int BUSINESS_LOG_AOP = 100;

}
