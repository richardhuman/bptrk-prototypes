-- ====================
-- RUN AS DEV USER
-- ====================

delete from "user";

insert into "user"(username, created_at) values('user1@test.com', now());
insert into "user"(username, created_at) values('user2@google.com', now());
insert into "user"(username, created_at) values('user3@human.tech', now());