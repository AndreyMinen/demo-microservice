create database if not exists tester;
use tester;
create table users(
    id int(5) not null AUTO_INCREMENT,
    login varchar(50),
     primary key(id),
     index(login)
);
create table roles(
    id int(5) not null AUTO_INCREMENT,
    name varchar(50),
     primary key(id),
    index(name)
);

create table users_roles(
    id int(5) not null AUTO_INCREMENT,
    user_id int(5),
    role_id int(5),
     primary key(id),
    index(user_id, role_id),
    foreign key(user_id) references users(id),
    foreign key (role_id) references roles(id)
);


insert into users(login) values ('users');
insert into users(login) values ('admin');

insert into roles(name) values ('ROLE_USERS');
insert into roles(name) values ('ROLE_ADMIN');

insert into users_roles(user_id, role_id) values (1,1);
insert into users_roles(user_id, role_id) values (2,2);