SELECT t_clubs.Nom_Club
FROM t_membres INNER JOIN (t_clubs INNER JOIN ti_membres_clubs ON t_clubs.PK_Club = ti_membres_clubs.FK_Clubs) 
ON t_membres.PK_Membres = ti_membres_clubs.FK_Membres
WHERE t_membres.PK_Membres=2;
