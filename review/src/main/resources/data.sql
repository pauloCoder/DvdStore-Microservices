INSERT INTO APP_USER (USERNAME) VALUES 
	('John Doe'),
	('Tom Pike'),
	('Elton James'),
	('Bobby Wing');

INSERT INTO REVIEW (ID_MOVIE,ID_REVIEWER,MARK,REVIEW_COMMENT) VALUES 
  (1,(select ID from APP_USER where USERNAME='John Doe'),2,'Franchement ce film est pas terrible'),
  (1,(select ID from APP_USER where USERNAME='Tom Pike'),5,'Super cool pour les enfants !'),
  (1,(select ID from APP_USER where USERNAME='Elton James'),5,NULL),
  (2,(select ID from APP_USER where USERNAME='John Doe'),4,'J''ai bien rigolé'),
  (2,(select ID from APP_USER where USERNAME='Tom Pike'),3,NULL),
  (3,(select ID from APP_USER where USERNAME='Elton James'),1,'Ce film est trop violent pour moi.'),
  (4,(select ID from APP_USER where USERNAME='Bobby Wing'),5,NULL),
  (4,(select ID from APP_USER where USERNAME='Tom Pike'),4,'Ca c''est du cinéma');