--liquibase formatted sql

insert into tasks(description, recommendation, id_task_type, time_to_live, quantity_success, web_view_link)
            values('Почистить зубы вечером',
            'Верхние зубы нужно чистить двигая зубной щеткой от верха к низу. Нижние зубы нужно чистить двигая зубной щеткой от низа к верху',
            (select id from task_type where type = 'Ежедневные'), 3, 3, 'webviews.healty.app/ru/teeth');

insert into tasks(description, recommendation, id_task_type, time_to_live, quantity_success, web_view_link)
            values('Почистить зубы утром',
            'Верхние зубы нужно чистить двигая зубной щеткой от верха к низу. Нижние зубы нужно чистить двигая зубной щеткой от низа к верху',
            (select id from task_type where type = 'Ежедневные'), 3, 2, 'webviews.healty.app/ru/teeth');

insert into tasks(description, recommendation, id_task_type, time_to_live, quantity_success, web_view_link)
            values('Съесть фрукт',
            'Здоровое питание каждый день',
            (select id from task_type where type = 'Ежедневные'), 3, 4, 'webviews.healty.app/ru/fruits');

insert into tasks(description, recommendation, id_task_type, time_to_live, quantity_success, web_view_link)
            values('Сделать зарядку',
            'Выполняйте упражнения плавно, без резких движений',
            (select id from task_type where type = 'Ежедневные'), 3, 3, 'webviews.healty.app/ru/work-out');

insert into tasks(description, recommendation, id_task_type, time_to_live, quantity_success)
            values('Выпить стакан воды',
            'Рекомендуется пить 2 литра воды в день',
            (select id from task_type where type = 'Ежедневные'), 3, 4);

insert into tasks(description, recommendation, id_task_type, time_to_live, quantity_success)
            values('Пройти 7000 шагов',
            'Движение жизнь',
            (select id from task_type where type = 'Закрепленные'), 3, 4);