INSERT INTO `vodafoneziggo`.`user` (`idUser`, `email`, `name`, `password`, `surname`) VALUES ('1557216', 'anneliebonnet@live.nl', 'Annelie', 'Lunkarya', 'Bonnet');
INSERT INTO `vodafoneziggo`.`user` (`idUser`, `email`, `name`, `password`, `surname`) VALUES ('1544216', 'info@liaaarsbergen.nl', 'Lia ', '2E2721KN', 'Aarsbergen');
INSERT INTO `vodafoneziggo`.`user` (`idUser`, `email`, `name`, `password`, `surname`) VALUES ('2335216', 'Aba.ruyter@worldonline.nl', 'Karina ', 'Aba33dbe', 'Aba');
INSERT INTO `vodafoneziggo`.`user` (`idUser`, `email`, `name`, `password`, `surname`) VALUES ('2335214', 'Jos.anema@planet.nl', 'Josephine ', 'sweex291', 'Anema');
INSERT INTO `vodafoneziggo`.`user` (`idUser`, `email`, `name`, `password`, `surname`) VALUES ('4535214', 'asselt-suringh@planet.nl', 'Chris ', 'ytoakfx', 'van Asselt');
INSERT INTO `vodafoneziggo`.`user` (`idUser`, `email`, `name`, `password`, `surname`) VALUES ('6675219', 'nbadir@xs4all.nl ', 'Nagy ', 'baridoa443', 'Badir');

INSERT INTO `vodafoneziggo`.`customer` (`address`, `birthdate`, `customerCode`, `phone`, `idUser`) VALUES ('Colenbranderstraat 60', '1989-11-09', '500764821', '0204559687', '1557216');
INSERT INTO `vodafoneziggo`.`customer` (`address`, `birthdate`, `customerCode`, `mobilePhone`, `phone`, `idUser`) VALUES ('Formosa 13', '1962-01-09', '500758494', '0659483304', '0291823948', '1544216');
INSERT INTO `vodafoneziggo`.`customer` (`address`, `birthdate`, `customerCode`, `phone`, `idUser`) VALUES ('Meloenstraat 95', '1962-06-14', '503495861', '0403948321', '2335216');

INSERT INTO `vodafoneziggo`.`employee` (`department`, `idUser`) VALUES ('admin', '2335214');
INSERT INTO `vodafoneziggo`.`employee` (`department`, `idUser`) VALUES ('kcc', '4535214');
INSERT INTO `vodafoneziggo`.`employee` (`department`, `idUser`) VALUES ('kcc', '6675219');

INSERT INTO `vodafoneziggo`.`appointment` (`date`, `status`, `idUser`) VALUES ('2012-01-09 19:40:00', 'geannuleerd', '1544216');
INSERT INTO `vodafoneziggo`.`appointment` (`date`, `status`, `idUser`) VALUES ('2012-02-09 12:10:00', 'verwerkt', '1544216');
INSERT INTO `vodafoneziggo`.`appointment` (`date`, `status`, `idUser`) VALUES ('2019-06-2 09:00:00', 'gepland', '2335216');

INSERT INTO `vodafoneziggo`.`category` (`id`, `name`) VALUES ('1', 'geen internet');
INSERT INTO `vodafoneziggo`.`category` (`id`, `name`) VALUES ('2', 'traag wifi');
INSERT INTO `vodafoneziggo`.`category` (`id`, `name`) VALUES ('3', 'geen wifi');


INSERT INTO `vodafoneziggo`.`questionnaire` (`id`, `active` ,`created`, `category`) VALUES ('1', TRUE,'2019-06-2 09:00:00', '1');
INSERT INTO `vodafoneziggo`.`questionnaire` (`id`, `active` ,`created`, `category`) VALUES ('2', TRUE,'2019-06-2 09:00:00', '2');
INSERT INTO `vodafoneziggo`.`questionnaire` (`id`, `active` ,`created`, `category`) VALUES ('3', TRUE,'2019-06-2 09:00:00', '3');





INSERT INTO vodafoneziggo.question (id, question, title) VALUES ('1', ' Probeer uw modem te resetten.  Dit lost over het algemeen de meeste problemen op.', 'Reset uw modem');
INSERT INTO vodafoneziggo.question (id, question, title) VALUES ('2', 'Probeer een andere kabel. Mogelijk is het de kabel die niet werkt.', 'Probeer andere kabel.');
INSERT INTO vodafoneziggo.question (id, question, title) VALUES ('3', 'Controleer of uw computer internet instellingen goed staan. Mogelijk heeft u een verkeerd wachtwoord ingevuld of het netwerk geblokkeerd
', 'Controleer internetinstellingen');

INSERT INTO vodafoneziggo.question (id, question, title) VALUES ('4', 'Bent u verbonden aan het correcte netwerk? check dit bij uw netwerkverbindingen.', 'Verbonden aan het correcte netwerk');
INSERT INTO vodafoneziggo.question (id, question, title) VALUES ('5', 'Check uw verbinding binnen 5 meter van de modem. Als dit beter is moet uw dichterbij uw modem gebruik maken van uw apparaat of een wifiversterker gebruiken.', 'Te grote afstand');
INSERT INTO vodafoneziggo.question (id, question, title) VALUES ('6', 'Check of er andere mensen zijn die intensief gebruik maken van het internet. Dit kan uw wifi trager maken.', 'Andere gebruikers');

INSERT INTO vodafoneziggo.question (id, question, title) VALUES ('7', ' Bent u verbonden? Het is mogelijk dat u uw wifi uit heeft staan op uw apparaat. Zet het aan en check of u verbonden bent met het juiste netwerk', 'Verbonden?');
INSERT INTO vodafoneziggo.question (id, question, title) VALUES ('8', 'Check voor mogelijke stoorbronnen in uw huis en schakel ze uit. Dit kunnen zijn: een babyfoon, waarstation of een draadloze lichtschakelaar', 'Mogelijke stoorbronnen');
INSERT INTO vodafoneziggo.question (id, question, title) VALUES ('9', 'Als er te veel mensen met het wifinetwerk zijn verbonden kan het onstabiel worden. Check uw verbinding wanneer er minder dan 5 gebruikers op zitten.', 'Teveel mensen op netwerk');

INSERT INTO `vodafoneziggo`.`equipment` (`type`, `model`, `idUser`) VALUES ('splitter', 'POA-01-UPC', '1557216');
INSERT INTO `vodafoneziggo`.`equipment` (`type`, `model`, `idUser`) VALUES ('modem', 'Mediabox XL', '1557216');
INSERT INTO `vodafoneziggo`.`equipment` (`type`, `model`, `idUser`) VALUES ('modem', 'Connectbox', '2335216');
INSERT INTO `vodafoneziggo`.`equipment` (`type`, `model`, `idUser`) VALUES ('modem', 'Technicolor', '1544216');

INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`) VALUES ('1544746836133aarsbergen', '2019-01-13 13:27:16');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`) VALUES ('15577461153790aarsbergen', '2019-01-13 13:27:16');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`) VALUES ('1557746823790aarsbergen', '2019-02-13 13:27:16');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('1557746836133aarsbergen', '2019-05-13 13:27:16', '3');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('1557746853790aarsbergen', '2019-05-13 13:27:34', '1');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('155774453790aarsbergen', '2019-01-13 13:27:34', '5');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('1557746653790aarsbergen', '2019-03-13 13:27:34', '3');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('1533746853790aarsbergen', '2019-03-13 13:27:34', '4');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('2257746853790aarsbergen', '2019-03-13 13:27:34', '4');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('1559846853790aarsbergen', '2019-04-13 13:27:34', '3');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('1257746853790aarsbergen', '2019-04-13 13:27:34', '1');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('227746853790aarsbergen', '2019-04-13 13:27:34', '1');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('142746853790aarsbergen', '2019-04-13 13:27:34', '4');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('142746853790Bonnet', '2019-06-13 13:27:34', '6');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('142746843790Bonnet', '2019-06-13 13:27:34', '7');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('142746851790Bonnet', '2019-07-13 13:27:34', '8');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('142746853744Bonnet', '2019-07-13 13:27:34', '1');
INSERT INTO `vodafoneziggo`.`chat` (`id`, `created`, `rating`) VALUES ('142742853744Bonnet', '2019-07-13 13:27:34', '3');


INSERT INTO `vodafoneziggo`.`questionnaire_question` (`Questionnaire_id`, `questions_id`) VALUES ('1', '1');
INSERT INTO `vodafoneziggo`.`questionnaire_question` (`Questionnaire_id`, `questions_id`) VALUES ('1', '2');
INSERT INTO `vodafoneziggo`.`questionnaire_question` (`Questionnaire_id`, `questions_id`) VALUES ('1', '3');


INSERT INTO `vodafoneziggo`.`questionnaire_question` (`Questionnaire_id`, `questions_id`) VALUES ('2', '4');
INSERT INTO `vodafoneziggo`.`questionnaire_question` (`Questionnaire_id`, `questions_id`) VALUES ('2', '5');
INSERT INTO `vodafoneziggo`.`questionnaire_question` (`Questionnaire_id`, `questions_id`) VALUES ('2', '6');


INSERT INTO `vodafoneziggo`.`questionnaire_question` (`Questionnaire_id`, `questions_id`) VALUES ('3', '7');
INSERT INTO `vodafoneziggo`.`questionnaire_question` (`Questionnaire_id`, `questions_id`) VALUES ('3', '8');
INSERT INTO `vodafoneziggo`.`questionnaire_question` (`Questionnaire_id`, `questions_id`) VALUES ('3', '9');

INSERT INTO `vodafoneziggo`.`customer_questionnaire` (`Customer_idUser`, `issues_id`) VALUES ('2335216', '1');
INSERT INTO `vodafoneziggo`.`customer_questionnaire` (`Customer_idUser`, `issues_id`) VALUES ('2335216', '2');
