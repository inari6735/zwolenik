CREATE DATABASE IF NOT EXISTS zwolenik;

USE zwolenik;

create user 'user'@'%' identified by 'Popa997#root';
grant all on zwolenik.* to 'user'@'%';

CREATE TABLE IF NOT EXISTS product (
    id int unsigned not null auto_increment primary key,
    product_number varchar(128),
    state varchar(64),
    textile varchar(512),
    color varchar(256),
    completion_time varchar(64),
    finish varchar(512),
    specification JSON
)

CREATE TABLE IF NOT EXISTS cart (
    id int unsigned not null auto_increment primary key,
    client_id int,
    product_id int,
    specification JSON
)
