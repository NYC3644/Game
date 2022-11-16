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

# ----------유저 쿼리---------
SELECT *
FROM users
WHERE nick_name = 'nyc';

DELETE
FROM users
WHERE id = id;



# ----------몬스터 쿼리---------
SELECT *
FROM monster;

DELETE
FROM monster
WHERE id = id;

