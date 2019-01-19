-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 19 jan. 2019 à 10:50
-- Version du serveur :  5.7.23
-- Version de PHP :  7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `db_projet_equipe`
--

-- --------------------------------------------------------

--
-- Structure de la table `ti_membres_clubs`
--

DROP TABLE IF EXISTS `ti_membres_clubs`;
CREATE TABLE IF NOT EXISTS `ti_membres_clubs` (
  `FK_Membres` bigint(20) NOT NULL,
  `FK_Clubs` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `ti_membres_clubs`
--

INSERT INTO `ti_membres_clubs` (`FK_Membres`, `FK_Clubs`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 3),
(2, 4),
(2, 5),
(3, 2);

-- --------------------------------------------------------

--
-- Structure de la table `t_clubs`
--

DROP TABLE IF EXISTS `t_clubs`;
CREATE TABLE IF NOT EXISTS `t_clubs` (
  `PK_Club` bigint(20) NOT NULL AUTO_INCREMENT,
  `Nom_Club` varchar(32) COLLATE utf8_bin NOT NULL,
  `FK_Sport` bigint(20) NOT NULL,
  PRIMARY KEY (`PK_Club`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `t_clubs`
--

INSERT INTO `t_clubs` (`PK_Club`, `Nom_Club`, `FK_Sport`) VALUES
(1, 'club_foot', 1),
(2, 'club_basket', 2),
(3, 'club_ski', 6),
(4, 'club_surf', 5),
(5, 'club_équitation', 7);

-- --------------------------------------------------------

--
-- Structure de la table `t_membres`
--

DROP TABLE IF EXISTS `t_membres`;
CREATE TABLE IF NOT EXISTS `t_membres` (
  `PK_Membres` bigint(20) NOT NULL AUTO_INCREMENT,
  `Nom_Membres` varchar(32) COLLATE utf8_bin NOT NULL,
  `Prenom_Membres` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`PK_Membres`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `t_membres`
--

INSERT INTO `t_membres` (`PK_Membres`, `Nom_Membres`, `Prenom_Membres`) VALUES
(1, 'Huyghe', 'Julien'),
(2, 'Roch', 'Sophie'),
(3, 'Gendarme', 'Justin');

-- --------------------------------------------------------

--
-- Structure de la table `t_sports`
--

DROP TABLE IF EXISTS `t_sports`;
CREATE TABLE IF NOT EXISTS `t_sports` (
  `PK_Sport` bigint(20) NOT NULL AUTO_INCREMENT,
  `Nom_Sport` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`PK_Sport`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `t_sports`
--

INSERT INTO `t_sports` (`PK_Sport`, `Nom_Sport`) VALUES
(1, 'Football'),
(2, 'Basketball'),
(6, 'Ski'),
(5, 'Surf'),
(7, 'equitation');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
