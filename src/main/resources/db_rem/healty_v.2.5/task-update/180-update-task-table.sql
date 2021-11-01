ALTER TABLE tasks
ADD COLUMN time_of_day VARCHAR(255);

GO

ALTER TABLE tasks
ADD COLUMN ordered BIGINT UNIQUE;

GO

UPDATE tasks SET time_of_day = 'EVENING' WHERE id = 1;
UPDATE tasks SET time_of_day = 'MORNING' WHERE id = 2;
UPDATE tasks SET time_of_day = 'AFTERNOON' WHERE id = 3;
UPDATE tasks SET time_of_day = 'MORNING' WHERE id = 4;
UPDATE tasks SET time_of_day = 'MORNING' WHERE id = 5;
UPDATE tasks SET time_of_day = 'MORNING' WHERE id = 6;
UPDATE tasks SET time_of_day = 'MORNING' WHERE id = 7;
UPDATE tasks SET time_of_day = 'NIGHT' WHERE id = 8;
UPDATE tasks SET time_of_day = 'NIGHT' WHERE id = 9;

GO

UPDATE tasks SET ordered = 1 WHERE id = 1;
UPDATE tasks SET ordered = 2 WHERE id = 2;
UPDATE tasks SET ordered = 3 WHERE id = 3;
UPDATE tasks SET ordered = 4 WHERE id = 4;
UPDATE tasks SET ordered = 5 WHERE id = 5;
UPDATE tasks SET ordered = 6 WHERE id = 6;
UPDATE tasks SET ordered = 7 WHERE id = 7;
UPDATE tasks SET ordered = 8 WHERE id = 8;
UPDATE tasks SET ordered = 9 WHERE id = 9;