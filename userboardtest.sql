CREATE TABLE member (
    mno NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    id VARCHAR2(50),
    pw VARCHAR2(50),
    regdate DATE
);

create SEQUENCE member_seq START WITH 1 INCREMENT BY 1;

select * from member