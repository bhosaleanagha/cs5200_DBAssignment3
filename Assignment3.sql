 drop schema cs5200_jdbc;
 create schema cs5200_jdbc;
 use cs5200_jdbc;
 -- drop schema cs5200;
-- drop table cs5200.page_privilege;
 -- drop table cs5200.page_role;
 -- drop table widget;
 -- drop table website_role;
 -- drop table website_privilege;
 -- DROP table cs5200.page;
 -- DROP TABLE website;
 -- drop table developer;
 -- drop table user;
 -- drop table person;

 CREATE TABLE person(
Id INT NOT NULL AUTO_INCREMENT,
firstname  VARCHAR(45) NOT NULL ,
lastname VARCHAR(45) NOT NULL ,
username VARCHAR(45)  ,
password VARCHAR(45)  ,
email VARCHAR(45) ,
dob DATETIME ,
PRIMARY KEY(id)
);

CREATE TABLE developer(
developer_key VARCHAR(45) NOT NULL UNIQUE,
id INT UNIQUE,
CONSTRAINT developer_person_generalization
PRIMARY KEY(id,developer_key),
FOREIGN KEY(id) REFERENCES person(id) 
on delete cascade on update cascade
);

CREATE TABLE user(
user_agreement BOOLEAN DEFAULT false,
id INT UNIQUE,
CONSTRAINT user_person_generalization
PRIMARY KEY(id),
FOREIGN KEY(id) REFERENCES person(id) 
on delete cascade on update cascade
);

drop table if exists website; 
CREATE TABLE website (
id INT NOT NULL,
name VARCHAR(45) NOT NULL ,
description VARCHAR(200) NOT NULL,
created DATETIME DEFAULT CURRENT_TIMESTAMP,
updated DATETIME DEFAULT CURRENT_TIMESTAMP  on update CURRENT_TIMESTAMP ,
visits INT DEFAULT 0,
developerid INT not null,
constraint website
PRIMARY KEY(id,developerid),
FOREIGN KEY(developerid) REFERENCES developer(id)
);


-- drop table if exists page;
create table page(
id int not null auto_increment,
title varchar(45) not null unique,
description varchar(225) not null,
created datetime  default current_timestamp,
updated datetime default current_timestamp on update current_timestamp,
views int not null,
webid int not null ,
primary key(id),
constraint page_widget_fk foreign key(webid) references website(id)
on delete cascade
);

create table dtype(
name VARCHAR(45) NOT NULL UNIQUE,
PRIMARY KEY(name)
);


CREATE TABLE widget(
id Int NOT NULL UNIQUE AUTO_INCREMENT,
name VARCHAR(45) NOT NULL,
width INT,
height INT,
cssclass VARCHAR(45),
cssstyle VARCHAR(45),
text VARCHAR(45),
sequence INT NOT NULL,
url VARCHAR(45),
shareable BOOLEAN,
expandable BOOLEAN,
src VARCHAR(45),
size INT DEFAULT 2,
html VARCHAR(200),
pageid INT,
dtype VARCHAR(45),
CONSTRAINT widget_page_composition
PRIMARY KEY(id),
FOREIGN KEY(pageid) REFERENCES page(id)
on delete cascade on update cascade,
FOREIGN KEY(dtype) REFERENCES dtype(name)
on delete cascade on update cascade
);

INSERT INTO dtype VALUES('html');
INSERT INTO dtype VALUES('youtube');
INSERT INTO dtype VALUES('heading');
INSERT INTO dtype VALUES('image');

CREATE TABLE role(
id INT UNIQUE NOT NULL auto_increment,
name VARCHAR(45) NOT NULL UNIQUE,
PRIMARY KEY(id));

INSERT INTO role(name) values('owner');
INSERT INTO role(name) values('admin');
INSERT INTO role(name) values('writer');
INSERT INTO role(name) values('editor');
INSERT INTO role(name) values('reviewer');

CREATE TABLE website_role(
developer_id INT,
website_id INT,
role_id INT,
CONSTRAINT website_role
PRIMARY KEY(developer_id,website_id,role_id),
FOREIGN KEY(developer_id) REFERENCES developer(id) 
on delete cascade on update cascade,
FOREIGN KEY(website_id) REFERENCES website(id)
on delete cascade on update cascade,
FOREIGN KEY (role_id) REFERENCES role(id)
on delete cascade on update cascade
);

CREATE TABLE privilege(
name VARCHAR(45) NOT NULL UNIQUE,
PRIMARY KEY(name));

insert into privilege values('create');
insert into privilege values('read');
insert into privilege values('update');
insert into privilege values('delete');

CREATE TABLE website_privilege(
developer_id INT,
website_id INT,
privilege VARCHAR(45),
CONSTRAINT website_privilege
PRIMARY KEY(developer_id,website_id,privilege),
FOREIGN KEY(developer_id) REFERENCES developer(id) 
on delete cascade ,
FOREIGN KEY(website_id) REFERENCES website(id)
on delete cascade ,
FOREIGN KEY (privilege) REFERENCES privilege(name)
on delete cascade 
);

CREATE TABLE page_role(
developer_id INT NOT NULL,
page_id INT NOT NULL,
role_id INT NOT NULL,
CONSTRAINT page_role
PRIMARY KEY(developer_id,page_id,role_id),
FOREIGN KEY(developer_id) REFERENCES developer(id) 
on delete cascade,
FOREIGN KEY(page_id) REFERENCES page(id)
on delete cascade,
FOREIGN KEY (role_id) REFERENCES role(id)
on delete cascade
);

CREATE TABLE page_privilege(
developer_id INT,
page_id INT,
privilege VARCHAR(45),
CONSTRAINT page_privilege
PRIMARY KEY(developer_id,page_id,privilege),
FOREIGN KEY(developer_id) REFERENCES developer(id) 
on delete cascade on update cascade,
FOREIGN KEY(page_id) REFERENCES page(id)
on delete cascade on update cascade,
FOREIGN KEY (privilege) REFERENCES privilege(name)
on delete cascade on update cascade
);

CREATE TABLE phone(
is_primary BOOLEAN NOT NULL,
phone VARCHAR(45) NOT NULL UNIQUE,
id INT,
CONSTRAINT phone_person_composition
PRIMARY KEY(id,phone),
FOREIGN KEY(id) REFERENCES person(id)
on delete cascade on update cascade
);

CREATE TABLE address(
is_primary BOOLEAN NOT NULL,
street1 VARCHAR(45) NOT NULL,
street2 VARCHAR(45) ,
city VARCHAR(45) NOT NULL,
state VARCHAR(45) ,
zip INT ,
id INT,
CONSTRAINT address_person_composition
PRIMARY KEY(id,is_primary,street1,city),
FOREIGN KEY(id) REFERENCES person(id)
on delete cascade on update cascade
);

