insert into services_and_items(description, web_view_link, location, section_id)
values
('Видеоконсультации с психотерапевтом','webviews.healty.app/ru/yasno', 'Moscow', (select id from sections where description = 'Ментальное здоровье')),
('Гаджеты','webviews.healty.app/ru/gadgets', 'Moscow', (select id from sections where description = 'Гаджеты')),
('Оптика','webviews.healty.app/ru/optics', 'Moscow', (select id from sections where description = 'Оптика')),
('Медицинское страхование путешествий','webviews.healty.app/ru/travel_insurance', 'Moscow', (select id from sections where description = 'Медицинское страхование')),
('Сканирование тела','webviews.healty.app/ru/body_scanner', 'Moscow', (select id from sections where description = 'Инновации')),
('Блоги о здоровье','webviews.healty.app/ru/health_blogs', 'Moscow', (select id from sections where description = 'Блоги о здоровье')),
('Курсы','webviews.healty.app/ru/courses', 'Moscow', (select id from sections where description = 'Курсы')),
('Школа пациента','webviews.healty.app/ru/patient_school', 'Moscow', (select id from sections where description = 'Школа пациента')),
('Стоматология','webviews.healty.app/ru/sport_activities', 'Moscow', (select id from sections where description = 'Стоматология')),
('Спортивные товары','webviews.healty.app/ru/sporting_good', 'Moscow', (select id from sections where description = 'Спортивные товары')),
('Релакс','webviews.healty.app/ru/relaxation', 'Moscow', (select id from sections where description = 'Релакс'));