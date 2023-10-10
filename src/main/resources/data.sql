insert into user_details(id, birth_date, name)
values(10001, current_date(), 'username1');

insert into user_details(id, birth_date, name)
values(10002, current_date(), 'username2');

insert into user_details(id, birth_date, name)
values(10003, current_date(), 'username3');

insert into user_post(id, description, user_id)
values(20001, 'my first post', '10001');

insert into user_post(id, description, user_id)
values(20002, 'my 2 post', '10001');

insert into user_post(id, description, user_id)
values(20003, 'my 1 post', '10002');