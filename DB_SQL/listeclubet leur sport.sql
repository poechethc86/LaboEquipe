SELECT t_clubs.Nom_Club, t_sports.Nom_Sport
FROM t_sports INNER JOIN t_clubs ON t_sports.PK_Sport = t_clubs.FK_Sport;
