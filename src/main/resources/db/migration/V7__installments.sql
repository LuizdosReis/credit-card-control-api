DROP TABLE IF EXISTS installments;

CREATE TABLE installments
(
  id BIGSERIAL,
  value NUMERIC NOT NULL,
  date TIMESTAMP NOT NULL ,
  expense_id  BIGINT NOT NULL,
  CONSTRAINT installments_pk PRIMARY KEY (id),
  CONSTRAINT installments_fk_expense FOREIGN KEY (expense_id) REFERENCES expenses (id)
);