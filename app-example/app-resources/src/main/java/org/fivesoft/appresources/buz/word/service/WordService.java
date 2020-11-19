package org.fivesoft.appresources.buz.word.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fivesoft.appresources.buz.word.dto.WordDto;
import org.fivesoft.appresources.buz.word.entity.Word;
import org.fivesoft.appresources.buz.word.mapper.WordMapper;
import org.fivesoft.common.page.PageResult;
import org.fivesoft.enums.CommonStatusEnum;
import org.fivesoft.factory.PageFactory;
import org.springframework.stereotype.Service;

/**
 * 分词 词库 service
 * @author wenx
 * @date 2020-11-12
 */
@Service
public class WordService extends ServiceImpl<WordMapper, Word> {

    public void add(WordDto dto){
        Word word = new Word();
        word.setContent(dto.getContent());
        word.setStatus(CommonStatusEnum.ENABLE.getCode());
        super.save(word);
    }

    public void edit(WordDto dto){
        Word word = new Word();
        word.setContent(dto.getContent());
        word.setId(dto.getId());
        super.saveOrUpdate(word);
    }

    public void delete(WordDto dto){
        Word word = new Word();
        word.setId(dto.getId());
        word.setStatus(CommonStatusEnum.DELETED.getCode());
        super.update();
    }

    public PageResult<Word> page(WordDto dto){
        LambdaQueryWrapper<Word> queryWrapper = new LambdaQueryWrapper<>();
        if (ObjectUtil.isNotNull(dto)) {
            if (ObjectUtil.isNotEmpty(dto.getId())) {
                queryWrapper.eq(Word::getId, dto.getId());
            }
            if (ObjectUtil.isNotEmpty(dto.getContent())) {
                queryWrapper.like(Word::getContent, dto.getContent());
            }
        }
        queryWrapper.orderByDesc(Word::getCreateDate);
        return new PageResult<>(this.page(PageFactory.defaultPage(), queryWrapper));
    }

}
