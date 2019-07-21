use worldcup;
create table team (
team_id int not null,
country varchar(256),
tournament_win int,
primary key (team_id)
);