insert into todo(srno, text, is_completed,completion_date) values(1,'SampleTodo1','N', null);
insert into todo(srno, text, is_completed,completion_date) values(2,'SampleTodo2','N', null);
insert into todo(srno, text, is_completed,completion_date) values(3,'SampleTodo3','N', null);

insert into role(id,role_name,is_create_allowed,is_delete_allowed,is_update_allowed) values(1,'Auditor','N','N','N');
insert into role(id,role_name,is_create_allowed,is_delete_allowed,is_update_allowed) values(2,'Executive','Y','N','N');
insert into role(id,role_name,is_create_allowed,is_delete_allowed,is_update_allowed) values(3,'Admin','Y','Y','Y');

insert into user(id,user_id,password,role_id) values(1,'auditor','pwd123',1);
insert into user(id,user_id,password,role_id) values(2,'exec','pwd123',2);
insert into user(id,user_id,password,role_id) values(3,'admin','pwd123',3);