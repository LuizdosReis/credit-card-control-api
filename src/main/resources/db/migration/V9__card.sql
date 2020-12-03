DROP TABLE IF EXISTS cards;

CREATE TABLE cards
(
  id BIGSERIAL,
  name VARCHAR (50) NOT NULL,
  user_id BIGINT NOT NULL,
  CONSTRAINT account_pk PRIMARY KEY (id),
  CONSTRAINT account_fk_client FOREIGN KEY (user_id) REFERENCES users (id)
);