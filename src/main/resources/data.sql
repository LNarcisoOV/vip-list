DROP TABLE IF EXISTS INVITED;
 
CREATE TABLE INVITED (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  NAME VARCHAR(250) NOT NULL,
  EMAIL VARCHAR(250) NOT NULL,
  TELEPHONE VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO INVITED (NAME, EMAIL, TELEPHONE) VALUES
  ('ALIKO', 'DANGOTE@TEST.COM', '32324548'),
  ('BILL', 'GATES@TEST.COM', '998876432'),
  ('FOLRUNSHO', 'ALAKIJA@GMAIL.COM', '32325566');