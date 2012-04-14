DROP DATABASE IF EXISTS pulse;
CREATE DATABASE pulse;
USE pulse;

CREATE TABLE `channel` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(150) NOT NULL,
  `name` varchar(50) NOT NULL,
  `msisdn` varchar(20) NOT NULL,
  `access_token` varchar(150),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `userchannel` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL DEFAULT '0',
  `channel_id` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `channel_id` (`channel_id`),
  CONSTRAINT `userchannel_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `userchannel_ibfk_2` FOREIGN KEY (`channel_id`) REFERENCES `channel` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `channel` (`id`,`name`) VALUES (1,'ChannelA'),(2,'ChannelB');
INSERT INTO `user` (`id`,`email`,`name`,`msisdn`,`access_token`) VALUES (1,'dimitri@pulse.com','Dimitri','5141111111','tok1'),(2,'francis@pulse.com','Francis','5142222222','tok2'),(3,'jake@pulse.com','Jake','5143333333','tok3'),(4,'lpl@pulse.com','LPL','5144444444','tok4'),(5,'stan@pulse.com','Stan','5145555555','tok5');
INSERT INTO `userchannel` (`id`,`user_id`,`channel_id`) VALUES (1,1,1),(2,1,2),(3,2,1),(4,2,2),(5,3,1),(6,3,2),(7,4,1),(8,4,2),(9,5,1),(10,5,2);
