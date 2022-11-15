create table users(
 id bigint auto_increment,
 nick_name varchar(10),
 level bigint,
 experience bigint,
 create_at datetime,
 constraint u_id primary key (id)
);

create table monster(
  id bigint auto_increment,
  nick_name varchar(20),
  experience bigint,
  constraint u_id primary key (id)
);

SELECT *
FROM users
WHERE id = id;