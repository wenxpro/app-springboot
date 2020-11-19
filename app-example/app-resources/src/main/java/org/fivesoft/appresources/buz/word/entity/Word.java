package org.fivesoft.appresources.buz.word.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fivesoft.pojo.base.entity.BaseEntity;

/**
 * @author wenx
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("w_word")
public class Word extends BaseEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String content;

}
