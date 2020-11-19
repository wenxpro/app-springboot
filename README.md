##### 介绍
借鉴guns剥离权鉴与system的web框架，服务层可仅关心业务代码，提升业务能力
##### 打包
```
mvn package -Dmaven.test.skip=true
```
##### 验证
```
curl -X GET "http://localhost:8080/api/test"
```
