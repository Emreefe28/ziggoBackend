INSERT INTO `vodafoneziggo`.`user` (`idUser`, `email`, `name`, `password`, `surname`) VALUES ('1557216', 'anneliebonnet@live.nl', 'Annelie', 'Lunkarya', 'Bonnet');
INSERT INTO `vodafoneziggo`.`user` (`idUser`, `email`, `name`, `password`, `surname`) VALUES ('1544216', 'info@liaaarsbergen.nl', 'Lia ', '2E2721KN', 'Aarsbergen');
INSERT INTO `vodafoneziggo`.`user` (`idUser`, `email`, `name`, `password`, `surname`) VALUES ('2335216', 'Aba.ruyter@worldonline.nl', 'Karina ', 'Aba33dbe', 'Aba');
INSERT INTO `vodafoneziggo`.`user` (`idUser`, `email`, `name`, `password`, `surname`) VALUES ('2335214', 'Jos.anema@planet.nl', 'Josephine ', 'sweex291', 'Anema');
INSERT INTO `vodafoneziggo`.`user` (`idUser`, `email`, `name`, `password`, `surname`) VALUES ('4535214', 'asselt-suringh@planet.nl', 'Chris ', 'ytoakfx', 'van Asselt');
INSERT INTO `vodafoneziggo`.`user` (`idUser`, `email`, `name`, `password`, `surname`) VALUES ('6675219', 'nbadir@xs4all.nl ', 'Nagy ', 'baridoa443', 'Badir');

INSERT INTO `vodafoneziggo`.`customer` (`adres`, `birthday`, `klantNummer`, `phone`, `idUser`) VALUES ('Colenbranderstraat 60', '1989-11-09', '500764821', '0204559687', '1557216');
INSERT INTO `vodafoneziggo`.`customer` (`adres`, `birthday`, `klantNummer`, `mobilePhone`, `phone`, `idUser`) VALUES ('Formosa 13', '1962-01-09', '500758494', '0659483304', '0291823948', '1544216');
INSERT INTO `vodafoneziggo`.`customer` (`adres`, `birthday`, `klantNummer`, `phone`, `idUser`) VALUES ('Meloenstraat 95', '1962-06-14', '503495861', '0403948321', '2335216');

INSERT INTO `vodafoneziggo`.`employee` (`afdeling`, `idUser`) VALUES ('admin', '2335214');
INSERT INTO `vodafoneziggo`.`employee` (`afdeling`, `idUser`) VALUES ('kcc', '4535214');
INSERT INTO `vodafoneziggo`.`employee` (`afdeling`, `idUser`) VALUES ('kcc', '6675219');

INSERT INTO `vodafoneziggo`.`monteursafspraak` (`datum`, `status`, `idUser`) VALUES ('2012-01-09 19:40:00', 'geannuleerd', '1544216');
INSERT INTO `vodafoneziggo`.`monteursafspraak` (`datum`, `status`, `idUser`) VALUES ('2012-02-09 12:10:00', 'verwerkt', '1544216');
INSERT INTO `vodafoneziggo`.`monteursafspraak` (`datum`, `status`, `idUser`) VALUES ('2019-06-2 09:00:00', 'gepland', '2335216');

INSERT INTO `vodafoneziggo`.`category` (`id`, `name`) VALUES ('1', 'geen internet');
INSERT INTO `vodafoneziggo`.`category` (`id`, `name`) VALUES ('2', 'traag wifi');
INSERT INTO `vodafoneziggo`.`category` (`id`, `name`) VALUES ('3', 'geen wifi');

INSERT INTO `vodafoneziggo`.`questionnaire` (`id`, `created`, `category`) VALUES ('1', '2012', '1');
INSERT INTO `vodafoneziggo`.`questionnaire` (`id`, `created`, `category`) VALUES ('2', '2012', '2');
INSERT INTO `vodafoneziggo`.`questionnaire` (`id`, `created`, `category`) VALUES ('3', '2013', '3');

INSERT INTO `vodafoneziggo`.`question` (`id`, `question`, `title`) VALUES ('1', 'werkt internet?', 'check verbinding');
INSERT INTO `vodafoneziggo`.`question` (`id`, `question`, `title`) VALUES ('2', 'hoeveel mensen zijn op uw wifi', 'check gebruikers');
INSERT INTO `vodafoneziggo`.`question` (`id`, `question`, `title`) VALUES ('3', 'is je verbinding nu beter?', 'gelukt?');

INSERT INTO `vodafoneziggo`.`questionnaire_question` (`Questionnaire_id`, `questions_id`) VALUES ('1', '1');
INSERT INTO `vodafoneziggo`.`questionnaire_question` (`Questionnaire_id`, `questions_id`) VALUES ('1', '2');
INSERT INTO `vodafoneziggo`.`questionnaire_question` (`Questionnaire_id`, `questions_id`) VALUES ('1', '3');

INSERT INTO `vodafoneziggo`.`customer_questionnaire` (`Customer_idUser`, `issues_id`) VALUES ('2335216', '1');
INSERT INTO `vodafoneziggo`.`customer_questionnaire` (`Customer_idUser`, `issues_id`) VALUES ('2335216', '2');

