create table article
(
    id         bigint auto_increment primary key,
    title      varchar(100) not null,
    author     varchar(100) not null,
    content    text         ,
    created_at timestamp    not null,
    password   varchar(100) not null
);