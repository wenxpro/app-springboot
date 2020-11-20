package org.fivesoft.appgrant.test;

import io.swagger.annotations.ApiOperation;
import org.fivesoft.appgrant.test.service.TestService;
import org.fivesoft.pojo.response.ResponseData;
import org.fivesoft.pojo.response.SuccessResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一个示例接口
 *
 * @author wenx
 * @date 2020-11-12
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    TestService testService;

    @ApiOperation(value = "test不需要权限接口")
    @GetMapping("/test")
    public ResponseData test() {
        return new SuccessResponseData();
    }

    @ApiOperation(value = "test需要权限接口")
    @GetMapping("/testPermit")
    public ResponseData testPermit() {
        testService.testPermit();
        return new SuccessResponseData();
    }


}
