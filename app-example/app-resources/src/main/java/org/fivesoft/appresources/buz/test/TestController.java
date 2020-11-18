package org.fivesoft.appresources.buz.test;

import com.chinasoftinc.pojo.response.ResponseData;
import com.chinasoftinc.pojo.response.SuccessResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一个示例接口
 * @author wenx
 * @date 2020-11-12
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @ApiOperation(value = "test接口")
    @GetMapping("/test")
    public ResponseData test() {
        return new SuccessResponseData();
    }

}
