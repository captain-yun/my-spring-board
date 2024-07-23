-- data.sql
INSERT INTO board (title, content, username) VALUES
                                                 ('Title1', 'Content1', 'user1'),
                                                 ('Title2', 'Content2', 'user2');

INSERT INTO comment (board_id, content, username) VALUES
                                                      (1, 'Comment1 on Board1', 'user2'),
                                                      (1, 'Comment2 on Board1', 'user3'),
                                                      (2, 'Comment1 on Board2', 'user1');

INSERT INTO user (username, password, email) VALUES
                                                 ('user1', 'pass1', 'user1@example.com'),
                                                 ('user2', 'pass2', 'user2@example.com');
