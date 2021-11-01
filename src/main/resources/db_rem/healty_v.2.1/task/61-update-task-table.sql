ALTER TABLE tasks
ADD COLUMN med_level BIGINT;

GO

ALTER TABLE tasks
ADD COLUMN heal_level BIGINT;

GO

UPDATE tasks SET med_level = 1, heal_level = 1 WHERE id = 1;
UPDATE tasks SET med_level = 1, heal_level = 1 WHERE id = 2;
UPDATE tasks SET med_level = 1, heal_level = 1 WHERE id = 3;
UPDATE tasks SET med_level = 1, heal_level = 1 WHERE id = 4;
UPDATE tasks SET med_level = 1, heal_level = 1 WHERE id = 5;
UPDATE tasks SET med_level = 1, heal_level = 1 WHERE id = 6;

GO

insert into task_type(type) values ('Ежегодные');

GO
insert into tasks(description, recommendation, id_task_type, time_to_live, quantity_success, web_view_link, med_level, heal_level)
            values('Пройти общий чекап','Проверьте все важные показатели организма',(select id from task_type where type = 'Ежегодные'),12, 4, 'webviews.healty.app/ru/gen_check', 1, 1);