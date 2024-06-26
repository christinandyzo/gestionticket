CREATE TABLE USERS
(
   id   INT PRIMARY KEY,
   username  VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL
);

CREATE TABLE TICKETS
(
   id   INT PRIMARY KEY,
   title  VARCHAR(255) NOT NULL,
   description VARCHAR(255) NOT NULL,
   status INT NOT NULL,
   user_id INT,
   FOREIGN KEY (user_id) REFERENCES USERS(id)
);