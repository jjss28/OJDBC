
create user userboardtest identified by userboardtest

grant resource, connect to userboardtest

alter user userboardtest default tablespace users

alter user userboardtest temporary tablespace temp