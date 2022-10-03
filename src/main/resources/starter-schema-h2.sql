create schema if not exists trial;

create table if not exists trial.book (
    id INTEGER not null auto_increment,
    name varchar(255),
    isbn varchar(255),
    number INT CHECK (number IN (1,2)),
    primary key (id)
);