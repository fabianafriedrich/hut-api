CREATE TABLE answer (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  correct_answer bit(1) DEFAULT NULL,
  creation_date datetime DEFAULT NULL,
  dislikes int(11) DEFAULT NULL,
  likes int(11) DEFAULT NULL,
  text varchar(255) DEFAULT NULL,
  fk_post bigint(20) DEFAULT NULL,
  fk_user bigint(20) DEFAULT NULL,
  PRIMARY KEY (id)
  KEY FK2xvlt9hk1x5ksgt4egv0atrja (fk_post),
  KEY FKgwhjrbmdiw2mm30g28v4ec184 (fk_user),
  CONSTRAINT FK2xvlt9hk1x5ksgt4egv0atrja FOREIGN KEY (fk_post) REFERENCES post (id),
  CONSTRAINT FKgwhjrbmdiw2mm30g28v4ec184 FOREIGN KEY (fk_user) REFERENCES user (id)
);

CREATE TABLE answer_image (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  image varchar(255) DEFAULT NULL,
  fk_answer bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKdip2srxop38opn01ogb4j3d39 (fk_answer),
  CONSTRAINT FKdip2srxop38opn01ogb4j3d39 FOREIGN KEY (fk_answer) REFERENCES answer (id)
);

CREATE TABLE answer_report (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  report_type int(11) DEFAULT NULL,
  fk_answer bigint(20) DEFAULT NULL,
  fk_user bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKkgkpnitk2a576l2fon2cuk4rf (fk_answer),
  KEY FKfv21bqd09cmxn9jywj1ne2a9n (fk_user),
  CONSTRAINT FKfv21bqd09cmxn9jywj1ne2a9n FOREIGN KEY (fk_user) REFERENCES user (id),
  CONSTRAINT FKkgkpnitk2a576l2fon2cuk4rf FOREIGN KEY (fk_answer) REFERENCES answer (id)
);

CREATE TABLE answer_vote (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  dislikes int(11) DEFAULT NULL,
  likes int(11) DEFAULT NULL,
  fk_answer bigint(20) DEFAULT NULL,
  fk_user bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKcavssm773qda7h5kxjjb5vixp (fk_answer),
  KEY FKl3dmk3wcrffferxnv4ig8rv5k (fk_user),
  CONSTRAINT FKcavssm773qda7h5kxjjb5vixp FOREIGN KEY (fk_answer) REFERENCES answer (id),
  CONSTRAINT FKl3dmk3wcrffferxnv4ig8rv5k FOREIGN KEY (fk_user) REFERENCES user (id)
);

CREATE TABLE post (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  creation_date datetime DEFAULT NULL,
  description varchar(255) DEFAULT NULL,
  dislikes int(11) DEFAULT NULL,
  likes int(11) DEFAULT NULL,
  status int(11) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  fk_user bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK9kq6xu4w8op8nasciwt7ft8en (fk_user),
  CONSTRAINT FK9kq6xu4w8op8nasciwt7ft8en FOREIGN KEY (fk_user) REFERENCES user (id)
);

CREATE TABLE post_image (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  image varchar(255) DEFAULT NULL,
  fk_post bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK5ycx2le6cx7djgdkhhi63drw6 (fk_post),
  CONSTRAINT FK5ycx2le6cx7djgdkhhi63drw6 FOREIGN KEY (fk_post) REFERENCES post (id)
);

CREATE TABLE post_report (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  report_type int(11) DEFAULT NULL,
  fk_post bigint(20) DEFAULT NULL,
  fk_user bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FKfihq6y73ybr9elkbardnq0wdv (fk_post),
  KEY FK3103er76899nyhnlscqycasjt (fk_user),
  CONSTRAINT FK3103er76899nyhnlscqycasjt FOREIGN KEY (fk_user) REFERENCES user (id),
  CONSTRAINT FKfihq6y73ybr9elkbardnq0wdv FOREIGN KEY (fk_post) REFERENCES post (id)
);

CREATE TABLE post_vote (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  dislikes int(11) DEFAULT NULL,
  likes int(11) DEFAULT NULL,
  fk_post bigint(20) DEFAULT NULL,
  fk_user bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY FK20puv4bvki5wvhu3ax13wbol8 (fk_post),
  KEY FKdv30wj7wb7er3l36tp0gi7gyj (fk_user),
  CONSTRAINT FK20puv4bvki5wvhu3ax13wbol8 FOREIGN KEY (fk_post) REFERENCES post (id),
  CONSTRAINT FKdv30wj7wb7er3l36tp0gi7gyj FOREIGN KEY (fk_user) REFERENCES user (id)
);

CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  email varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  points int(11) NOT NULL,
  PRIMARY KEY (id)
);
