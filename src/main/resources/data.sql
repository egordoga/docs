insert into document_package (id, client_name, document_title, inn, passport, version) values ('a1', 'Tom', 'Pravda', '11', '111', 1.00);
insert into document_package (id, client_name, document_title, inn, passport, version) values ('a2', 'Jery', 'Sport', '22', '222', 1.00);
insert into document_package (id, client_name, document_title, inn, passport, version) values ('a3', 'Bill', 'Car', '33', '333', 1.00);
insert into document_package (id, client_name, document_title, inn, passport, version) values ('a4', 'Tom', 'RestApi', '11', '111', 1.00);
insert into document_package (id, client_name, document_title, inn, passport, version) values ('a5', 'Jery', 'Food', '22', '222', 1.00);
insert into document_package (id, client_name, document_title, inn, passport, version) values ('a6', 'Tom', 'Mouse', '11', '111', 1.00);

insert into document (id, account_number, currency, product_type, version) values ('b1', '11', 'UAH', 'Iron', 1.00);
insert into document (id, account_number, currency, product_type, version) values ('b2', '22', 'USD', 'Milk', 1.00);
insert into document (id, account_number, currency, product_type, version) values ('b3', '33', 'USD', 'Paper', 1.00);
insert into document (id, account_number, currency, product_type, version) values ('b4', '44', 'UAH', 'PC', 1.00);
insert into document (id, account_number, currency, product_type, version) values ('b5', '55', 'EUR', 'Iron', 1.00);
insert into document (id, account_number, currency, product_type, version) values ('b6', '66', 'UAH', 'Aluminium', 1.00);
insert into document (id, account_number, currency, product_type, version) values ('b7', '77', 'UAH', 'Plastic', 1.00);
insert into document (id, account_number, currency, product_type, version) values ('b8', '88', 'USD', 'Plastic', 1.00);
insert into document (id, account_number, currency, product_type, version) values ('b9', '99', 'EUR', 'Plastic', 1.00);

insert into relation (id, parent_component, child_component) values ('c1', 'a1', 'b4');
insert into relation (id, parent_component, child_component) values ('c2', 'a2', 'b3');
insert into relation (id, parent_component, child_component) values ('c3', 'a3', 'b2');
insert into relation (id, parent_component, child_component) values ('c4', 'a4', 'b1');
insert into relation (id, parent_component, child_component) values ('c5', 'a5', 'b5');
insert into relation (id, parent_component, child_component) values ('c6', 'a6', 'b5');
insert into relation (id, parent_component, child_component) values ('c7', 'a1', 'b6');
insert into relation (id, parent_component, child_component) values ('c8', 'a5', 'b7');
insert into relation (id, parent_component, child_component) values ('c9', 'a1', 'b8');
