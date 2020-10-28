DROP VIEW IF EXISTS view_expenses_and_installments;

CREATE OR REPLACE VIEW view_expenses_and_installments
AS SELECT e.id AS expense_id, e.date, e.value, e.user_id from expenses e LEFT JOIN installments i ON e.id = i.expense_id WHERE i.id IS NULL
UNION
SELECT e.id AS expense_id, i.date, i.value, e.user_id FROM expenses e LEFT JOIN installments i ON e.id  = i.expense_id WHERE i.id IS NOT NULL;