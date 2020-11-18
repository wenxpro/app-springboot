package org.fivesoft.validation.unique;


import com.chinasoftinc.context.group.RequestGroupContext;
import com.chinasoftinc.context.group.RequestParamIdContext;
import com.chinasoftinc.context.system.SystemContextHolder;
import com.chinasoftinc.pojo.base.param.BaseDto;
import com.chinasoftinc.pojo.base.validate.UniqueValidateParam;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 验证表的的某个字段值是否在是唯一值
 *
 * @author stylefeng
 * @date 2020/4/14 23:49
 */
public class TableUniqueValueValidator implements ConstraintValidator<TableUniqueValue, String> {

    private String tableName;

    private String columnName;

    private boolean excludeLogicDeleteItems;

    private String logicDeleteFieldName;

    private String logicDeleteValue;

    @Override
    public void initialize(TableUniqueValue constraintAnnotation) {
        this.tableName = constraintAnnotation.tableName();
        this.columnName = constraintAnnotation.columnName();
        this.excludeLogicDeleteItems = constraintAnnotation.excludeLogicDeleteItems();
        this.logicDeleteFieldName = constraintAnnotation.logicDeleteFieldName();
        this.logicDeleteValue = constraintAnnotation.logicDeleteValue();
    }

    @Override
    public boolean isValid(String fieldValue, ConstraintValidatorContext context) {
        Class<?> validateGroupClass = RequestGroupContext.get();

        // 如果属于add group，则校验库中所有行
        if (BaseDto.add.class.equals(validateGroupClass)) {
            return SystemContextHolder.me().tableUniValueFlag(createAddParam(fieldValue));
        }

        // 如果属于edit group，校验时需要排除当前修改的这条记录
        if (BaseDto.edit.class.equals(validateGroupClass)) {
            return SystemContextHolder.me().tableUniValueFlag(createEditParam(fieldValue));
        }

        // 默认校验所有的行
        return SystemContextHolder.me().tableUniValueFlag(createAddParam(fieldValue));
    }

    /**
     * 创建校验新增的参数
     *
     * @author fengshuonan
     * @date 2020/8/17 21:55
     */
    private UniqueValidateParam createAddParam(String fieldValue) {
        return UniqueValidateParam.builder()
                .tableName(tableName)
                .columnName(columnName)
                .value(fieldValue)
                .excludeCurrentRecord(Boolean.FALSE)
                .excludeLogicDeleteItems(excludeLogicDeleteItems)
                .logicDeleteFieldName(logicDeleteFieldName)
                .logicDeleteValue(logicDeleteValue).build();
    }

    /**
     * 创建修改的参数校验
     *
     * @author fengshuonan
     * @date 2020/8/17 21:56
     */
    private UniqueValidateParam createEditParam(String fieldValue) {
        return UniqueValidateParam.builder()
                .tableName(tableName)
                .columnName(columnName)
                .value(fieldValue)
                .excludeCurrentRecord(Boolean.TRUE)
                .id(RequestParamIdContext.get())
                .excludeLogicDeleteItems(excludeLogicDeleteItems)
                .logicDeleteFieldName(logicDeleteFieldName)
                .logicDeleteValue(logicDeleteValue).build();
    }

}
