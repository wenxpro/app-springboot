/*
Copyright [2020] [https://www.stylefeng.cn]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Guns采用APACHE LICENSE 2.0开源协议，您在使用过程中，需要注意以下几点：

1.请不要删除和修改根目录下的LICENSE文件。
2.请不要删除和修改Guns源码头部的版权声明。
3.请保留源码和相关描述文件的项目出处，作者声明等。
4.分发源码时候，请注明软件出处 https://gitee.com/stylefeng/guns-separation
5.在修改包名，模块名称，项目代码等时，请注明软件出处 https://gitee.com/stylefeng/guns-separation
6.若您的项目无法满足以上几点，可申请商业授权，获取Guns商业授权许可，请在官网购买授权，地址为 https://www.stylefeng.cn
 */
package org.fivesoft.modular.role.controller;

import org.fivesoft.common.annotion.DataScope;
import org.fivesoft.common.annotion.Permission;
import org.fivesoft.modular.role.param.SysRoleParam;
import org.fivesoft.modular.role.service.SysRoleService;
import org.fivesoft.pojo.response.ResponseData;
import org.fivesoft.pojo.response.SuccessResponseData;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 系统角色控制器
 *
 * @author xuyuxiang
 * @date 2020/3/20 19:42
 */
@RestController
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    /**
     * 查询系统角色
     *
     * @author xuyuxiang
     * @date 2020/3/28 14:45
     */
    @Permission
    @GetMapping("/sysRole/page")
    public ResponseData page(SysRoleParam sysRoleParam) {
        return new SuccessResponseData(sysRoleService.page(sysRoleParam));
    }

    /**
     * 系统角色下拉（用于授权角色时选择）
     *
     * @author xuyuxiang
     * @date 2020/4/5 16:45
     */
    @Permission
    @GetMapping("/sysRole/dropDown")
    public ResponseData dropDown() {
        return new SuccessResponseData(sysRoleService.dropDown());
    }

    /**
     * 添加系统角色
     *
     * @author xuyuxiang
     * @date 2020/3/28 14:45
     */
    @Permission
    @PostMapping("/sysRole/add")
    public ResponseData add(@RequestBody @Validated(SysRoleParam.add.class) SysRoleParam sysRoleParam) {
        sysRoleService.add(sysRoleParam);
        return new SuccessResponseData();
    }

    /**
     * 删除系统角色
     *
     * @author xuyuxiang
     * @date 2020/3/28 14:45
     */
    @Permission
    @PostMapping("/sysRole/delete")
    public ResponseData delete(@RequestBody @Validated(SysRoleParam.delete.class) SysRoleParam sysRoleParam) {
        sysRoleService.delete(sysRoleParam);
        return new SuccessResponseData();
    }

    /**
     * 编辑系统角色
     *
     * @author xuyuxiang
     * @date 2020/3/28 14:46
     */
    @Permission
    @PostMapping("/sysRole/edit")
    public ResponseData edit(@RequestBody @Validated(SysRoleParam.edit.class) SysRoleParam sysRoleParam) {
        sysRoleService.edit(sysRoleParam);
        return new SuccessResponseData();
    }

    /**
     * 查看系统角色
     *
     * @author xuyuxiang
     * @date 2020/3/28 14:46
     */
    @Permission
    @GetMapping("/sysRole/detail")
    public ResponseData detail(@Validated(SysRoleParam.detail.class) SysRoleParam sysRoleParam) {
        return new SuccessResponseData(sysRoleService.detail(sysRoleParam));
    }

    /**
     * 授权菜单
     *
     * @author xuyuxiang
     * @date 2020/3/28 16:05
     */
    @Permission
    @PostMapping("/sysRole/grantMenu")
    public ResponseData grantMenu(@RequestBody @Validated(SysRoleParam.grantMenu.class) SysRoleParam sysRoleParam) {
        sysRoleService.grantMenu(sysRoleParam);
        return new SuccessResponseData();
    }

    /**
     * 授权数据
     *
     * @author xuyuxiang
     * @date 2020/3/28 16:05
     */
    @Permission
    @DataScope
    @PostMapping("/sysRole/grantData")
    public ResponseData grantData(@RequestBody @Validated(SysRoleParam.grantData.class) SysRoleParam sysRoleParam) {
        sysRoleService.grantData(sysRoleParam);
        return new SuccessResponseData();
    }

    /**
     * 拥有数据
     *
     * @author xuyuxiang
     * @date 2020/3/28 14:46
     */
    @Permission
    @GetMapping("/sysRole/ownData")
    public ResponseData ownData(@Validated(SysRoleParam.detail.class) SysRoleParam sysRoleParam) {
        return new SuccessResponseData(sysRoleService.ownData(sysRoleParam));
    }

}
