
SELECT t_clubs.Nom_Club
FROM t_sports INNER JOIN t_clubs ON t_sports.PK_Sport = t_clubs.FK_Sport
WHERE t_sports.PK_Sport=2;


