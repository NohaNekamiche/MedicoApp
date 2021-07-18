-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 07 juil. 2021 à 15:46
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tdm_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `booking`
--

DROP TABLE IF EXISTS `booking`;
CREATE TABLE IF NOT EXISTS `booking` (
  `idbooking` int(11) NOT NULL AUTO_INCREMENT,
  `IdDoc` int(11) NOT NULL,
  `IdPatient` int(11) NOT NULL,
  `date` varchar(50) NOT NULL,
  `heure` varchar(50) NOT NULL,
  `Titre` varchar(100) NOT NULL,
  PRIMARY KEY (`idbooking`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `booking`
--

INSERT INTO `booking` (`idbooking`, `IdDoc`, `IdPatient`, `date`, `heure`, `Titre`) VALUES
(1, 2, 3, '6-8-2021', '12:15', 'rdv-dentiste'),
(2, 5, 2, '5-8-2021', '15:30', 'rdv-dentiste'),
(15, 4, 7, '8-7-2021', '10:15', 'RDV-Dentiste'),
(16, 1, 7, '15-7-2021', '9:30', 'RDV-Dentiste'),
(17, 4, 7, '8-7-2021', '8:30', 'RDV-Dentiste'),
(6, 5, 8, '7-8-2021', '15:30', 'RDV-Dentiste'),
(18, 4, 7, '8-7-2021', '15:30', 'RDV-Dentiste'),
(19, 4, 7, '8-7-2021', '15:30', 'RDV-Dentiste'),
(20, 1, 7, '15-7-2021', '10:30', 'RDV-Dentiste'),
(12, 5, 8, '19-8-2021', '15:30', 'RDV-Dentiste'),
(21, 1, 7, '15-7-2021', '10:30', 'RDV-Dentiste'),
(22, 1, 7, '15-7-2021', '10:30', 'RDV-Dentiste'),
(23, 4, 7, '8-7-2021', '15:30', 'RDV-Dentiste'),
(24, 4, 7, '8-7-2021', '15:30', 'RDV-Dentiste'),
(25, 1, 7, '15-7-2021', '9:30', 'RDV-Dentiste');

-- --------------------------------------------------------

--
-- Structure de la table `conseil`
--

DROP TABLE IF EXISTS `conseil`;
CREATE TABLE IF NOT EXISTS `conseil` (
  `idconseil` int(11) NOT NULL AUTO_INCREMENT,
  `IdDoc` int(11) NOT NULL,
  `IdPatient` int(11) NOT NULL,
  `obj` varchar(255) NOT NULL,
  `msg` text NOT NULL,
  `reponse` text NOT NULL,
  PRIMARY KEY (`idconseil`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `conseil`
--

INSERT INTO `conseil` (`idconseil`, `IdDoc`, `IdPatient`, `obj`, `msg`, `reponse`) VALUES
(1, 4, 6, 'demande d\'explication ', 'bonjour monsieur,je veux savoir plus d\'informations sur les effet secondaires de ce medicament sachant que j\'ai eu des problemes dans mon estoma', 'take your medecin in the mroning'),
(2, 4, 7, 'demande d\'aide covid19', 'bonjour monsieur,je veux savoir plus d\'informations sur les effet secondaires de ce medicament sachant que j\'ai eu des problemes dans mon estoma', ''),
(3, 2, 7, 'help', 'i need help to take my medecinnes ', ''),
(25, 1, 7, 'demande', 'j\'ai besoin d\'aide', ' '),
(6, 5, 7, 'demande d\'aide grippe', 'bonjour monsieur,je veux savoir plus d\'informations sur les effet secondaires de ce medicament sachant que j\'ai eu des problemes dans mon estoma', 'take your medecin in the mroning'),
(22, 1, 7, 'help for covid', 'I\'m in danger', ' '),
(24, 1, 7, 'demande', 'j\'ai besoin d\'aide', ' '),
(18, 1, 7, 'help for covid', 'I\'m in danger', ' '),
(23, 1, 7, 'demande', 'j\'ai besoin d\'aide', ' '),
(21, 1, 7, 'lol', 'lool', ' ');

-- --------------------------------------------------------

--
-- Structure de la table `doctoremploi`
--

DROP TABLE IF EXISTS `doctoremploi`;
CREATE TABLE IF NOT EXISTS `doctoremploi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IdDoc` int(11) NOT NULL,
  `dateLibre` varchar(50) NOT NULL,
  `heure` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `doctoremploi`
--

INSERT INTO `doctoremploi` (`id`, `IdDoc`, `dateLibre`, `heure`) VALUES
(2, 1, '15-7-2021', '10:30'),
(8, 1, '15-7-2021', '8:30'),
(4, 4, '8-7-2021', '10:15'),
(9, 1, '15-7-2021', '15:30');

-- --------------------------------------------------------

--
-- Structure de la table `doctors`
--

DROP TABLE IF EXISTS `doctors`;
CREATE TABLE IF NOT EXISTS `doctors` (
  `IdDoc` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `specialite` varchar(50) NOT NULL,
  `photo` varchar(50) NOT NULL,
  `latCabinet` varchar(255) NOT NULL,
  `langCabinet` varchar(255) NOT NULL,
  PRIMARY KEY (`IdDoc`),
  KEY `fr_key` (`idUser`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `doctors`
--

INSERT INTO `doctors` (`IdDoc`, `idUser`, `specialite`, `photo`, `latCabinet`, `langCabinet`) VALUES
(1, 10, 'Dentiste', 'doc5.jpg', '36.768640346732944', '3.0539427116018474'),
(2, 2, 'Dentiste', 'doc2.jpg', '36.768640346732944', '3.0539427116018474'),
(3, 3, 'Dentiste', 'doc2.jpg', '36.768640346732944', '3.0539427116018474'),
(4, 4, 'Generaliste', 'doc1.jpg', '36.768640346732944', '3.0539427116018474'),
(5, 5, 'Generaliste', 'doc3.jpg', '36.768640346732944', '3.0539427116018474');

-- --------------------------------------------------------

--
-- Structure de la table `traitement`
--

DROP TABLE IF EXISTS `traitement`;
CREATE TABLE IF NOT EXISTS `traitement` (
  `idtraitement` int(11) NOT NULL AUTO_INCREMENT,
  `idbooking` int(11) NOT NULL,
  `maladie` varchar(255) NOT NULL,
  `explication` text NOT NULL,
  `medicaments` text NOT NULL,
  `dateFinTraitement` timestamp NOT NULL,
  PRIMARY KEY (`idtraitement`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `traitement`
--

INSERT INTO `traitement` (`idtraitement`, `idbooking`, `maladie`, `explication`, `medicaments`, `dateFinTraitement`) VALUES
(1, 2, 'covid-19', 'fiever,...', 'zomax,vitamine C', '2021-07-26 23:00:00'),
(2, 17, 'grippe', 'fievre,...', 'gripex,doliprane,..', '2021-07-27 14:00:00'),
(3, 16, 'grippe', 'fievre,...', 'gripex,doliprane,..', '2021-07-03 14:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `adr` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `pwd` text NOT NULL,
  `Role` varchar(20) NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`idUser`, `name`, `username`, `adr`, `phone`, `pwd`, `Role`) VALUES
(1, 'Selmane', 'lamia', 'Blida', '05554678', '$2a$08$1xpQqWP4O8qVkRNQEl2xk.u0uqOSo3ujx/kbAOkFLSb0LLAM.ns9y', '2'),
(2, 'Nekamiche', 'noha', 'alger centre', '05554678', '$2a$08$B1ZLQ5aC23USFBM07B.5D.y2fIaVOEkIpGrRjPMYbpZu78UAF0u6C', '1'),
(3, 'noha', 'noha', 'Medea', '05554678', '$2a$08$VULUNNjdnm0G1piRONu7oudEDLXn8mRg9lWTg4p14EjuzBPIDC0gq', '1'),
(4, 'Nekamiche', 'noha', 'bir khadem,alger', '05554678', '$2a$08$4XvF.HMz2HzzfEyf641vL.MzGI/LeMLzhz6ZD7BsCvRQxp6FWTcwK', '1'),
(5, 'Messaoudi', 'Achouak', 'chrega,alger', '05554678', '$2a$08$Ab5cM/xhsW2HA2VAA0sKWOflCwgIkj8mdSuwt4bRJOiC6K7PYJY96', '1'),
(6, 'nekamiche', 'souha', 'alger', '05554678', '$2a$08$PV7Z9ccGLavy3b5SzplC2uB23YeVq6QzDxxQ9aR8UB1xuB7O3A2y6', '1'),
(7, 'nekamiche', 'souha', 'alger', '055546', '$2a$08$IuOGKtkHnR5x8DwAafJWm.woXCsQD7jOz8FWMNQwzbHrPLxOOJFh2', '1'),
(8, 'nekamiche', 'noha', 'alger', '055546', '$2a$08$k1b5HlL9QVqvNZ7Y.xdvuuEkGRbEQq0DirdCzwY8ryTtGrTbiTle2', '1'),
(9, 'selmane', 'lamia', 'alger', '055546', '$2a$08$M1TWn4.fFHZfIq31W4jshO4dC1zhuSnec3K5CHPl3nvxMGohA5QBK', '1'),
(10, 'Mokadem', 'Hakim', 'alger,cheraga', '0555454545', '$2a$08$fMjNJ9oAeA1jNMYZf0D4eegPQiKv2HwkYSXr04VFi/lDSvFf564nK', '1'),
(11, 'Selmane', 'Lamia', 'alger,Bab Ezzouar', '0555454545', '$2a$08$aDo6HYHYunGqTLM8TqTK6eoQFpuc2LvOO.LRhp4k9ywgPw5UnfPoG', '1');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
