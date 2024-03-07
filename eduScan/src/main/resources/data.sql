insert into role(id,name,description) values(1,'manager','en charge du dev frontent');
insert into role(id,name,description) values(2,'developpeur','en charge du dev frontent');
insert into role(id,name,description) values(3,'testeur','test intégration');

insert into account_executive (id, pass_word, actif, user_name, first_name, last_name, phone_number, prospecting_zone, prospecting_municipality, photo, superiorn1, superiorn2, superiorn3,role_id) 
VALUES (10, 'my password',true,'abie@imasoftgroup.com','abie', 'gerald', '0597010101', 'riviera', 'cocody', 'photo.jpg', 1, 2, 3,1);

insert into account_executive (id, pass_word, actif, user_name, first_name, last_name, phone_number, prospecting_zone, prospecting_municipality, photo, superiorn1, superiorn2, superiorn3,role_id) 
VALUES (11, 'my password',true,'abie@imasoftgroup.com', 'nelson', 'madiba', '0597010101', 'riviera', 'cocody', 'photo.jpg', 4, 5, 6,2);

insert into account_executive (id, pass_word, actif, user_name, first_name, last_name, phone_number, prospecting_zone, prospecting_municipality, photo, superiorn1, superiorn2, superiorn3,role_id) 
VALUES (12, 'my password',true,'abie@imasoftgroup.com', 'elise', 'mami', '0597010101', 'riviera', 'cocody', 'photo.jpg', 4, 5, 6,3);

INSERT INTO institution_profile (id,school_name, municipality, district, geographic_address, school_type, teaching_type, teaching_level, enrollment, contact_phone, email, has_computer, total_computers, has_internet, connection_type, router_type, telecom_operator, has_computer_room, has_electricity, has_management_software, software_name, visit_time, end_time, school_photo) 
VALUES (1,'ecole', 'municipalite', 'district', 'adresse géographique', 'type ecole', 'type enseignement', 'niveau enseignement', 100, '0123456789', 'exemple@example.com', true, 50, true, 'type de connexion', 'type de routeur', 'operateur tel', true, true, true, 'logiciel de gestion', '09:00:00', '17:00:00', 'photo.jpg');

INSERT INTO agenda (id,visit_date, account_executive_id, institution_id) VALUES (10,'2022-03-01', 10, 1);

INSERT INTO prospection_record (id,school_name, municipality, district, geographic_address, school_type, teaching_type, teaching_level, enrollment, contact_phone, email, has_computer, total_computers, has_internet, connection_type, router_type, telecom_operator, has_computer_room, has_electricity, has_management_software, software_name, visit_time, end_time, school_photo, seniority, first_visit_date, interlocutor_first_name, interlocutor_last_name, interlocutor_function) 
VALUES (1,'my school', 'municipalite', 'district', 'Adresse géographique', 'type ecole', 'type enseignement', 'Niveau', 100, '0123456789', 'exemple@imasoftgroup.com', true, 50, true, 'connexion', 'type routeur', 'operateur', true, true, true, 'logiciel de gestion', '09:00:00', '17:00:00', 'src/image/photo.jpg', 3, '2022-03-01', 'interlocuteur', 'Nom', 'fonction interlocuteur');
