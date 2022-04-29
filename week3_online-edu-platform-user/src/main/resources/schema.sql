DROP TABLE IF EXISTS user;

CREATE TABLE user (
    userId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    userType VARCHAR(30) NOT NULL,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(20) NOT NULL,
    address VARCHAR(100),
    phone VARCHAR(20)
);


INSERT INTO user VALUES (1, 'ADMIN', '김코드', '김코드@코드.com', 'password', 'address', '010-0000-0000');
INSERT INTO user VALUES (2, 'USER', 'ss', 'ss@ss.com', 'password', 'address', '01000000000');
--INSERT INTO user VALUES (45, 2, '왕코드', '왕코드@google.com', 'password', 'address', '010-0000-0000');
--INSERT INTO user VALUES (873153, 9, '금코드', '금코드@google.com', 'password', 'address', '010-0000-0000');