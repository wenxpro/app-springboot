####项目介绍
最近研究了下guns，感觉规范性强，抽象能力好，强烈推荐大家一起学习，前后端分离版本传送门 https://gitee.com/stylefeng/guns-separation
这个版本基于SpringBoot, 整合springmvc + springsecurity+ mybatis-plus，包含了用户、授权、租户、机构、应用等众多模块，感真实的开发中可能很多模块用不到，所以想着讲权限与业务剥离，拆分成不需要认证和需要认证的两个部分，简单的分了下，也对这个有了更多的理解和认识
####结构说明
![image.png](https://upload-images.jianshu.io/upload_images/6380064-2b072d92ccd19822.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
- app-core 原有的core结构不变，保留大部分常量与通用实体，
- app-system 将原有的system 拆分为 auth 和 system 两个部分，可以直接引用system，不需要认证
- app-auth 为拆分出来的认证模块，引用后添加sys_user，默认用户为admin 123456，拿到token后携带可进行请求认证
- app-resources 为只引用了system的示例服务，不需要认证就可以使用
![image.png](https://upload-images.jianshu.io/upload_images/6380064-0db2d67c306f6e93.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

- app-grant 为引用了auth的示例服务，所有需要认证，可以在secrurity常量中添加绕过认证的请求
![image.png](https://upload-images.jianshu.io/upload_images/6380064-857c74402e0c4103.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/6380064-9a5045b7fa33f287.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/6380064-ab7e4d1ea9699b82.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

####其他说明
- 更改了导出easypoi为easy-excel
- 更改了注解型日志异步记录为普通的aop环绕通知
- 另外项目的 cache 和 token 默认存储都在内存中，redis需要额外进行拓展

##### 打包
```
mvn package -Dmaven.test.skip=true
```
##### 验证
```
curl -X GET "http://localhost:8080/api/test"
```
