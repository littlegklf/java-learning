create table if not exists Ingredient (
    id varchar(4) not null ,
    name varchar(25) not null ,
    type varchar(10) not null
);
create table if not exists my_order (
    name varchar(25) not null ,
    street varchar(25),
    ccNumber varchar(50),
    ccCvv varchar(10)
);