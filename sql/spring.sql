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

create table lbi_board(
bno number generated always as IDENTITY,
title varchar2(150) not null,
content varchar2(2000) not null,
writer varchar2(50) not null,
regdate date default sysdate,
updatedate date default sysdate,
constraint pk_board PRIMARY key(bno)
);

insert into lbi_board(title,content,writer) values('테스트 제목','테스트 내용','작가');
insert into lbi_board(title,content,writer) values('테스트 제목','테스트 내용','작가');
insert into lbi_board(title,content,writer) values('테스트 제목','테스트 내용','작가');

commit;

select * from lbi_board;
