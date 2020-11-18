package org.fivesoft.context.group;

/**
 * 临时保存参数id字段值，用于唯一性校验
 *
 * @author stylefeng
 * @date 2020/6/21 20:17
 */
public class RequestParamIdContext {

    private static final ThreadLocal<Long> PARAM_ID_HOLDER = new ThreadLocal<>();

    /**
     * 设置id
     *
     * @author stylefeng
     * @date 2020/6/21 20:17
     */
    public static void set(Long id) {
        PARAM_ID_HOLDER.set(id);
    }

    /**
     * 获取id
     *
     * @author stylefeng
     * @date 2020/6/21 20:17
     */
    public static Long get() {
        return PARAM_ID_HOLDER.get();
    }

    /**
     * 清除缓存id
     *
     * @author stylefeng
     * @date 2020/6/21 20:17
     */
    public static void clear() {
        PARAM_ID_HOLDER.remove();
    }

}
