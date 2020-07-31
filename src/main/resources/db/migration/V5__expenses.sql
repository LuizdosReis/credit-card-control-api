DROP TABLE IF EXISTS expenses;

CREATE TABLE expenses
(
  id BIGSERIAL,
  value NUMERIC NOT NULL,
  date TIMESTAMP NOT NULL ,
  user_id  BIGINT NOT NULL,
  CONSTRAINT expenses_pk PRIMARY KEY (id),
  CONSTRAINT expenses_fk_user FOREIGN KEY (user_id) REFERENCES users (id)
);
