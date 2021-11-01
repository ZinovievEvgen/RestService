ALTER TABLE tasks
ADD COLUMN count_friend BIGINT;

GO

UPDATE tasks SET count_friend = 0 WHERE id = 1;
UPDATE tasks SET count_friend = 0 WHERE id = 2;
UPDATE tasks SET count_friend = 0 WHERE id = 3;
UPDATE tasks SET count_friend = 0 WHERE id = 4;
UPDATE tasks SET count_friend = 0 WHERE id = 5;
UPDATE tasks SET count_friend = 0 WHERE id = 6;
UPDATE tasks SET count_friend = 0 WHERE id = 7;