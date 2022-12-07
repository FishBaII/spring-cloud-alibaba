# 工程简介
此项目作为nacos config测试

### 引入依赖

```
<dependency>
    <groupId>com.alibaba.cloud</groupId>
    <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
</dependency>
```

### 添加配置文件
添加配置文件bootstrap.yml说明nacos config地址
```
spring:
  profiles:
    active: dev
  # 环境配置
  application:
    name: config-service
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848
      config:
        server-addr: 127.0.0.1:8848
        file-extension: yaml
```


### nacos添加配置
打开nacos管理台，配置管理->配置列表->创建配置，进行写入并发布  
其中Data ID命名必须按照${spring.application.name}-${profile}.${file-extension:properties}格式  
以上变量全部由bootstrap.yml提供，本项目Data ID为config-service-dev.yaml

以下为本人测试插入的nacos config
```
config:
  info: this is config-service
  version: 0.0.2
```

### 配置刷新

使用 **@RefreshScope**注解可动态刷新nacos config，程序以获取最新的配置

### 其他
初次启动遇到无法找到对应nacos config的问题，重启nacos服务解决，原因暂不明。