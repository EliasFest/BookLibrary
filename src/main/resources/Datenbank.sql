CREATE DATABASE LibraryProject;

DROP TABLE Book;
DROP TABLE User;
DROP TABLE LendOut;

CREATE TABLE Book
(
    serialNumber INT NOT NULL PRIMARY KEY,
    bookName     VARCHAR(255)
);

CREATE TABLE User
(
    userNumber INT NOT NULL PRIMARY KEY,
    userName   VARCHAR(255)
);

Create Table LendOut
(
    id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    memberID INT,
    bookID   INT,
    start    DATE,
    endDate  DATE
);

ALTER TABLE LendOut
    ADD FOREIGN KEY (memberID) REFERENCES User (userNumber);
ALTER TABLE LendOut
    ADD FOREIGN KEY (bookID) REFERENCES Book (serialNumber);