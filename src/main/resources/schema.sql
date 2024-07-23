-- schema.sql
CREATE TABLE IF NOT EXISTS board (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     title VARCHAR(255),
    content TEXT,
    username VARCHAR(50)
    );

CREATE TABLE IF NOT EXISTS comment (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       board_id BIGINT,
                                       content TEXT,
                                       username VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (board_id) REFERENCES board(id)
    );

CREATE TABLE IF NOT EXISTS user (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    username VARCHAR(50),
    password VARCHAR(255),
    email VARCHAR(255)
    );
