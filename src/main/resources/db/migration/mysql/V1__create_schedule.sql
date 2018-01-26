create table schedule(
  id int not null AUTO_INCREMENT,
  code varchar(255) not null,
  title varchar(500) not null,
  monthly varchar(255) not null,
  daily varchar(255) not null,
  weekly varchar(255) not null,
  hourly varchar(255) not null,
  minutely varchar(255) not null,

  primary key(id)
)engine=InnoDB default charset=utf8;