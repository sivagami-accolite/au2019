
create table team_performance(
   tournament_id INT NOT NULL,
   match_id INT NOT NULL,
   team_id INT NOT NULL,
   score INT,
   wickets INT,
   status varchar(256) NOT NULL CHECK (status IN ('won','lost','draw')),
   primary key(tournament_id,match_id,team_id)
);
ALTER TABLE team_performance
ADD FOREIGN KEY (team_id) REFERENCES team(team_id);
