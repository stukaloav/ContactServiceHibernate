DROP TABLE IF EXISTS CONTACT;
DROP TABLE IF EXISTS HOBBY;
DROP TABLE IF EXISTS PLACE;

CREATE TABLE CONTACT (
       ID INT NOT NULL AUTO_INCREMENT
     , FIRST_NAME VARCHAR(99) NOT NULL
     , LAST_NAME VARCHAR(99) NOT NULL
     , BIRTH_DATE DATE
);

CREATE TABLE HOBBY (
      ID INT NOT NULL AUTO_INCREMENT
    , TITLE VARCHAR(99) NOT NULL
    , DESCRIPTION VARCHAR(99) NOT NULL
);

CREATE TABLE PLACE (
      ID INT NOT NULL AUTO_INCREMENT
    , TITLE VARCHAR(99) NOT NULL
    , LONGITUDE DOUBLE NOT NULL
    , LATITUDE DOUBLE NOT NULL
);



