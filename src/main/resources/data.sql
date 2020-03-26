INSERT INTO room (ID, NAME,ROW_MAX,COLUMN_MAX) VALUES (1,'A',100,100);
INSERT INTO room (ID, NAME,ROW_MAX,COLUMN_MAX) VALUES (2,'B',200,200);
INSERT INTO room (ID, NAME,ROW_MAX,COLUMN_MAX) VALUES (3,'C',50,50);
INSERT INTO room (ID, NAME,ROW_MAX,COLUMN_MAX) VALUES (4,'D',75,75);

INSERT INTO user (ID, NAME, SURNAME,USERNAME) VALUES (5,'Monika','Kowalska','MONA000');
INSERT INTO user (ID, NAME, SURNAME,USERNAME) VALUES (6,'Bartek','Nowacki','BARTOSZ55');
INSERT INTO user (ID, NAME, SURNAME,USERNAME) VALUES (7,'Karolina','Świelub','SOWA88');
INSERT INTO user (ID, NAME, SURNAME,USERNAME) VALUES (8,'Ignacy','Żabka','WRONA33');

INSERT INTO movie (ID, TITLE, DESCRIPTION,DURATION) VALUES (9,'PIES I KOT','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus.',122);
INSERT INTO movie (ID, TITLE, DESCRIPTION,DURATION) VALUES (10,'LATO','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus.',90);
INSERT INTO movie (ID, TITLE, DESCRIPTION,DURATION) VALUES (11,'DZIEŃ','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus.',100);
INSERT INTO movie (ID, TITLE, DESCRIPTION,DURATION) VALUES (12,'MONIKA','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus.',105);

INSERT INTO repertoire (ID, DATE, TIME,MOVIE_ID,ROOM_ID) VALUES (13,'2020-03-30','22:44:00',9,1);
INSERT INTO repertoire (ID, DATE, TIME,MOVIE_ID,ROOM_ID) VALUES (14,'2020-03-29','22:44:00',10,2);
INSERT INTO repertoire (ID, DATE, TIME,MOVIE_ID,ROOM_ID) VALUES (15,'2020-03-29','14:44:00',11,3);
INSERT INTO repertoire (ID, DATE, TIME, MOVIE_ID, ROOM_ID)VALUES (16, '2020-03-29', '14:44:00', 12, 4);
INSERT INTO repertoire (ID, DATE, TIME, MOVIE_ID, ROOM_ID)VALUES (17, '2020-03-30', '15:44:00', 12, 4);

INSERT INTO seat (ID, COLUMN_COUNT, ROW_COUNT,MOVIE_ID,REPERTOIRE_ID,ROOM_ID,USER_ID,IS_PAYED,TICKET_TYPES) VALUES (17,2,2,9,13,1,5,false,'ADULT');
INSERT INTO seat (ID, COLUMN_COUNT, ROW_COUNT,MOVIE_ID,REPERTOIRE_ID,ROOM_ID,USER_ID,IS_PAYED,TICKET_TYPES) VALUES (18,3,3,10,14,2,5,false,'ADULT');
INSERT INTO seat (ID, COLUMN_COUNT, ROW_COUNT,MOVIE_ID,REPERTOIRE_ID,ROOM_ID,USER_ID,IS_PAYED,TICKET_TYPES) VALUES (19,4,4,11,15,3,5,false,'ADULT');
INSERT INTO seat (ID, COLUMN_COUNT, ROW_COUNT,MOVIE_ID,REPERTOIRE_ID,ROOM_ID,USER_ID,IS_PAYED,TICKET_TYPES) VALUES (20,5,5,12,16,4,5,false,'CHILD');
