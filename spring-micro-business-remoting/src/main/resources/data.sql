insert into exchange_value(id,currency_from,currency_to,conversion_multiple) values(101,'USD','INR',65);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple) values(102,'EUR','INR',75);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple) values(103,'AUD','INR',25);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple) values(104,'HHH','III',25);
insert into exchange_value(id,currency_from,currency_to,conversion_multiple) values(105,'JJJ','MMM',25);


insert into foreign_table_one(id,name,exchange_id) values(10,'x',101);
insert into foreign_table_one(id,name,exchange_id) values(11,'y',102);
insert into foreign_table_one(id,name,exchange_id) values(12,'z',103);
insert into foreign_table_one(id,name,exchange_id) values(13,'p',103);
insert into foreign_table_one(id,name,exchange_id) values(14,'q',104);
insert into foreign_table_one(id,name,exchange_id) values(15,'r',104);


insert into foreign_table_two(id,name,exchange_id) values(20,'xx',103);
insert into foreign_table_two(id,name,exchange_id) values(21,'yy',104);
insert into foreign_table_two(id,name,exchange_id) values(22,'zz',102);
insert into foreign_table_two(id,name,exchange_id) values(23,'pp',104);
insert into foreign_table_two(id,name,exchange_id) values(24,'qq',105);
insert into foreign_table_two(id,name,exchange_id) values(25,'rr',105);







