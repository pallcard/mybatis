### 说明
mybatis的使用

### 数据库
***数据库***
```
CREATE DATABASE mybatis_demo;
```
***创建表***
```
DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user (
    id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(32) DEFAULT NULL,
    PASSWORD VARCHAR(32) DEFAULT NULL,
    NAME VARCHAR(32) DEFAULT NULL,
    age INT(10) DEFAULT NULL,
    sex INT(2) DEFAULT NULL,
    birthday DATE DEFAULT NULL,
    created DATETIME DEFAULT NULL,
    updated DATETIME DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;
```
***添加数据***
```
INSERT INTO mybatis_demo.tb_user ( user_name, PASSWORD, NAME, age, sex, birthday, created, updated) 
    VALUES ( 'lk', '123456', '张三', '22', '1', '1996-09-09', NOW(), NOW());
INSERT INTO mybatis_demo.tb_user ( user_name, PASSWORD, NAME, age, sex, birthday, created, updated) 
    VALUES ( 'ls', '123456', '李四', '22', '1', '1997-12-05', NOW(), NOW());
```
