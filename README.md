<h1 align="center"><a href="https://github.com/rubywooJ/beyond" style="text-decoration:none">Beyond</a></h1>

> Beyond 博客是一款由 Java 语言编写的个人博客系统。

![LICENSE](https://img.shields.io/badge/dynamic/json?color=yellow&label=LICENSE&query=license.spdx_id&url=https%3A%2F%2Fapi.github.com%2Frepos%2FrubywooJ%2Fbeyond?style=flat-square) ![LATEST](https://img.shields.io/github/v/release/rubywooJ/beyond?style=flat-square)


## 简介

Beyond 博客，致力于打造一款**部署简单**且**可配置**的 Java 博客系统。

## 技术栈

- Spring Boot
- Mybatis
- PageHelper
- Freemarker

## 快速开始

#### 第一步

配置 Java 环境

#### 第二步

下载 Beyond 运行包

- GitHub Release: [https://github.com/rubywooJ/beyond/releases](https://github.com/rubywooJ/beyond/releases)

Linux环境下载：二选其一

```shell
# curl
curl -L https://github.com/rubywooJ/beyond/releases/download/v1.4.0-release-edition/beyond-v1.4.0-release-edition.jar --output beyond-latest.jar

# wget
wget https://github.com/rubywooJ/beyond/releases/download/v1.4.0-release-edition/beyond-v1.4.0-release-edition.jar -O beyond-latest.jar
```

#### 第三步

- Windows 环境，打开CMD，切换到 Beyond 运行包所在目录

```shell
java -jar beyond-latest.jar
```

- Linux 环境，切换到 Beyond 运行包所在目录

```shell
java -jar beond-latest.jar
```
你也可以配置后台运行

```shell
nohup java -jar beyond-latest.jar >/dev/null  2>&1 &^C
```

#### 第四步

打开浏览器地址栏输入 [http://localhost:8080](http://localhost:8080)

## 联系

QQ：2362882118

Email： i520gfy@gmail.com
