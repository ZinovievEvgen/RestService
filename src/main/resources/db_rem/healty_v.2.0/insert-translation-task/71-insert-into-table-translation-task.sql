--english
insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Brush your teeth in the evening',
            'The upper teeth should be brushed by moving the toothbrush from top to bottom. The lower teeth need to be brushed by moving the toothbrush from the bottom up.',
            'webviews.healty.app/en/teeth',
            'english',
            'en',
            (select id from tasks where id = 1));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Brush your teeth in the morning',
            'The upper teeth should be brushed by moving the toothbrush from top to bottom. The lower teeth need to be brushed by moving the toothbrush from the bottom up.',
            'webviews.healty.app/en/teeth',
            'english',
            'en',
            (select id from tasks where id = 2));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Eat the fruit',
            'Healthy eating every day',
            'webviews.healty.app/en/fruits',
            'english',
            'en',
            (select id from tasks where id = 3));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Do your morning exercises',
            'Exercise smoothly without jerky movements',
            'webviews.healty.app/en/work-out',
            'english',
            'en',
            (select id from tasks where id = 4));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('Lets drink water',
            'Drink one glass of water every day',
            'english',
            'en',
            (select id from tasks where id = 5));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('Complete 7000 steps',
            'Movement is life',
            'english',
            'en',
            (select id from tasks where id = 6));

--french
insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Brossez-vous les dents le soir',
            'Brossez vos dents supérieures en déplaçant votre brosse à dents de haut en bas. Les dents inférieures doivent être brossées en déplaçant la brosse à dents de bas en haut',
            'webviews.healty.app/fr/teeth',
            'french',
            'fr',
            (select id from tasks where id = 1));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Brossez-vous les dents le matin',
            'Brossez vos dents supérieures en déplaçant votre brosse à dents de haut en bas. Les dents inférieures doivent être brossées en déplaçant la brosse à dents de bas en haut',
            'webviews.healty.app/fr/teeth',
            'french',
            'fr',
            (select id from tasks where id = 2));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Mangez des fruits',
            'Une alimentation saine tous les jours',
            'webviews.healty.app/fr/fruits',
            'french',
            'fr',
            (select id from tasks where id = 3));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Faites vos exercices du matin',
            'Faites de l exercice en douceur sans secousses',
            'webviews.healty.app/fr/work-out',
            'french',
            'fr',
            (select id from tasks where id = 4));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('Boire 1 verre deau',
            'Buvez chaque jour 1 verre deau',
            'french',
            'fr',
            (select id from tasks where id = 5));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('Marcher 7000 étapes',
            'Mouvement vie',
            'french',
            'fr',
            (select id from tasks where id = 6));

--germany
insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Putzen Sie abends Ihre Zähne',
            'BDie oberen Zähne sollten geputzt werden, indem die Zahnbürste von oben nach unten bewegt wird. Die unteren Zähne müssen geputzt werden, indem die Zahnbürste von unten nach oben bewegt wird.',
            'webviews.healty.app/de/teeth',
            'deutsch',
            'de',
            (select id from tasks where id = 1));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Putzen Sie morgens Ihre Zähne',
            'BDie oberen Zähne sollten geputzt werden, indem die Zahnbürste von oben nach unten bewegt wird. Die unteren Zähne müssen geputzt werden, indem die Zahnbürste von unten nach oben bewegt wird.',
            'webviews.healty.app/de/teeth',
            'deutsch',
            'de',
            (select id from tasks where id = 2));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Früchte essen',
            'Jeden Tag gesund essen',
            'webviews.healty.app/de/fruits',
            'deutsch',
            'de',
            (select id from tasks where id = 3));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Morgengymnastik machen',
            'Trainieren Sie reibungslos ohne ruckartige Bewegungen',
            'webviews.healty.app/de/work-out',
            'deutsch',
            'de',
            (select id from tasks where id = 4));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('Ein Glas Wasser trinken',
            'Trinken Sie ein Glas Wasser Es wird empfohlen, 2 Liter Wasser pro Tag zu trinken',
            'deutsch',
            'de',
            (select id from tasks where id = 5));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('Gehen Sie 7000 Schritte',
            'Bewegung Leben',
            'deutsch',
            'de',
            (select id from tasks where id = 6));

--japan
insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('夕方に歯を磨く',
            '歯ブラシを上から下に動かして、上歯を磨く必要があります。 下の歯は、歯ブラシを下から上に動かしてブラッシングする必要があります。',
            'webviews.healty.app/ja/teeth',
            'japan',
            'ja',
            (select id from tasks where id = 1));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('朝に歯を磨く',
            '歯ブラシを上から下に動かして、上歯を磨く必要があります。 下の歯は、歯ブラシを下から上に動かしてブラッシングする必要があります。',
            'webviews.healty.app/ja/teeth',
            'japan',
            'ja',
            (select id from tasks where id = 2));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('果物を食べる',
            '毎日健康的な食事',
            'webviews.healty.app/ja/fruits',
            'japan',
            'ja',
            (select id from tasks where id = 3));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('演習を行う',
            'ぎくしゃくした動きなしでスムーズに運動する',
            'webviews.healty.app/ja/work-out',
            'japan',
            'ja',
            (select id from tasks where id = 4));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('完全な 7000 のステップ',
            '動きの生命',
            'japan',
            'ja',
            (select id from tasks where id = 6));

--spain
insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Cepíllate los dientes por la noche',
            'Los dientes superiores deben cepillarse moviendo el cepillo de arriba hacia abajo. Los dientes inferiores deben cepillarse moviendo el cepillo de abajo hacia arriba.',
            'webviews.healty.app/es/teeth',
            'spain',
            'es',
            (select id from tasks where id = 1));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Cepíllate los dientes por la mañana',
            'Los dientes superiores deben cepillarse moviendo el cepillo de arriba hacia abajo. Los dientes inferiores deben cepillarse moviendo el cepillo de abajo hacia arriba.',
            'webviews.healty.app/es/teeth',
            'spain',
            'es',
            (select id from tasks where id = 2));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Comer fruta',
            'Alimentación saludable todos los días',
            'webviews.healty.app/es/fruits',
            'spain',
            'es',
            (select id from tasks where id = 3));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Haz tus ejercicios matutinos',
            'Haga ejercicio suavemente sin movimientos espasmódicos',
            'webviews.healty.app/es/work-out',
            'spain',
            'es',
            (select id from tasks where id = 4));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('Camine 7000 pasos',
            'Movimiento vida',
            'spain',
            'es',
            (select id from tasks where id = 6));

--china
insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('晚上刷牙',
            '应该通过将牙刷从上到下移动来刷洗上部牙齿。 需要通过从底部到顶部移动牙刷来刷洗下部牙齿。',
            'webviews.healty.app/zh/teeth',
            'china',
            'zh',
            (select id from tasks where id = 1));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('早上刷牙',
            '应该通过将牙刷从上到下移动来刷洗上部牙齿。 需要通过从底部到顶部移动牙刷来刷洗下部牙齿。',
            'webviews.healty.app/zh/teeth',
            'china',
            'zh',
            (select id from tasks where id = 2));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('吃水果',
            '每天健康饮食',
            'webviews.healty.app/zh/fruits',
            'china',
            'zh',
            (select id from tasks where id = 3));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('做早操',
            '平稳运动而无剧烈运动',
            'webviews.healty.app/zh/work-out',
            'china',
            'zh',
            (select id from tasks where id = 4));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('完成 7000 个步骤',
            '运动寿命',
            'china',
            'zh',
            (select id from tasks where id = 6));

--korea
insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('저녁에 양치질',
            '칫솔을 위에서 아래로 움직여 윗니를 닦아야합니다. 아래 치아는 칫솔을 아래에서 위로 움직여서 닦을 필요가 있습니다.',
            'webviews.healty.app/ko/teeth',
            'korea',
            'ko',
            (select id from tasks where id = 1));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('아침에 양치질',
            '칫솔을 위에서 아래로 움직여 윗니를 닦아야합니다. 아래 치아는 칫솔을 아래에서 위로 움직여서 닦을 필요가 있습니다.',
            'webviews.healty.app/ko/teeth',
            'korea',
            'ko',
            (select id from tasks where id = 2));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('과일 먹기',
            '매일 건강한 식생활',
            'webviews.healty.app/ko/fruits',
            'korea',
            'ko',
            (select id from tasks where id = 3));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('아침 운동을하십시오',
            '갑작스러운 움직임없이 부드럽게 운동',
            'webviews.healty.app/ko/work-out',
            'korea',
            'ko',
            (select id from tasks where id = 4));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('7000 단계 완료',
            '운동 생활',
            'korea',
            'ko',
            (select id from tasks where id = 6));
--portugal
insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Escove os dentes à noite',
            'Os dentes superiores devem ser escovados movendo a escova de cima para baixo. Os dentes inferiores precisam ser escovados movendo a escova de baixo para cima.',
            'webviews.healty.app/pt/teeth',
            'portugal',
            'pt',
            (select id from tasks where id = 1));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Escove os dentes de manhã',
            'Os dentes superiores devem ser escovados movendo a escova de cima para baixo. Os dentes inferiores precisam ser escovados movendo a escova de baixo para cima.',
            'webviews.healty.app/pt/teeth',
            'portugal',
            'pt',
            (select id from tasks where id = 2));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Coma fruta',
            'Alimentação saudável todos os dias',
            'webviews.healty.app/pt/fruits',
            'portugal',
            'pt',
            (select id from tasks where id = 3));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Faça seus exercícios matinais',
            'Exercite-se suavemente, sem movimentos bruscos',
            'webviews.healty.app/pt/work-out',
            'portugal',
            'pt',
            (select id from tasks where id = 4));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('Caminhe 7000 passos',
            'Movimento vida',
            'portugal',
            'pt',
            (select id from tasks where id = 6));
--hindi
insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('शाम को अपने दांतों को ब्रश करें',
            'ऊपरी दांतों को ऊपर से नीचे तक टूथब्रश को घुमाकर ब्रश करना चाहिए। निचले दांतों को नीचे से ऊपर तक टूथब्रश को घुमाकर ब्रश करने की आवश्यकता होती है।',
            'webviews.healty.app/hi/teeth',
            'hindi',
            'hi',
            (select id from tasks where id = 1));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('सुबह अपने दांतों को ब्रश करें',
            'ऊपरी दांतों को ऊपर से नीचे तक टूथब्रश को घुमाकर ब्रश करना चाहिए। निचले दांतों को नीचे से ऊपर तक टूथब्रश को घुमाकर ब्रश करने की आवश्यकता होती है।',
            'webviews.healty.app/hi/teeth',
            'hindi',
            'hi',
            (select id from tasks where id = 2));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('फल खाओ',
            'हर दिन स्वस्थ भोजन',
            'webviews.healty.app/hi/fruits',
            'hindi',
            'hi',
            (select id from tasks where id = 3));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('अपनी सुबह व्यायाम करें',
            'झटकेदार आंदोलनों के बिना आसानी से व्यायाम करें',
            'webviews.healty.app/hi/work-out',
            'hindi',
            'hi',
            (select id from tasks where id = 4));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('7000 चरणों को पूरा करें',
            'आंदोलन जीवन',
            'hindi',
            'hi',
            (select id from tasks where id = 6));
--arabian
insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('اغسل أسنانك بالفرشاة في المساء',
            'جب تنظيف الأسنان العلوية بتحريك فرشاة الأسنان من أعلى إلى أسفل. يجب تنظيف الأسنان السفلية عن طريق تحريك الفرشاة من الأسفل إلى الأعلى.',
            'webviews.healty.app/ar/teeth',
            'arabian',
            'ar',
            (select id from tasks where id = 1));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('اغسل أسنانك بالفرشاة في الصباح',
            'جب تنظيف الأسنان العلوية بتحريك فرشاة الأسنان من أعلى إلى أسفل. يجب تنظيف الأسنان السفلية عن طريق تحريك الفرشاة من الأسفل إلى الأعلى.',
            'webviews.healty.app/ar/teeth',
            'arabian',
            'ar',
            (select id from tasks where id = 2));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('أكل الفاكهة',
            'الأكل الصحي كل يوم',
            'webviews.healty.app/ar/fruits',
            'arabian',
            'ar',
            (select id from tasks where id = 3));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('قم بتمارينك الصباحية',
            'تمرن بسلاسة دون حركات متشنجة',
            'webviews.healty.app/ar/work-out',
            'arabian',
            'ar',
            (select id from tasks where id = 4));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('أكمل 7000 خطوة',
            'حركة الحياة',
            'arabian',
            'ar',
            (select id from tasks where id = 6));

--italian
insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Lavarsi i denti la sera',
            'I denti superiori devono essere puliti spostando lo spazzolino da denti dall alto verso il basso. I denti inferiori devono essere puliti quando si muove lo spazzolino da denti dal basso verso l alto',
            'webviews.healty.app/it/teeth',
            'italian',
            'it',
            (select id from tasks where id = 1));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Lavarsi i denti al mattino',
            'I denti superiori devono essere puliti spostando lo spazzolino da denti dall alto verso il basso. I denti inferiori devono essere puliti quando si muove lo spazzolino da denti dal basso verso l alto',
            'webviews.healty.app/it/teeth',
            'italian',
            'it',
            (select id from tasks where id = 2));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Mangiare frutta',
            'Mangiare sano ogni giorno',
            'webviews.healty.app/it/fruits',
            'italian',
            'it',
            (select id from tasks where id = 3));

insert into translation_task(
            description_lang,
            recommendation_lang,
            view_links_lang,
            language,
            lang,
            task_id)
            values('Fare la ricarica',
            'Esegui gli esercizi senza intoppi, senza movimenti bruschi',
            'webviews.healty.app/it/work-out',
            'italian',
            'it',
            (select id from tasks where id = 4));

insert into translation_task(
            description_lang,
            recommendation_lang,
            language,
            lang,
            task_id)
            values('Passi 7000 punti',
            'Movimento vita',
            'italian',
            'it',
            (select id from tasks where id = 6));