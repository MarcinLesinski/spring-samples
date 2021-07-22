create table if not exists `characters` (
    id BigInt AUTO_INCREMENT not null,
    name VarChar(64),
    character_motto_id BigInt,

    primary key (id)
);

create table if not exists character_mottos (
    id BigInt AUTO_INCREMENT not null,
    text VarChar(255),

    primary key (id)
);

-- one to one
alter table characters  add constraint foreign key (character_motto_id) references character_mottos(id);