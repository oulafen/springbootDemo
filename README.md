### 启动

- 方式一
    
    启动文件右键Run
- 方式二 
    ```
    mvn spring-boot:run
    ```
- 方式三
    ```$xslt
    mvn install
    cd target
    java -jar demo-0.0.1-SNAPSHOT.jar  # 加参数可指定环境 --spring.profiles.active=prod
    ```

### 接口设计

Restful接口模拟
```$xslt
GET     /api/users      获取user列表
POST    /api/users      创建一个user
GET     /api/users/id   通过id查找一个user
PUT     /api/users/id   通过id更新一个user
DELETE  /api/users/id   通过id删除一个user
```

### 验证表单

未满16岁的不入库
```
@Min(value = 16, message = "未满16岁")
@Valid
```

### AOP

应用-添加权限验证，在进入模块之前/之后的统一操作


