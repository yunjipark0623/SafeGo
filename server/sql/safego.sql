#데이터 베이스 이름 safego
CREATE database safego;
use safego;

#게시글
CREATE TABLE board (
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title varchar(32) NOT NULL,
    content mediumtext NOT NULL,
    write_time timestamp default CURRENT_TIMESTAMP not null
);

#댓글
CREATE TABLE comment (
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    board_id int(11) NOT NULL,
    content mediumtext NOT NULL,
    write_time timestamp default CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (board_id) REFERENCES board(id) on UPDATE CASCADE
);