package org.fivesoft.appresources.buz.word.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.fivesoft.pojo.base.param.BaseDto;

/**
 * 分词传参 dto
 * @author wenx
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordDto extends BaseDto {

    private Long id;

    private String content;
}
