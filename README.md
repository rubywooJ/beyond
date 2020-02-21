# Beyond Blog

> 基于Spring Boot v2.1.6的 Java 开源博客

![https://img.shields.io/badge/JDK-1.8-yellow.svg?style=flat-square](https://img.shields.io/badge/JDK-1.8-yellow.svg?style=flat-square)

## 快速开始

请确保本地环境具有

- jdk1.8+ 
- maven 3.3+
- mysql 5.7+

之后运行以下命令

```shell
# 下载代码
git clone git@github.com:feiyangbeyond/beyond.git beyond

cd beyond

# 请先修改 application.yml 文件中的 mysql数据库连接地址用户名密码后运行该命令
mvn clean package -Dmaven.test.skip=true

# 看到success字样无报错后
cd target

java -jar beyond-xxxx.jar
```

