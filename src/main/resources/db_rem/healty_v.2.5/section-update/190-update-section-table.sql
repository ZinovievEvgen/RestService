ALTER TABLE sections
ADD COLUMN status VARCHAR(255);

GO

UPDATE sections SET status = 'up' WHERE id = 1;
UPDATE sections SET status = 'up' WHERE id = 2;
UPDATE sections SET status = 'up' WHERE id = 3;
UPDATE sections SET status = 'up' WHERE id = 4;
UPDATE sections SET status = 'up' WHERE id = 5;
UPDATE sections SET status = 'up' WHERE id = 6;
UPDATE sections SET status = 'up' WHERE id = 7;
UPDATE sections SET status = 'up' WHERE id = 8;
UPDATE sections SET status = 'up' WHERE id = 9;
UPDATE sections SET status = 'up' WHERE id = 10;
UPDATE sections SET status = 'up' WHERE id = 11;
UPDATE sections SET status = 'up' WHERE id = 12;
UPDATE sections SET status = 'up' WHERE id = 13;
UPDATE sections SET status = 'up' WHERE id = 14;
UPDATE sections SET status = 'up' WHERE id = 15;
UPDATE sections SET status = 'up' WHERE id = 16;

GO