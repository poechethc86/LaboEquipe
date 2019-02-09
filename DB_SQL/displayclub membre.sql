SELECT t_clubs.Nom_Club, t_membres.Nom_Membres, t_membres.Prenom_Membres
FROM t_membres INNER JOIN (t_clubs INNER JOIN ti_membres_clubs ON t_clubs.PK_Club = ti_membres_clubs.FK_Clubs) 
ON t_membres.PK_Membres = ti_membres_clubs.FK_Membres
WHERE t_clubs.PK_Club=2;