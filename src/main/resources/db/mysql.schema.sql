set @old_unique_checks=@@unique_checks, unique_checks=0;
set @old_foreign_key_checks=@@foreign_key_checks, foreign_key_checks=0;
set @old_sql_mode=@@sql_mode, sql_mode='traditional,allow_invalid_dates';

-- drop schema if exists `redpack` ;
create schema if not exists `redpack` default character set utf8 collate utf8_general_ci ;

-- -----------------------------------------------------
-- table `redpack`.`red_pack_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `redpack`.`red_pack_info` ;
create table if not exists `redpack`.`red_pack_info` (
    `red_pack_info_id` INT(64) NOT NULL AUTO_INCREMENT,
    `mch_id` VARCHAR(32) NOT NULL,
    `wxappid` VARCHAR(32) NOT NULL,
    `send_name` VARCHAR(32) NOT NULL,
    `total_amount` INT(32)NOT NULL ,
    `total_num` INT(32) NOT NULL,
    `wishing` VARCHAR(128) NOT NULL,
    `act_name` VARCHAR(32) NOT NULL,
    `remark` VARCHAR(256) NOT NULL,

     primary key (`red_pack_info_id`)
) engine innodb;

-- -----------------------------------------------------
-- table `redpack`.`red_pack`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `redpack`.`red_pack` ;
create table if not exists `redpack`.`red_pack` (
    `qrcode` VARCHAR(32) NOT NULL,
    `red_pack_info_id` INT(64) NOT NULL,
    `status` INT(32)NOT NULL ,
    `mch_billno` VARCHAR(28),
    `re_openid` VARCHAR(32),
    `created_on` datetime NOT NULL,
	  `updated_on` datetime,

     constraint `fk_redpack_1` foreign key (`red_pack_info_id`) references `redpack`.`red_pack_info`(`red_pack_info_id`),
     primary key (`qrcode`)
) engine innodb;


