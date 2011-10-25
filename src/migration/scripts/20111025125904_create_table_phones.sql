--// create table phones
-- Migration SQL that makes the change goes here.
create table tel_phones (
    id bigint not null, name varchar(20), 
    tel_info varchar(20), 
    primary key (id)
) type=InnoDB;
create table cell_phones (
    id bigint not null, name varchar(20), 
    cell_info varchar(20), 
    primary key (id)
) type=InnoDB;

--//@UNDO
-- SQL to undo the change goes here.
drop table cell_phones;
drop table tel_phones;
