-- exposed_yn INT(20) => INT(1) // 0 : NO, 1: YES
-- CONTENT : content BLOB => VARCHAR(100)
DROP TABLE IF EXISTS LECTURE;

CREATE TABLE IF NOT EXISTS LECTURE (
    lecture_id INT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    title VARCHAR(45) not null,
    location VARCHAR(45) not null,
    exposed_yn INT(1) not null,
    created_at TIMESTAMP not null,
    updated_at TIMESTAMP not null
    );

INSERT INTO LECTURE
VALUES
    (1, 'effective java', 'seoul', '0', '2022-04-25 13:32:50', '2022-04-25 13:32:50'),
    (2, ' What is Reactive?', 'seoul', '1', '2022-04-25 17:50:30', '2022-04-25 17:50:30');
--(1, '자바의 정석', '서울특별시 노원구', '0'),
--(2, '이펙티브 자바', '서울특별시 강남구', '1'),
--(3, '자바 알고리즘 코딩 테스트', '서울특별시 동작구', '1');

DROP TABLE IF EXISTS ENROLLMENT;

CREATE TABLE IF NOT EXISTS ENROLLMENT (
    enrollment_id INT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    lecture_id INT(20) not null,
    user_id INT(20) not null,
    created_at TIMESTAMP not null,
    updated_at TIMESTAMP not null
    );

DROP TABLE IF EXISTS MATCHING;

CREATE TABLE IF NOT EXISTS MATCHING (
    matching_id INT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    lecture_id INT(20) not null,
    user_id INT(20) not null,
    created_at TIMESTAMP not null,
    updated_at TIMESTAMP not null
    );

DROP TABLE IF EXISTS SCORE;

CREATE TABLE IF NOT EXISTS SCORE (
    score_id INT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    lecture_id INT(20) not null,
    user_id INT(20) not null,
    score VARCHAR(45) not null,
    comment VARCHAR(200) not null,
    created_at TIMESTAMP not null,
    updated_at TIMESTAMP not null
    );

DROP TABLE IF EXISTS CONTENT;

CREATE TABLE IF NOT EXISTS CONTENT (
    content_id INT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL,
    lecture_id INT(20) not null,
    content VARCHAR(100) not null,
    exam_yn INT(1) not null,
    created_at TIMESTAMP not null,
    updated_at TIMESTAMP not null
    );