DROP TABLE IF EXISTS CARD_DETAILS;
CREATE TABLE CARD_DETAILS (
cardId INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
cardNumber INT(19) NOT NULL,
limit VARCHAR(50) NOT NULL,
balance VARCHAR(50) NOT NULL
);