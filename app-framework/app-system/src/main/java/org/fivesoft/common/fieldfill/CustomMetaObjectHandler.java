package org.fivesoft.common.fieldfill;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectionException;
import org.fivesoft.enums.CommonStatusEnum;

import java.util.Date;

/**
 * 自定义sql字段填充器，自动填充创建修改相关字段
 *
 * @author xuyuxiang
 * @date 2020/3/30 15:21
 */
public class CustomMetaObjectHandler implements MetaObjectHandler {

    private static final Log log = Log.get();

    private static final String CREATE_USER = "createUser";

    private static final String CREATE_TIME = "createDate";

    private static final String UPDATE_USER = "updateUser";

    private static final String UPDATE_TIME = "updateDate";
    private static final String STATUS = "status";

    @Override
    public void insertFill(MetaObject metaObject) {
        try {
            //设置createUser（BaseEntity)
//            setFieldValByName(CREATE_USER, this.getUserUniqueId(), metaObject);

            //设置createTime（BaseEntity)
            setFieldValByName(CREATE_TIME, new Date(), metaObject);
            setFieldValByName(STATUS, CommonStatusEnum.ENABLE.getCode(),metaObject);
        } catch (ReflectionException e) {
            log.warn(">>> CustomMetaObjectHandler处理过程中无相关字段，不做处理");
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        try {
            //设置updateUser（BaseEntity)
//            setFieldValByName(UPDATE_USER, this.getUserUniqueId(), metaObject);
            //设置updateTime（BaseEntity)
            setFieldValByName(UPDATE_TIME, new Date(), metaObject);
        } catch (ReflectionException e) {
            log.warn(">>> CustomMetaObjectHandler处理过程中无相关字段，不做处理");
        }
    }
}