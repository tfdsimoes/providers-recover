CREATE DATABASE trial;

USE trial;

CREATE TABLE providers(
	id INT PRIMARY KEY auto_increment,
	name VARCHAR (255),
	inserted DATETIME DEFAULT CURRENT_TIMESTAMP,
	id_client INT NOT NULL, 
	INDEX (id_client)
);

INSERT INTO providers (name, id_client) VALUES 
	('Coca-cola', 5), 
	('Pepsi', 5),
	('Redbull', 6);