--// create table computers
-- Migration SQL that makes the change goes here.
create table computers (
    id bigint not null auto_increment, 
    computer_type varchar(255) not null, 
    name varchar(20), 
    primary key (id)
) type=InnoDB;
create table lappads (
    id bigint not null, 
    lappad_info varchar(20), 
    primary key (id),
    FOREIGN KEY (id) REFERENCES computers(id)
) type=InnoDB;
create table desktops (
    id bigint not null, 
    desktop_info varchar(20), 
    primary key (id),
    FOREIGN KEY (id) REFERENCES computers(id)
) type=InnoDB;

--//@UNDO
-- SQL to undo the change goes here.
drop table desktops;
drop table lappads;
drop table computers;
