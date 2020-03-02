CREATE TABLE answer (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  correct_answer bit(1) DEFAULT NULL,
  creation_date datetime DEFAULT NULL,
  dislikes int(11) DEFAULT NULL,
  likes int(11) DEFAULT NULL,
  text varchar(255) DEFAULT NULL,
  fk_post bigint(20) DEFAULT NULL,
  fk_user bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_post FOREIGN KEY (fk_post) REFERENCES post (id),
  CONSTRAINT fk_user FOREIGN KEY (fk_user) REFERENCES user (id)
);

CREATE TABLE answer_image (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  image varchar(255) DEFAULT NULL,
  fk_answer bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_answer FOREIGN KEY (fk_answer) REFERENCES answer (id)
);

CREATE TABLE answer_report (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  report_type int(11) DEFAULT NULL,
  fk_answer bigint(20) DEFAULT NULL,
  fk_user bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_user FOREIGN KEY (fk_user) REFERENCES user (id),
  CONSTRAINT fk_answer FOREIGN KEY (fk_answer) REFERENCES answer (id)
);

CREATE TABLE answer_vote (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  dislikes int(11) DEFAULT NULL,
  likes int(11) DEFAULT NULL,
  fk_answer bigint(20) DEFAULT NULL,
  fk_user bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_answer FOREIGN KEY (fk_answer) REFERENCES answer (id),
  CONSTRAINT fk_user FOREIGN KEY (fk_user) REFERENCES user (id)
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
  CONSTRAINT fk_user FOREIGN KEY (fk_user) REFERENCES user (id)
);

CREATE TABLE post_image (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  image varchar(255) DEFAULT NULL,
  fk_post bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_post FOREIGN KEY (fk_post) REFERENCES post (id)
);

CREATE TABLE post_report (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  report_type int(11) DEFAULT NULL,
  fk_post bigint(20) DEFAULT NULL,
  fk_user bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_user FOREIGN KEY (fk_user) REFERENCES user (id),
  CONSTRAINT fk_post FOREIGN KEY (fk_post) REFERENCES post (id)
);

CREATE TABLE post_vote (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  dislikes int(11) DEFAULT NULL,
  likes int(11) DEFAULT NULL,
  fk_post bigint(20) DEFAULT NULL,
  fk_user bigint(20) DEFAULT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_post FOREIGN KEY (fk_post) REFERENCES post (id),
  CONSTRAINT fk_user FOREIGN KEY (fk_user) REFERENCES user (id)
);

CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  email varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  points int(11) NOT NULL,
  PRIMARY KEY (id)
);
