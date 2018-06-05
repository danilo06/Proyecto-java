DROP TABLE IF EXISTS cuenta;

CREATE TABLE cuenta (
	accountNumber int NOT NULL,
	numberPersonalIdentification int NOT NULL,
    availableBalance real NOT NUll,
    totalBalance real NOT NULL,
	PRIMARY KEY (accountNumber)
);
