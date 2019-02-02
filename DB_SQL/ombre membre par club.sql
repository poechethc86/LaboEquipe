SELECT t_clubs.Nom_Club, Sum(ti_membres_clubs.FK_Membres) AS SommeDeFK_Membres
FROM t_membres INNER JOIN ((t_sports INNER JOIN t_clubs ON t_sports.PK_Sport = t_clubs.FK_Sport) INNER JOIN ti_membres_clubs ON t_clubs.PK_Club = ti_membres_clubs.FK_Clubs) ON t_membres.PK_Membres = ti_membres_clubs.FK_Membres
GROUP BY t_clubs.Nom_Club;
