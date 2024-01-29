# WarmUp考核



**开发语言**：Java

**数据库**：MySQL

**服务器**：阿里云ESC

**技术栈**：

* SpringBoot 框架（Web等）
* Mybatis-Plus 

```shel
─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─teamtwo
│  │  │          └─warmup
│  │  │              ├─config
│  │  │              ├─controller
│  │  │              ├─dto
│  │  │              ├─exception
│  │  │              ├─handler
│  │  │              ├─mapper
│  │  │              ├─pojo
│  │  │              ├─service
│  │  │              │  └─Impl
│  │  │              └─utils
│  │  └─resources
│  │      ├─mybatis
│  │      │  └─mapper
│  │      ├─static
│  │      └─templates
│  └─test
│      └─java
│          └─com
│              └─teamtwo
│                  └─warmup
```





[接口文档](https://apifox.com/apidoc/shared-9813ef44-3bb6-4c80-8df2-12397ed0ec25)

**项目概述：**

完成了一些简单的接口，使用Docker容器在ESC上部署项目，使用token进行安全认证，后续的寒假考核会尝试使用springsecurity等安全框架进行整合，也会尝试使用Redis中间件来提高效率



项目不足：

* 没有使用全局异常处理，寒假会尝试
* 里面的web拦截器被我注释掉了，没有和前端同学商量好要拦截的请求，寒假会注意的





