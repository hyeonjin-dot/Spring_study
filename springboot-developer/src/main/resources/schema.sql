CREATE TABLE ARTICLE (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         content VARCHAR(255) NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE USERS (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY, -- 기본 키, 자동 증가
                       email VARCHAR(255) NOT NULL UNIQUE,   -- 이메일 필드, NOT NULL 및 UNIQUE 제약 조건
                       password VARCHAR(255) NOT NULL       -- 비밀번호 필드, NOT NULL
);


