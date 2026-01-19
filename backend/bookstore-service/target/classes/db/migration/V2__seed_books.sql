INSERT INTO books (id, title, author, price, in_stock)
VALUES
  ('111', 'Clean Architecture', 'EshwarKV', 40.00, TRUE),
  ('222', 'Effective Java', 'Aparna', 45.00, TRUE)
ON CONFLICT (id) DO NOTHING;
