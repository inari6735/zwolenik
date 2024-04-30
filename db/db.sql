CREATE DATABASE IF NOT EXISTS zwolenik;

USE zwolenik;

CREATE TABLE product (
    id int unsigned not null auto_increment primary key,
    product_number varchar(128),
    state varchar(64),
    textile varchar(512),
    color varchar(256),
    completion_time varchar(64),
    finish varchar(512),
    specification JSON
)
