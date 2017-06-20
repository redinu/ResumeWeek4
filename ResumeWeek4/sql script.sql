use resumeapp;
CREATE TABLE `persontable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fname` VARCHAR(50) NULL,
  `lname` VARCHAR(50) NULL,
  `email` VARCHAR(50) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `jobtable` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `jobtitle` VARCHAR(50) NULL,
  `startdate` DATETIME NULL,
  `enddate` DATETIME NULL,
  `duties` BLOB NULL,
  `company` VARCHAR(50) NULL,
  `personid` INT NULL,
  PRIMARY KEY (`id`));
  
create table jobduties (
 id int auto_increment primary key,
 jobid int, 
 jobduty varchar(50)
);

CREATE TABLE `resumeapp`.`skills` (
  `skillId` INT NOT NULL AUTO_INCREMENT,
  `skill` VARCHAR(50) NULL,
  `proficiency` INT NULL,
  `personId` INT NULL,
  PRIMARY KEY (`skillId`));
  
CREATE TABLE `resumeapp`.`education` (
  `eduId` INT NOT NULL AUTO_INCREMENT,
  `degree` VARCHAR(50) NULL,
  `institute` VARCHAR(50) NULL,
  `year` DATETIME NULL,
  `personId` INT NULL,
  PRIMARY KEY (`eduId`));
