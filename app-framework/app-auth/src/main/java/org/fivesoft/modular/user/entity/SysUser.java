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
package org.fivesoft.modular.user.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.fivesoft.pojo.base.entity.BaseEntity;

import java.util.Date;

/**
 * 系统用户表
 *
 * @author xuyuxiang
 * @date 2020/3/5 12:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_user")
public class SysUser extends BaseEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 账号
     */
    @ExcelProperty(value = "账号")
    @ColumnWidth(20)
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    @ExcelProperty(value = "昵称")
    @ColumnWidth(20)
    private String nickName;

    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名")
    @ColumnWidth(20)
    private String name;

    /**
     * 头像
     */
    private Long avatar;

    /**
     * 生日
     */
    @ExcelProperty(value = "生日", format = "yyyy-MM-dd HH:mm:ss")
    @ColumnWidth(20)
    private Date birthday;

    /**
     * 性别(字典 1男 2女 3未知)
     */
    @ExcelProperty(value = "性别")
    @ColumnWidth(20)
    private Integer sex;

    /**
     * 邮箱
     */
    @ExcelProperty(value = "邮箱")
    @ColumnWidth(20)
    private String email;

    /**
     * 手机
     */
    @ExcelProperty(value = "手机")
    @ColumnWidth(30)
    private String phone;

    /**
     * 电话
     */
    @ExcelProperty(value = "电话")
    @ColumnWidth(30)
    private String tel;

    /**
     * 最后登陆IP
     */
    @ExcelProperty(value = "最后登陆IP")
    @ColumnWidth(30)
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    @ExcelProperty(value = "最后登陆时间", format = "yyyy-MM-dd HH:mm:ss")
    @ColumnWidth(30)
    private Date lastLoginTime;

    /**
     * 管理员类型（1超级管理员 2非管理员）
     */
    @ExcelProperty(value = "管理员类型")
    @ColumnWidth(20)
    private Integer adminType;

    /**
     * 状态（字典 0正常 1停用 2删除）
     */
    @ExcelProperty(value = "状态")
    @ColumnWidth(20)
    private Integer status;


}
