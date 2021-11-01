insert into services_and_items(description, web_view_link, location, section_id)
values
('Постковидный чекап','checkme.ru/post-covid/?utm_source=healtyapp&utm_medium=referal&utm_campaign=promo', 'Moscow', (select id from sections where description = 'Чекапы')),
('Тест на коронавирус','checkme.ru/covid/?utm_source=healtyapp&utm_medium=referal&utm_campaign=promo', 'Moscow', (select id from sections where description = 'Чекапы')),
('Тест на аллергию','checkme.ru/allergic/?utm_source=healtyapp&utm_medium=referal&utm_campaign=promo', 'Moscow', (select id from sections where description = 'Чекапы')),
('Диетологический чекап','checkme.ru/dietetic/?utm_source=healtyapp&utm_medium=referal&utm_campaign=promo', 'Moscow', (select id from sections where description = 'Чекапы')),
('Общий чекап','checkme.ru/complex/?utm_source=healtyapp&utm_medium=referal&utm_campaign=promo', 'Moscow', (select id from sections where description = 'Чекапы')),
('Доставка готовой еды','webviews.healty.app/ru/food', 'Moscow', (select id from sections where description = 'Питание')),
('Спальное место','webviews.healty.app/ru/bluesleep', 'Moscow', (select id from sections where description = 'Сон')),
('Микроэлементы и витамины','webviews.healty.app/ru/biologically_active_additives', 'Moscow', (select id from sections where description = 'Микроэлементы и витамины')),
('Физическая активность','webviews.healty.app/ru/physical_activity', 'Moscow', (select id from sections where description = 'Физическая активность')),
('Климатический зонд','webviews.healty.app/ru/climate', 'Moscow', (select id from sections where description = 'Климат')),
('Женская консультация','webviews.healty.app/ru/women_health', 'Moscow', (select id from sections where description = 'Женское здоровье'));