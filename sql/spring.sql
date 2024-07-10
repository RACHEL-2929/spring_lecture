CREATE TABLE BOARD(
    SEQ NUMBER(5) PRIMARY KEY,
    TITLE VARCHAR2(200),
    WRITER VARCHAR2(20),
    CONTENT VARCHAR2(2000),
    REGDATE DATE DEFAULT SYSDATE,
    CNT NUMBER(5) DEFAULT 0
);

DESC BOARD;

select * from board;
select * from users;


CREATE TABLE USERS(
    ID VARCHAR2(8) PRIMARY KEY,
    PASSWORD VARCHAR2(8),
    NAME VARCHAR2(20),
    ROLE VARCHAR2(5)
);

DESC USERS;


update users set password='test1234' where id='test';
insert into users values('test','test1234','test','admin');
commit;
