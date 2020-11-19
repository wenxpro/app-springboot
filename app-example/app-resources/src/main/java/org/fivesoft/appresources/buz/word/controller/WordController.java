package org.fivesoft.appresources.buz.word.controller;

import io.swagger.annotations.ApiOperation;
import org.fivesoft.appresources.buz.word.dto.WordDto;
import org.fivesoft.appresources.buz.word.service.WordService;
import org.fivesoft.pojo.response.ResponseData;
import org.fivesoft.pojo.response.SuccessResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 分词词库controller
 * @author wenx
 * @date 2020-11-12
 */
@RestController
public class WordController {

    @Resource
    WordService wordService;


    @ApiOperation(value = "word 分页")
    @GetMapping("/api/word/page")
    public ResponseData page(@Validated @RequestBody WordDto dto) {
        return new SuccessResponseData(wordService.page(dto));
    }

    @ApiOperation(value = "word 添加")
    @PostMapping("/api/word/add")
    public ResponseData add(@Validated(WordDto.add.class) @RequestBody WordDto dto) {
        wordService.add(dto);
        return new SuccessResponseData();
    }


    @ApiOperation(value = "word 修改")
    @PutMapping("/api/word/edit")
    public ResponseData edit(@Validated(WordDto.edit.class) @RequestBody WordDto dto) {
        wordService.edit(dto);
        return new SuccessResponseData();
    }

    @ApiOperation(value = "word 删除")
    @DeleteMapping("/api/word/delete")
    public ResponseData delete(@Validated(WordDto.delete.class) @RequestBody WordDto dto) {
        wordService.delete(dto);
        return new SuccessResponseData();
    }




}
