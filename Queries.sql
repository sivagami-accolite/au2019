select * from players x join (select player_id,team_id,sum(score) from player_performance x group by player_id,team_id order by sum(score) desc limit 5) y on x.team_id = y.team_id and x.player_id=y.player_id;
select * from players x join (select player_id,team_id,sum(wickets) from player_performance x group by player_id,team_id order by sum(wickets) desc limit 5) y on x.team_id = y.team_id and x.player_id=y.player_id;
select * from team x join (select team_id,avg(score),count(*) from team_performance group by tournament_id,team_id) y on x.team_id=y.team_id;
select * from team x join (select team_id,avg(score),count(*) from team_performance group by tournament_id,team_id order by avg(score) asc) y on x.team_id=y.team_id;
select player_id,name,score from players;
SET SQL_SAFE_UPDATES=0;
select team_id from team_performance group by tournament_id,team_id having avg(score) <= ALL (select avg(score) from team_performance group by team_id,tournament_id);
update players set score = score+10 where team_id in (select team_id from team_performance group by tournament_id,team_id having avg(score) <=  ALL (select avg(score) from team_performance group by team_id,tournament_id) );
select player_id,name,score from players;