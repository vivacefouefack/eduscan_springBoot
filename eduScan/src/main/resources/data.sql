insert into role(id,name,description) values(1,'manager','en charge du dev frontent');
insert into role(id,name,description) values(2,'developpeur','en charge du dev frontent');
insert into role(id,name,description) values(3,'testeur','test intégration');

insert into account_executive (id, first_name, last_name, phone_number, prospecting_zone, prospecting_municipality, photo, superiorn1, superiorn2, superiorn3,role_id) 
VALUES (10, 'abie', 'gerald', '0597010101', 'riviera', 'cocody', 'photo.jpg', 1, 2, 3,1);

insert into account_executive (id, first_name, last_name, phone_number, prospecting_zone, prospecting_municipality, photo, superiorn1, superiorn2, superiorn3,role_id) 
VALUES (11, 'nelson', 'madiba', '0597010101', 'riviera', 'cocody', 'photo.jpg', 4, 5, 6,2);

insert into account_executive (id, first_name, last_name, phone_number, prospecting_zone, prospecting_municipality, photo, superiorn1, superiorn2, superiorn3,role_id) 
VALUES (12, 'elise', 'mami', '0597010101', 'riviera', 'cocody', 'photo.jpg', 4, 5, 6,null);







