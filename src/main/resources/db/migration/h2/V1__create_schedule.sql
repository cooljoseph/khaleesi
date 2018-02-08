create sequence if not exists HIBERNATE_SEQUENCE;

create table schedule(
  id int not null,
  code varchar(100) not null,
  group_code varchar(255) not null,
  title varchar(500) not null,
  description varchar(1000),

  id_concurrent_yn varchar(1) not null default 'N',
  code_concurrent_yn varchar(1) not null default 'N',
  group_concurrent_yn varchar(1) not null default 'N',

  args1 varchar(500),
  args1name varchar(50),
  args2 varchar(500),
  args2name varchar(50),
  args3 varchar(500),
  args3name varchar(50),
  args4 varchar(500),
  args4name varchar(50),
  args5 varchar(500),
  args5name varchar(50),

  validflag varchar(2) not null default 'N',

  month varchar(100) not null,
  day_of_month varchar(100) not null,
  day_of_week varchar(100) not null,
  hour varchar(100) not null,
  minute varchar(100) not null,
  second varchar(100) not null,

  created_at datetime not null,
  last_modified_at datetime not null,

  primary key(id)
)engine=InnoDB default charset=utf8;

create table worker(
  id int not null,
  description varchar(1000),
  host varchar(255) not null,
  ip varchar(100) not null,
  name varchar(100) not null,
  port varchar(20) not null,
  schedule_mode varchar(10),
  status varchar(2) not null,

  created_at datetime not null,
  last_modified_at datetime not null,

  PRIMARY KEY (id)
)engine=InnoDB default charset=utf8;

create table schedule_work(
  id int not null,
  description varchar(1000),
  end_dttm varchar(14),
  error_msg varchar(1000),
  start_dttm varchar(14) not null,
  status varchar(1) not null default 'P',
  schedule_id int,
  worker_id int,

  CONSTRAINT fk_schedule_work_schedule FOREIGN KEY (schedule_id) REFERENCES schedule(id),
  CONSTRAINT fk_schedule_work_worker FOREIGN KEY (worker_id) REFERENCES worker(id),
  PRIMARY KEY (id)
)engine=InnoDB default charset=utf8;

CREATE INDEX schedule_work_ix_start_dttm ON schedule_work (start_dttm);
CREATE INDEX schedule_work_ix_status on schedule_work(status);

create table schedule_stored_data(
  id int,

  data varchar(4000) not null,
  level varchar(3) not null,
  stored_id varchar(200) not null,

  created_at datetime not null,
  last_modified_at datetime not null,

  PRIMARY KEY (id)
);

CREATE INDEX schedule_stored_data_ix ON schedule_stored_data(stored_id, level);

CREATE TABLE schedule_worker_map(
  schedule_id int,
  worker_id int,

  CONSTRAINT fk_schedule_worker_map_1 FOREIGN KEY (schedule_id) REFERENCES schedule(id),
  CONSTRAINT fk_schedule_worker_map_2 FOREIGN KEY (worker_id) REFERENCES worker(id)
);
