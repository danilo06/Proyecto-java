DROP TABLE IF EXISTS salariedEmployee;
DROP TABLE IF EXISTS commissionEmployee;
DROP TABLE IF EXISTS basePlusCommissionEmployee;
DROP TABLE IF EXISTS hourlyEmployee;
DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
	socialSecurityNumber varchar (30) NOT NULL,
	firstName varchar (30) NOT NULL,
	lastName varchar (30) NOT NULL,
    birthday date NOT NULL,
	employeeType varchar (30) NOT NULL,
	departmentName varchar (30) NOT NULL,
	PRIMARY KEY (socialSecurityNumber)
);

CREATE TABLE salariedEmployee (
	socialsecurityNumber varchar (30) NOT NULL,
	weeklySalary real NOT NULL,
	bonus real,
	INDEX (socialSecurityNumber),
	FOREIGN KEY (socialSecurityNumber) REFERENCES employee (socialSecurityNumber)
) ;

CREATE TABLE commissionEmployee (
	socialSecurityNumber varchar (30) NOT NULL,
	grossSales int NOT NULL,
	commissionRate real NOT NULL,
	bonus real,
	INDEX (socialSecurityNumber),
	FOREIGN KEY (socialSecurityNumber) REFERENCES employee (socialSecurityNumber)
) ;

CREATE TABLE basePlusCommissionEmployee (
	socialSecurityNumber varchar (30) NOT NULL,
	grossSales int NOT NULL,
	commissionRate real NOT NULL,
	baseSalary real NOT NULL,
	bonus real,
	INDEX (socialSecurityNumber),
	FOREIGN KEY (socialSecurityNumber) REFERENCES employee (socialSecurityNumber)
) ;

CREATE TABLE hourlyEmployee (
	socialSecurityNumber varchar (30) NOT NULL,
	hours int NOT NULL,
	wage real NOT NULL,
	bonus real,
	INDEX (socialSecurityNumber),
	FOREIGN KEY (socialSecurityNumber) REFERENCES employee (socialSecurityNumber)
) ;