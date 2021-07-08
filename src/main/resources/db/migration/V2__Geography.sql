start transaction;

-- ADR: some users might want add custom terrains
create table if not exists terrains(
  id BigInt AUTO_INCREMENT not null,
  name VarChar(24),

  primary key (id)
);

create table if not exists regions (
  id BigInt AUTO_INCREMENT not null,
  name VarChar(50),
  description VarChar(256),

  primary key (id)
);

create table if not exists countries (
  id BigInt AUTO_INCREMENT not null,
  name VarChar(50),

  located_in_region_id BigInt,
  foreign key (located_in_region_id) references regions(id),
  primary key (id)
);


alter table regions add constraint foreign key (located_in_country_id) references countries(id);

create table if not exists towns (
  id BigInt AUTO_INCREMENT not null,
  name VarChar(50),

  country_id BigInt,
  foreign key (country_id) references countries(id),
  primary key(id)
);

commit;