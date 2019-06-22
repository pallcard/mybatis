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

CREATE TABLE tb_order (
     id INT(11) NOT NULL AUTO_INCREMENT,
     user_id INT(11) DEFAULT NULL,
     order_number VARCHAR(255) DEFAULT NULL,
     create_time DATETIME DEFAULT NULL,
     updated_time DATETIME DEFAULT NULL,
     PRIMARY KEY (id)
) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE tb_item (
    id INT(11) NOT NULL,
    item_name VARCHAR(255) DEFAULT NULL,
    item_price DECIMAL(10,2) DEFAULT NULL,
    item_detail VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE tb_orderdetail (
    id INT(11) NOT NULL AUTO_INCREMENT,
    order_id INT(11) DEFAULT NULL,
    total_price DECIMAL(10,0) DEFAULT NULL,
    item_id INT(11) DEFAULT NULL,
    STATUS INT(10) UNSIGNED ZEROFILL DEFAULT NULL COMMENT '0成功非0失败',
    PRIMARY KEY (id)
) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
```
***添加数据***
```
INSERT INTO mybatis_demo.tb_user ( user_name, PASSWORD, NAME, age, sex, birthday, created, updated) 
    VALUES ( 'lk', '123456', '张三', '22', '1', '1996-09-09', NOW(), NOW());
INSERT INTO mybatis_demo.tb_user ( user_name, PASSWORD, NAME, age, sex, birthday, created, updated) 
    VALUES ( 'ls', '123456', '李四', '22', '1', '1997-12-05', NOW(), NOW());

INSERT INTO tb_item 
    VALUES ('1', '袜子', '29.90', '香香的袜子');
INSERT INTO tb_item 
    VALUES ('2', '套子', '99.99', '冈本001');

INSERT INTO tb_orderdetail 
    VALUES ('1', '1', '10000', '1', '0000000001');
INSERT INTO tb_orderdetail 
    VALUES ('2', '2', '2000', '2', '0000000000');
```
