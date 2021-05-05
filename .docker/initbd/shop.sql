SET CHARACTER SET utf8;

DROP TABLE IF EXISTS Purchases;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS Users;


DROP TABLE IF EXISTS Users;
CREATE TABLE Users(
	username VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	PRIMARY KEY(username)
);
DROP TABLE IF EXISTS Products;
create TABLE Products(
	productname VARCHAR(20) NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	PRIMARY KEY(productname) 
);

DROP TABLE IF EXISTS Purchases;
CREATE TABLE Purchases(
	username VARCHAR(20) NOT NULL,
	productname VARCHAR(20) NOT NULL,
	date DATETIME NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	units INTEGER NOT NULL,
	PRIMARY KEY(username, productname, date),
	FOREIGN KEY(username) REFERENCES Users(username),
	FOREIGN KEY(productname) REFERENCES Products(productname)
);

INSERT INTO Users VALUES ('user1','1234');
INSERT INTO Users VALUES ('user2','1234');
INSERT INTO Users VALUES ('user3','1234');
INSERT INTO Users VALUES ('user4','1234');

INSERT INTO Products VALUES ('Auriculares',11.99);
INSERT INTO Products VALUES ('Teclado Gaming',49.99);
INSERT INTO Products VALUES ('Lenovo Thinkpad X13',1300.99);

INSERT INTO Purchases VALUES('user1','Teclado Gaming',SYSDATE(),35.99,3);
INSERT INTO Purchases VALUES('user2','Lenovo Thinkpad X13',CONCAT(CURRENT_DATE(),'00:00:00'),1223.23,1);
