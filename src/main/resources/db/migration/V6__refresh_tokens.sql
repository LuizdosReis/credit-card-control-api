DROP TABLE IF EXISTS refresh_token;

CREATE TABLE refresh_token
(
  id BIGSERIAL,
  token VARCHAR (50) NOT NULL,
  created_date TIMESTAMP NOT NULL ,
  CONSTRAINT refresh_token_pk PRIMARY KEY (id)
);
