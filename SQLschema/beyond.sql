/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : blog

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 19/03/2020 18:20:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_article
-- ----------------------------
DROP TABLE IF EXISTS `tb_article`;
CREATE TABLE `tb_article`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT COMMENT '编号',
    `title`       varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
    `cover`       varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图片',
    `author`      varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
    `content`     mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci   NULL COMMENT '内容',
    `content_md`  mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci   NULL COMMENT '内容-Markdown',
    `origin`      varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源',
    `state`       varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态',
    `views`       bigint(20)                                              NULL DEFAULT 0,
    `edit_time`   bigint(20)                                              NOT NULL COMMENT '上次修改时间',
    `create_time` bigint(20)                                              NOT NULL COMMENT '创建时间',
    `type`        int(11)                                                 NULL DEFAULT 0 COMMENT '类型， 0原创 1转载',
    `summary`     varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摘要',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 9
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '文章表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_article
-- ----------------------------
INSERT INTO `tb_article`
VALUES (1, '世间万物皆苦，你明目张胆的偏爱就是救赎。', '/images/text02.jpg', '往事随风', '空', '空', 'https://www.tsxygfy.cn', '1', 763,
        1580477458368, 1580477458368, 0, '摘要');
INSERT INTO `tb_article`
VALUES (2, '前期追深度，否则会华而不实，后期追广度，否则会坐井观天', '/images/text02.jpg', '往事随风', '空', '空', 'https://www.tsxygfy.cn', '1', 34813,
        1580477458368, 1580477458368, 0, '摘要');
INSERT INTO `tb_article`
VALUES (4, '星河璀璨，阳光干净，在人间所有美好的存在里，不论是活着或者死去，我总是最爱你。', '/images/text02.jpg', '往事随风', '空', '空', 'https://www.tsxygfy.cn',
        '1', 2140, 1580477458368, 1580477458368, 0, '摘要');
INSERT INTO `tb_article`
VALUES (6, '银河用月色作饵，晚风为杆，想垂钓起落入你眼底的星光。', '/images/text02.jpg', '往事随风', '空', '空', 'https://www.tsxygfy.cn', '1', 1148,
        1580477458368, 1580477458368, 0, '摘要');
INSERT INTO `tb_article`
VALUES (7, 'Vue+ElementUI+SpringMVC实现图片上传和回显', '/images/text02.jpg', '往事随风', '空', '空', 'https://www.tsxygfy.cn', '1',
        2453, 1580477458368, 1580477458368, 0, '摘要');
INSERT INTO `tb_article`
VALUES (8, '我在人间凑数的日子', NULL, '往事随风', '<p>哪有那么多烂道理，觉的值得就继续</p><br/><br/>', '哪有...', NULL, '1', 72543, 1580566152068,
        1580566152068, 0, '哪有那么多烂道理，觉得值得就继续...');

-- ----------------------------
-- Table structure for tb_article_tags
-- ----------------------------
DROP TABLE IF EXISTS `tb_article_tags`;
CREATE TABLE `tb_article_tags`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
    `article_id` bigint(20) NOT NULL COMMENT '文章ID',
    `tag_id`     bigint(20) NOT NULL COMMENT '标签ID',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 613
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '文章&&标签关联表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_article_tags
-- ----------------------------
INSERT INTO `tb_article_tags`
VALUES (1, 1, 1);
INSERT INTO `tb_article_tags`
VALUES (5, 1, 4);
INSERT INTO `tb_article_tags`
VALUES (7, 4, 5);
INSERT INTO `tb_article_tags`
VALUES (8, 4, 4);
INSERT INTO `tb_article_tags`
VALUES (10, 6, 1);
INSERT INTO `tb_article_tags`
VALUES (11, 7, 5);
INSERT INTO `tb_article_tags`
VALUES (612, 2, 4);

-- ----------------------------
-- Table structure for tb_comments
-- ----------------------------
DROP TABLE IF EXISTS `tb_comments`;
CREATE TABLE `tb_comments`
(
    `id`            bigint(20)                                              NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `p_id`          bigint(20)                                              NULL DEFAULT 0 COMMENT '父级ID，给哪个留言进行回复',
    `c_id`          bigint(20)                                              NULL DEFAULT 0 COMMENT '子级ID，给哪个留言下的回复进行评论',
    `article_title` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章标题',
    `article_id`    bigint(20)                                              NULL DEFAULT NULL COMMENT '文章ID',
    `name`          varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '昵称',
    `c_name`        varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '给谁留言',
    `time`          bigint(20)                                              NOT NULL COMMENT '留言时间',
    `content`       text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '留言内容',
    `email`         varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
    `url`           varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网址',
    `type`          int(20)                                                 NULL DEFAULT 0 COMMENT '分类：0:默认，文章详情页，1:友链页，2:关于页',
    `ip`            varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT 'IP地址',
    `device`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备',
    `address`       varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 109
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '评论表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_comments
-- ----------------------------
INSERT INTO `tb_comments`
VALUES (106, 105, NULL, NULL, NULL, 'tycoding', NULL, 20190326081431, '回复你', '122@qq.com', 'https://tycoding.cn', 2,
        NULL, 'Chrome,Mac OS X', NULL);
INSERT INTO `tb_comments`
VALUES (107, 0, 0, NULL, NULL, 't2', NULL, 20190326084209, '留言', '122@qq.com', 'https://tycoding.cn', 2, '127.0.0.1',
        'Chrome,Mac OS X', '内网IP|0|0|内网IP|内网IP');
INSERT INTO `tb_comments`
VALUES (108, 0, 0, '测试heiehi', 12, 'tycoding', NULL, 20190326182831, '测试下', '1222@qq.com', 'http://tycoding.cn', 0,
        '127.0.0.1', 'Chrome,Mac OS X', '内网IP|0|0|内网IP|内网IP');

-- ----------------------------
-- Table structure for tb_info
-- ----------------------------
DROP TABLE IF EXISTS `tb_info`;
CREATE TABLE `tb_info`
(
    `id`              int(3)                                                        NOT NULL AUTO_INCREMENT,
    `birthday`        bigint(255)                                                   NULL DEFAULT NULL,
    `visited`         bigint(255)                                                   NULL DEFAULT NULL,
    `blog_title`      varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `seo_keywords`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `seo_description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_info
-- ----------------------------
INSERT INTO `tb_info`
VALUES (1, 20190716165337, 1, '往事随风', '关键字', '描述');

-- ----------------------------
-- Table structure for tb_links
-- ----------------------------
DROP TABLE IF EXISTS `tb_links`;
CREATE TABLE `tb_links`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '连接名称',
    `url`         varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '连接URL',
    `img`         varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '连接图片url',
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    `team`        varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组名',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '友链表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_links
-- ----------------------------
INSERT INTO `tb_links`
VALUES (4, 'beyond', 'https://www.tsxygfy.cn', '//q1.qlogo.cn/g?b=qq&s=100&nk=2362882118', '博主是个大帅哥', '颜值区');
INSERT INTO `tb_links`
VALUES (5, 'feiyang', 'https://www.tsxygfy.cn', '//q1.qlogo.cn/g?b=qq&s=100&nk=2362882118', '发量王者', '技术区');

-- ----------------------------
-- Table structure for tb_login_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_log`;
CREATE TABLE `tb_login_log`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT COMMENT '编号',
    `username`    varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '用户名',
    `ip`          varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT 'IP地址',
    `location`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录地点',
    `create_time` bigint(20)                                              NULL DEFAULT NULL COMMENT '登录时间',
    `device`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录设备',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 37
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_setting
-- ----------------------------
DROP TABLE IF EXISTS `tb_setting`;
CREATE TABLE `tb_setting`
(
    `id`            int(11)                                                 NOT NULL AUTO_INCREMENT,
    `site_name`     varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站名称',
    `site_links`    text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '社交链接，JSON格式',
    `site_donation` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '捐赠，微信、支付宝收款图片，JSON格式',
    `site_music`    varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '音乐ID',
    `about`         text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '关于我，HTML格式',
    `about_md`      text CHARACTER SET utf8 COLLATE utf8_general_ci         NULL COMMENT '关于我，Markdown格式',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_setting
-- ----------------------------
INSERT INTO `tb_setting`
VALUES (1, 'Beyond\'s blog', '[{\"key\": \"Github\", value: \"https://github.com/feiyangbeyond\"}]',
        '[{\"key\":\"支付宝\",\"value\":\"/site/images/alipay.png\"},{\"key\":\"微信支付\",\"value\":\"/site/images/wechat.png\"}]',
        '453843751',
        '<hr>\r\n<h2 id=\"h2-u672Cu4EBA\"><a name=\"本人\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>本人</h2><p>2017届大一在读</p>\r\n<p>技术很差劲、算法很差劲、数据结构很差劲</p>\r\n<p>目前一直在自学中，大一就过上了泡实验室的日子</p>\r\n<p>……（此处省略很多很多）</p>\r\n<p>希望有一天能改变这种现态吧！</p>\r\n<p>致此</p>\r\n<p>加油！</p>\r\n<hr>\r\n<h2 id=\"h2-u4EA4u6D41\"><a name=\"交流\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>交流</h2><p>如果大家有兴趣，欢迎大家加入我的QQ：2362882118 ，一起交流学习Java技术。本人一直在自学java，目前技术有限，但如果可以的话会尽力帮助大家，希望能和大家共同进步。所以，快来加入我们吧！</p>\r\n<p><br/></p>\r\n<h2 id=\"h2-u8054u7CFB\"><a name=\"联系\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>联系</h2><p>If you have some questions after you see this article, you can contact me or you can find some info by clicking these links.</p>\r\n<ul>\r\n<li><a href=\"http://www.tsxygfy.cn\"\">Blog&#64;Beyond’s blog</a></li></ul>\r\n<h2 id=\"h2-u672Cu4EBA\"><a name=\"本人\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>本人</h2><p>2017届大一在读</p>\r\n<p>技术很差劲、算法很差劲、数据结构很差劲</p>\r\n<p>目前一直在自学中，大一就过上了泡实验室的日子</p>\r\n<p>……（此处省略很多很多）</p>\r\n<p>希望有一天能改变这种现态吧！</p>\r\n<p>致此</p>\r\n<p>加油！</p>\r\n<hr>\r\n<h2 id=\"h2-u4EA4u6D41\"><a name=\"交流\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>交流</h2><p>如果大家有兴趣，欢迎大家加入我的QQ：2362882118 ，一起交流学习Java技术。本人一直在自学java，目前技术有限，但如果可以的话会尽力帮助大家，希望能和大家共同进步。所以，快来加入我们吧！</p>\r\n<p><br/></p>\r\n<h2 id=\"h2-u8054u7CFB\"><a name=\"联系\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>联系</h2><p>If you have some questions after you see this article, you can contact me or you can find some info by clicking these links.</p>\r\n<ul>\r\n<li><a href=\"http://www.tsxygfy.cn\"\">Blog&#64;Beyond’s blog</a></li></ul>\r\n<hr>\r\n<h2 id=\"h2-u672Cu4EBA\"><a name=\"本人\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>本人</h2><p>2017届大一在读</p>\r\n<p>技术很差劲、算法很差劲、数据结构很差劲</p>\r\n<p>目前一直在自学中，大一就过上了泡实验室的日子</p>\r\n<p>……（此处省略很多很多）</p>\r\n<p>希望有一天能改变这种现态吧！</p>\r\n<p>致此</p>\r\n<p>加油！</p>\r\n<hr>\r\n<h2 id=\"h2-u4EA4u6D41\"><a name=\"交流\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>交流</h2><p>如果大家有兴趣，欢迎大家加入我的QQ：2362882118 ，一起交流学习Java技术。本人一直在自学java，目前技术有限，但如果可以的话会尽力帮助大家，希望能和大家共同进步。所以，快来加入我们吧！</p>\r\n<p><br/></p>\r\n<h2 id=\"h2-u8054u7CFB\"><a name=\"联系\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>联系</h2><p>If you have some questions after you see this article, you can contact me or you can find some info by clicking these links.</p>\r\n<ul>\r\n<li><a href=\"http://www.tsxygfy.cn\"\">Blog&#64;Beyond’s blog</a></li></ul>\r\n<hr>\r\n<h2 id=\"h2-u672Cu4EBA\"><a name=\"本人\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>本人</h2><p>2017届大一在读</p>\r\n<p>技术很差劲、算法很差劲、数据结构很差劲</p>\r\n<p>目前一直在自学中，大一就过上了泡实验室的日子</p>\r\n<p>……（此处省略很多很多）</p>\r\n<p>希望有一天能改变这种现态吧！</p>\r\n<p>致此</p>\r\n<p>加油！</p>\r\n<hr>\r\n<h2 id=\"h2-u4EA4u6D41\"><a name=\"交流\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>交流</h2><p>如果大家有兴趣，欢迎大家加入我的QQ：2362882118 ，一起交流学习Java技术。本人一直在自学java，目前技术有限，但如果可以的话会尽力帮助大家，希望能和大家共同进步。所以，快来加入我们吧！</p>\r\n<p><br/></p>\r\n<h2 id=\"h2-u8054u7CFB\"><a name=\"联系\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>联系</h2><p>If you have some questions after you see this article, you can contact me or you can find some info by clicking these links.</p>\r\n<ul>\r\n<li><a href=\"http://www.tsxygfy.cn\"\">Blog&#64;Beyond’s blog</a></li></ul>\r\n<hr>\r\n<h2 id=\"h2-u672Cu4EBA\"><a name=\"本人\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>本人</h2><p>2017届大一在读</p>\r\n<p>技术很差劲、算法很差劲、数据结构很差劲</p>\r\n<p>目前一直在自学中，大一就过上了泡实验室的日子</p>\r\n<p>……（此处省略很多很多）</p>\r\n<p>希望有一天能改变这种现态吧！</p>\r\n<p>致此</p>\r\n<p>加油！</p>\r\n<hr>\r\n<h2 id=\"h2-u4EA4u6D41\"><a name=\"交流\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>交流</h2><p>如果大家有兴趣，欢迎大家加入我的QQ：2362882118 ，一起交流学习Java技术。本人一直在自学java，目前技术有限，但如果可以的话会尽力帮助大家，希望能和大家共同进步。所以，快来加入我们吧！</p>\r\n<p><br/></p>\r\n<h2 id=\"h2-u8054u7CFB\"><a name=\"联系\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>联系</h2><p>If you have some questions after you see this article, you can contact me or you can find some info by clicking these links.</p>\r\n<ul>\r\n<li><a href=\"http://www.tsxygfy.cn\"\">Blog&#64;Beyond’s blog</a></li></ul>\r\n<hr>\r\n<h2 id=\"h2-u672Cu4EBA\"><a name=\"本人\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>本人</h2><p>2017届大一在读</p>\r\n<p>技术很差劲、算法很差劲、数据结构很差劲</p>\r\n<p>目前一直在自学中，大一就过上了泡实验室的日子</p>\r\n<p>……（此处省略很多很多）</p>\r\n<p>希望有一天能改变这种现态吧！</p>\r\n<p>致此</p>\r\n<p>加油！</p>\r\n<hr>\r\n<h2 id=\"h2-u4EA4u6D41\"><a name=\"交流\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>交流</h2><p>如果大家有兴趣，欢迎大家加入我的QQ：2362882118 ，一起交流学习Java技术。本人一直在自学java，目前技术有限，但如果可以的话会尽力帮助大家，希望能和大家共同进步。所以，快来加入我们吧！</p>\r\n<p><br/></p>\r\n<h2 id=\"h2-u8054u7CFB\"><a name=\"联系\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>联系</h2><p>If you have some questions after you see this article, you can contact me or you can find some info by clicking these links.</p>\r\n<ul>\r\n<li><a href=\"http://www.tsxygfy.cn\"\">Blog&#64;Beyond’s blog</a></li></ul>\r\n<hr>\r\n<h2 id=\"h2-u672Cu4EBA\"><a name=\"本人\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>本人</h2><p>2017届大一在读</p>\r\n<p>技术很差劲、算法很差劲、数据结构很差劲</p>\r\n<p>目前一直在自学中，大一就过上了泡实验室的日子</p>\r\n<p>……（此处省略很多很多）</p>\r\n<p>希望有一天能改变这种现态吧！</p>\r\n<p>致此</p>\r\n<p>加油！</p>\r\n<hr>\r\n<h2 id=\"h2-u4EA4u6D41\"><a name=\"交流\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>交流</h2><p>如果大家有兴趣，欢迎大家加入我的QQ：2362882118 ，一起交流学习Java技术。本人一直在自学java，目前技术有限，但如果可以的话会尽力帮助大家，希望能和大家共同进步。所以，快来加入我们吧！</p>\r\n<p><br/></p>\r\n<h2 id=\"h2-u8054u7CFB\"><a name=\"联系\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>联系</h2><p>If you have some questions after you see this article, you can contact me or you can find some info by clicking these links.</p>\r\n<ul>\r\n<li><a href=\"http://www.tsxygfy.cn\"\">Blog&#64;Beyond’s blog</a></li></ul>\r\n<hr>\r\n<h2 id=\"h2-u672Cu4EBA\"><a name=\"本人\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>本人</h2><p>2017届大一在读</p>\r\n<p>技术很差劲、算法很差劲、数据结构很差劲</p>\r\n<p>目前一直在自学中，大一就过上了泡实验室的日子</p>\r\n<p>……（此处省略很多很多）</p>\r\n<p>希望有一天能改变这种现态吧！</p>\r\n<p>致此</p>\r\n<p>加油！</p>\r\n<hr>\r\n<h2 id=\"h2-u4EA4u6D41\"><a name=\"交流\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>交流</h2><p>如果大家有兴趣，欢迎大家加入我的QQ：2362882118 ，一起交流学习Java技术。本人一直在自学java，目前技术有限，但如果可以的话会尽力帮助大家，希望能和大家共同进步。所以，快来加入我们吧！</p>\r\n<p><br/></p>\r\n<h2 id=\"h2-u8054u7CFB\"><a name=\"联系\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>联系</h2><p>If you have some questions after you see this article, you can contact me or you can find some info by clicking these links.</p>\r\n<ul>\r\n<li><a href=\"http://www.tsxygfy.cn\"\">Blog&#64;Beyond’s blog</a></li></ul><hr>\r\n<h2 id=\"h2-u672Cu4EBA\"><a name=\"本人\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>本人</h2><p>2017届大一在读</p>\r\n<p>技术很差劲、算法很差劲、数据结构很差劲</p>\r\n<p>目前一直在自学中，大一就过上了泡实验室的日子</p>\r\n<p>……（此处省略很多很多）</p>\r\n<p>希望有一天能改变这种现态吧！</p>\r\n<p>致此</p>\r\n<p>加油！</p>\r\n<hr>\r\n<h2 id=\"h2-u4EA4u6D41\"><a name=\"交流\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>交流</h2><p>如果大家有兴趣，欢迎大家加入我的QQ：2362882118 ，一起交流学习Java技术。本人一直在自学java，目前技术有限，但如果可以的话会尽力帮助大家，希望能和大家共同进步。所以，快来加入我们吧！</p>\r\n<p><br/></p>\r\n<h2 id=\"h2-u8054u7CFB\"><a name=\"联系\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>联系</h2><p>If you have some questions after you see this article, you can contact me or you can find some info by clicking these links.</p>\r\n<ul>\r\n<li><a href=\"http://www.tsxygfy.cn\"\">Blog&#64;Beyond’s blog</a></li></ul>\r\n<hr>\r\n<h2 id=\"h2-u672Cu4EBA\"><a name=\"本人\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>本人</h2><p>2017届大一在读</p>\r\n<p>技术很差劲、算法很差劲、数据结构很差劲</p>\r\n<p>目前一直在自学中，大一就过上了泡实验室的日子</p>\r\n<p>……（此处省略很多很多）</p>\r\n<p>希望有一天能改变这种现态吧！</p>\r\n<p>致此</p>\r\n<p>加油！</p>\r\n<hr>\r\n<h2 id=\"h2-u4EA4u6D41\"><a name=\"交流\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>交流</h2><p>如果大家有兴趣，欢迎大家加入我的QQ：2362882118 ，一起交流学习Java技术。本人一直在自学java，目前技术有限，但如果可以的话会尽力帮助大家，希望能和大家共同进步。所以，快来加入我们吧！</p>\r\n<p><br/></p>\r\n<h2 id=\"h2-u8054u7CFB\"><a name=\"联系\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>联系</h2><p>If you have some questions after you see this article, you can contact me or you can find some info by clicking these links.</p>\r\n<ul>\r\n<li><a href=\"http://www.tsxygfy.cn\"\">Blog&#64;Beyond’s blog</a></li></ul>\r\n<hr>\r\n<h2 id=\"h2-u672Cu4EBA\"><a name=\"本人\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>本人</h2><p>2017届大一在读</p>\r\n<p>技术很差劲、算法很差劲、数据结构很差劲</p>\r\n<p>目前一直在自学中</P>\r\n<p>……（此处省略很多很多）</p>\r\n<p>希望有一天能改变这种现态吧！</p>\r\n<p>致此</p>\r\n<p>加油！</p>\r\n<hr>\r\n<h2 id=\"h2-u4EA4u6D41\"><a name=\"交流\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>交流</h2><p>如果大家有兴趣，欢迎大家加入我的QQ：2362882118 ，一起交流学习Java技术。本人一直在自学java，目前技术有限，但如果可以的话会尽力帮助大家，希望能和大家共同进步。所以，快来加入我们吧！</p>\r\n<p><br/></p>\r\n<h2 id=\"h2-u8054u7CFB\"><a name=\"联系\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>联系</h2><p>If you have some questions after you see this article, you can contact me or you can find some info by clicking these links.</p>\r\n<ul>\r\n<li><a href=\"http://www.tsxygfy.cn\"\">Blog&#64;Beyond’s blog</a></li></ul>\r\n',
        '\r\n---\r\n\r\n## 本人\r\n\r\n2017届大一在读\r\n\r\n技术很差劲、算法很差劲、数据结构很差劲\r\n\r\n目前一直在自学中\r\n\r\n......（此处省略很多很多）\r\n\r\n希望有一天能改变这种现态吧！\r\n\r\n致此\r\n\r\n加油！\r\n\r\n----------\r\n\r\n## 交流\r\n\r\n如果大家有兴趣，欢迎大家加入我的QQ：2362882118 ，一起交流学习Java技术。本人一直在自学java，目前技术有限，但如果可以的话会尽力帮助大家，希望能和大家共同进步。所以，快来加入我们吧！\r\n\r\n<br/>\r\n\r\n## 联系\r\n\r\nIf you have some questions after you see this article, you can contact me or you can find some info by clicking these links.\r\n\r\n- [Blog@Beyond\'s blog](http://www.tsxygfy.cn)\r\n- [GitHub@Beyond](https://github.com/feiyangbeyond)');

-- ----------------------------
-- Table structure for tb_system_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_system_log`;
CREATE TABLE `tb_system_log`
(
    `id`          bigint(20)                                              NOT NULL AUTO_INCREMENT COMMENT '编号',
    `username`    varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '操作用户',
    `operation`   varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '操作描述',
    `time`        bigint(20)                                              NULL DEFAULT NULL COMMENT '耗时(毫秒)',
    `method`      varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方法',
    `params`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作参数',
    `ip`          varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT 'IP地址',
    `create_time` bigint(20)                                              NULL DEFAULT NULL COMMENT '操作时间',
    `location`    varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '操作地点',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 423
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '系统日志表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_tag
-- ----------------------------
DROP TABLE IF EXISTS `tb_tag`;
CREATE TABLE `tb_tag`
(
    `id`   bigint(20)                                              NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名称',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 6
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '标签表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_tag
-- ----------------------------
INSERT INTO `tb_tag`
VALUES (1, '随笔');
INSERT INTO `tb_tag`
VALUES (4, '测试');
INSERT INTO `tb_tag`
VALUES (5, '博客日志');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`
(
    `id`        bigint(20)                                              NOT NULL AUTO_INCREMENT COMMENT '编号',
    `username`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
    `password`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
    `salt`      varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐值',
    `avatar`    varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
    `introduce` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍',
    `remark`    varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
    `nickname`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
    `email`     varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user`
VALUES (4, 'admin', 'e10adc3949ba59abbe56e057f20f883e', '', NULL, NULL, NULL, '往事随风', NULL);

SET FOREIGN_KEY_CHECKS = 1;
