package helback.init;

import helback.service.PersonService;
import helback.service.TaskService;
import helback.service.TaskTypeService;
import helback.service.TranslationTaskService;

import javax.annotation.PostConstruct;


public class InitService {
    private final PersonService personService;
    private final TaskService taskService;
    private final TaskTypeService taskTypeService;
    private final TranslationTaskService translationTaskService;

    public InitService(PersonService personService, TaskService taskService, TaskTypeService taskTypeService, TranslationTaskService translationTaskService) {
        this.personService = personService;
        this.taskService = taskService;
        this.taskTypeService = taskTypeService;
        this.translationTaskService = translationTaskService;
    }

    @PostConstruct
    public void init() throws Exception {
        //initData();
    }

    public void initData() throws Exception {
        /*TaskType taskType1 = new TaskType();
        taskType1.setType("Ежедневные");

        TaskType taskType2 = new TaskType();
        taskType2.setType("Еженедельные");

        TaskType taskType3 = new TaskType();
        taskType3.setType("Ежемесячные");

        TaskType taskType4 = new TaskType();
        taskType4.setType("Закрепленные");

        taskTypeService.addTaskType(taskType1);
        taskTypeService.addTaskType(taskType2);
        taskTypeService.addTaskType(taskType3);
        taskTypeService.addTaskType(taskType4);

        TaskDTO task1 = new TaskDTO();
        task1.setDescription("Почистить зубы вечером");
        task1.setRecommendation("Верхние зубы нужно чистить двигая зубной щеткой от верха к низу. Нижние зубы нужно чистить двигая зубной щеткой от низа к верху");
        task1.setQuantitySuccess(10);
        task1.setTimeToLive(3);
        task1.setViewLinks("webviews.healty.app/ru/teeth");


        taskService.addTask(task1);

        TaskDTO task2 = new TaskDTO();
        task2.setDescription("Почистить зубы утром");
        task2.setRecommendation("Верхние зубы нужно чистить двигая зубной щеткой от верха к низу. Нижние зубы нужно чистить двигая зубной щеткой от низа к верху");
        task2.setQuantitySuccess(10);
        task2.setTimeToLive(3);
        task2.setViewLinks("webviews.healty.app/ru/teeth");

        taskService.addTask(task2);

        TaskDTO task3 = new TaskDTO();
        task3.setDescription("Съесть фрукт");
        task3.setRecommendation("Здоровое питание каждый день");
        task3.setQuantitySuccess(10);
        task3.setTimeToLive(3);
        task3.setViewLinks("webviews.healty.app/ru/fruits");

        taskService.addTask(task3);

        TaskDTO task4 = new TaskDTO();
        task4.setDescription("Сделать зарядку");
        task4.setRecommendation("Выполняйте упражнения плавно, без резких движений");
        task4.setQuantitySuccess(10);
        task4.setTimeToLive(3);
        task4.setViewLinks("webviews.healty.app/ru/work-out");

        taskService.addTask(task4);

        TaskDTO task5 = new TaskDTO();
        task5.setDescription("Выпить стакан воды");
        task5.setRecommendation("Рекомендуется пить 2 литра воды в день");
        task5.setQuantitySuccess(10);
        task5.setTimeToLive(3);

        taskService.addTask(task5);

        TaskDTO task6 = new TaskDTO();
        task6.setDescription("Пройти 7000 шагов");
        task6.setRecommendation("Движение жизнь");
        task6.setQuantitySuccess(10);
        task6.setTimeToLive(3);

        taskService.addTask(task6);

        PersonDTO person1 = new PersonDTO("user1", "user1@mail.ru", "user1");
        person1.setUniqueId("e9c9719c-9c8c-11eb-a8b3-0242ac130003");
        person1.setCountry("Russia");
        person1.setCity("Moscow");

        personService.addPerson(person1);

        PersonDTO person2 = new PersonDTO("user2", "user2@mail.ru", "user2");
        person2.setUniqueId("dc07971e-9c8c-11eb-a8b3-0242ac130003");
        person2.setCountry("Germany");
        person2.setCity("Berlin");

        personService.addPerson(person2);

        PersonDTO person3 = new PersonDTO("user3", "user3@mail.ru", "user3");
        person3.setUniqueId("e49ad170-9c8c-11eb-a8b3-0242ac130003");
        person3.setCountry("Japan");
        person3.setCity("Tokyo");

        personService.addPerson(person3);

        PersonDTO person4 = new PersonDTO("user4", "user4@mail.ru", "user4");
        person4.setUniqueId("ef96beea-9c8c-11eb-a8b3-0242ac130003");
        person4.setCountry("USA");
        person4.setCity("New-York");

        personService.addPerson(person4);

        //english
        TranslationTask translationTask1 = new TranslationTask();
        translationTask1.setDescriptionLang("Brush your teeth in the evening");
        translationTask1.setRecommendationLang("The upper teeth should be brushed by moving the toothbrush from top to bottom. " +
                "The lower teeth need to be brushed by moving the toothbrush from the bottom up.");
        translationTask1.setViewLinksLang("webviews.healty.app/en/teeth");
        translationTask1.setLanguage("english");
        translationTask1.setLang("en");
        translationTask1.setTask(taskService.getTaskById(52L));

        translationTaskService.addTranslationTask(translationTask1);

        TranslationTask translationTask2 = new TranslationTask();
        translationTask2.setDescriptionLang("Brush your teeth in the morning");
        translationTask2.setRecommendationLang("The upper teeth should be brushed by moving the toothbrush from top to bottom. " +
                "The lower teeth need to be brushed by moving the toothbrush from the bottom up.");
        translationTask2.setViewLinksLang("webviews.healty.app/en/teeth");
        translationTask2.setLanguage("english");
        translationTask2.setLang("en");
        translationTask2.setTask(taskService.getTaskById(53L));

        translationTaskService.addTranslationTask(translationTask2);

        TranslationTask translationTask3 = new TranslationTask();
        translationTask3.setDescriptionLang("Eat the fruit");
        translationTask3.setRecommendationLang("Healthy eating every day");
        translationTask3.setViewLinksLang("webviews.healty.app/en/fruits");
        translationTask3.setLanguage("english");
        translationTask3.setLang("en");
        translationTask3.setTask(taskService.getTaskById(54L));

        translationTaskService.addTranslationTask(translationTask3);

        TranslationTask translationTask4 = new TranslationTask();
        translationTask4.setDescriptionLang("Do your morning exercises");
        translationTask4.setRecommendationLang("Exercise smoothly without jerky movements");
        translationTask4.setViewLinksLang("webviews.healty.app/en/work-out");
        translationTask4.setLanguage("english");
        translationTask4.setLang("en");
        translationTask4.setTask(taskService.getTaskById(55L));

        translationTaskService.addTranslationTask(translationTask4);

        TranslationTask translationTask5 = new TranslationTask();
        translationTask5.setDescriptionLang("Lets drink water");
        translationTask5.setRecommendationLang("Drink one glass of water every day");
        translationTask5.setLanguage("english");
        translationTask5.setLang("en");
        translationTask5.setTask(taskService.getTaskById(56L));

        translationTaskService.addTranslationTask(translationTask5);

        TranslationTask translationTask6 = new TranslationTask();
        translationTask6.setDescriptionLang("Complete 7000 steps");
        translationTask6.setRecommendationLang("Movement is life");
        translationTask6.setLanguage("english");
        translationTask6.setLang("en");
        translationTask6.setTask(taskService.getTaskById(57L));

        translationTaskService.addTranslationTask(translationTask6);

        //french
        TranslationTask translationTask11 = new TranslationTask();
        translationTask11.setDescriptionLang("Brossez-vous les dents le soir");
        translationTask11.setRecommendationLang("Brossez vos dents supérieures en déplaçant votre brosse à dents de haut en bas. " +
                "Les dents inférieures doivent être brossées en déplaçant la brosse à dents de bas en haut");
        translationTask11.setViewLinksLang("webviews.healty.app/fr/teeth");
        translationTask11.setLanguage("french");
        translationTask11.setLang("fr");
        translationTask11.setTask(taskService.getTaskById(52L));

        translationTaskService.addTranslationTask(translationTask11);

        TranslationTask translationTask12 = new TranslationTask();
        translationTask12.setDescriptionLang("Brossez-vous les dents le matin");
        translationTask12.setRecommendationLang("Brossez vos dents supérieures en déplaçant votre brosse à dents de haut en bas. " +
                "Les dents inférieures doivent être brossées en déplaçant la brosse à dents de bas en haut");
        translationTask12.setViewLinksLang("webviews.healty.app/fr/teeth");
        translationTask12.setLanguage("french");
        translationTask12.setLang("fr");
        translationTask12.setTask(taskService.getTaskById(53L));

        translationTaskService.addTranslationTask(translationTask12);

        TranslationTask translationTask13 = new TranslationTask();
        translationTask13.setDescriptionLang("Mangez des fruits");
        translationTask13.setRecommendationLang("Une alimentation saine tous les jours");
        translationTask13.setViewLinksLang("webviews.healty.app/fr/fruits");
        translationTask13.setLanguage("french");
        translationTask13.setLang("fr");
        translationTask13.setTask(taskService.getTaskById(54L));

        translationTaskService.addTranslationTask(translationTask13);

        TranslationTask translationTask14 = new TranslationTask();
        translationTask14.setDescriptionLang("Faites vos exercices du matin");
        translationTask14.setRecommendationLang("Faites de l'exercice en douceur sans secousses");
        translationTask14.setViewLinksLang("webviews.healty.app/fr/work-out");
        translationTask14.setLanguage("french");
        translationTask14.setLang("fr");
        translationTask14.setTask(taskService.getTaskById(55L));

        translationTaskService.addTranslationTask(translationTask14);

        TranslationTask translationTask15 = new TranslationTask();
        translationTask15.setDescriptionLang("Boire 1 verre d'eau");
        translationTask15.setRecommendationLang("Buvez chaque jour 1 verre d'eau");
        translationTask15.setLanguage("french");
        translationTask15.setLang("fr");
        translationTask15.setTask(taskService.getTaskById(56L));

        translationTaskService.addTranslationTask(translationTask15);

        TranslationTask translationTask16 = new TranslationTask();
        translationTask16.setDescriptionLang("Marcher 7000 étapes");
        translationTask16.setRecommendationLang("Mouvement vie");
        translationTask16.setLanguage("french");
        translationTask16.setLang("fr");
        translationTask16.setTask(taskService.getTaskById(57L));

        translationTaskService.addTranslationTask(translationTask16);

        //germany
        TranslationTask translationTask21 = new TranslationTask();
        translationTask21.setDescriptionLang("Putzen Sie abends Ihre Zähne");
        translationTask21.setRecommendationLang("BDie oberen Zähne sollten geputzt werden, indem die " +
                "Zahnbürste von oben nach unten bewegt wird. Die unteren Zähne müssen geputzt werden, " +
                "indem die Zahnbürste von unten nach oben bewegt wird.");
        translationTask21.setViewLinksLang("webviews.healty.app/de/teeth");
        translationTask21.setLanguage("deutsch");
        translationTask21.setLang("de");
        translationTask21.setTask(taskService.getTaskById(52L));

        translationTaskService.addTranslationTask(translationTask21);

        TranslationTask translationTask22 = new TranslationTask();
        translationTask22.setDescriptionLang("Putzen Sie morgens Ihre Zähne");
        translationTask22.setRecommendationLang("BDie oberen Zähne sollten geputzt werden, indem die " +
                "Zahnbürste von oben nach unten bewegt wird. Die unteren Zähne müssen geputzt werden, " +
                "indem die Zahnbürste von unten nach oben bewegt wird.");
        translationTask22.setViewLinksLang("webviews.healty.app/de/teeth");
        translationTask22.setLanguage("deutsch");
        translationTask22.setLang("de");
        translationTask22.setTask(taskService.getTaskById(53L));

        translationTaskService.addTranslationTask(translationTask22);

        TranslationTask translationTask23 = new TranslationTask();
        translationTask23.setDescriptionLang("Früchte essen");
        translationTask23.setRecommendationLang("Jeden Tag gesund essen");
        translationTask23.setViewLinksLang("webviews.healty.app/de/fruits");
        translationTask23.setLanguage("deutsch");
        translationTask23.setLang("de");
        translationTask23.setTask(taskService.getTaskById(54L));

        translationTaskService.addTranslationTask(translationTask23);

        TranslationTask translationTask24 = new TranslationTask();
        translationTask24.setDescriptionLang("Morgengymnastik machen");
        translationTask24.setRecommendationLang("Trainieren Sie reibungslos ohne ruckartige Bewegungen");
        translationTask24.setViewLinksLang("webviews.healty.app/de/work-out");
        translationTask24.setLanguage("deutsch");
        translationTask24.setLang("de");
        translationTask24.setTask(taskService.getTaskById(55L));

        translationTaskService.addTranslationTask(translationTask24);

        TranslationTask translationTask25 = new TranslationTask();
        translationTask25.setDescriptionLang("Ein Glas Wasser trinken");
        translationTask25.setRecommendationLang("Trinken Sie ein Glas Wasser \" Es wird empfohlen, 2 Liter Wasser pro Tag zu trinken");
        translationTask25.setLanguage("deutsch");
        translationTask25.setLang("de");
        translationTask25.setTask(taskService.getTaskById(56L));

        translationTaskService.addTranslationTask(translationTask25);

        TranslationTask translationTask26 = new TranslationTask();
        translationTask26.setDescriptionLang("Gehen Sie 7000 Schritte");
        translationTask26.setRecommendationLang("Bewegung Leben");
        translationTask26.setLanguage("deutsch");
        translationTask26.setLang("de");
        translationTask26.setTask(taskService.getTaskById(57L));

        translationTaskService.addTranslationTask(translationTask26);

        //japan
        TranslationTask translationTask31 = new TranslationTask();
        translationTask31.setDescriptionLang("夕方に歯を磨く");
        translationTask31.setRecommendationLang("歯ブラシを上から下に動かして、上歯を磨く必要があります。 下の歯は、歯ブラシを下から上に動かしてブラッシングする必要があります。");
        translationTask31.setViewLinksLang("webviews.healty.app/ja/teeth");
        translationTask31.setLanguage("japan");
        translationTask31.setLang("ja");
        translationTask31.setTask(taskService.getTaskById(52L));

        translationTaskService.addTranslationTask(translationTask31);

        TranslationTask translationTask32 = new TranslationTask();
        translationTask32.setDescriptionLang("朝に歯を磨く");
        translationTask32.setRecommendationLang("歯ブラシを上から下に動かして、上歯を磨く必要があります。 下の歯は、歯ブラシを下から上に動かしてブラッシングする必要があります。");
        translationTask32.setViewLinksLang("webviews.healty.app/ja/teeth");
        translationTask32.setLanguage("japan");
        translationTask32.setLang("ja");
        translationTask32.setTask(taskService.getTaskById(53L));

        translationTaskService.addTranslationTask(translationTask32);

        TranslationTask translationTask33 = new TranslationTask();
        translationTask33.setDescriptionLang("果物を食べる");
        translationTask33.setRecommendationLang("毎日健康的な食事");
        translationTask33.setViewLinksLang("webviews.healty.app/ja/fruits");
        translationTask33.setLanguage("japan");
        translationTask33.setLang("ja");
        translationTask33.setTask(taskService.getTaskById(54L));

        translationTaskService.addTranslationTask(translationTask33);

        TranslationTask translationTask34 = new TranslationTask();
        translationTask34.setDescriptionLang("演習を行う");
        translationTask34.setRecommendationLang("ぎくしゃくした動きなしでスムーズに運動する");
        translationTask34.setViewLinksLang("webviews.healty.app/ja/work-out");
        translationTask34.setLanguage("japan");
        translationTask34.setLang("ja");
        translationTask34.setTask(taskService.getTaskById(55L));
        translationTaskService.addTranslationTask(translationTask34);

        TranslationTask translationTask36 = new TranslationTask();
        translationTask36.setDescriptionLang("完全な7000のステップ");
        translationTask36.setRecommendationLang("動きの生命");
        translationTask36.setLanguage("japan");
        translationTask36.setLang("ja");
        translationTask36.setTask(taskService.getTaskById(57L));

        translationTaskService.addTranslationTask(translationTask36);

        //spain
        TranslationTask translationTask41 = new TranslationTask();
        translationTask41.setDescriptionLang("Cepíllate los dientes por la noche");
        translationTask41.setRecommendationLang("Los dientes superiores deben cepillarse moviendo el cepillo de arriba hacia abajo. " +
                "Los dientes inferiores deben cepillarse moviendo el cepillo de abajo hacia arriba.");
        translationTask41.setViewLinksLang("webviews.healty.app/es/teeth");
        translationTask41.setLanguage("spain");
        translationTask41.setLang("es");
        translationTask41.setTask(taskService.getTaskById(52L));

        translationTaskService.addTranslationTask(translationTask41);

        TranslationTask translationTask42 = new TranslationTask();
        translationTask42.setDescriptionLang("Cepíllate los dientes por la mañana");
        translationTask42.setRecommendationLang("Los dientes superiores deben cepillarse moviendo el cepillo de arriba hacia abajo. " +
                "Los dientes inferiores deben cepillarse moviendo el cepillo de abajo hacia arriba.");
        translationTask42.setViewLinksLang("webviews.healty.app/es/teeth");
        translationTask42.setLanguage("spain");
        translationTask42.setLang("es");
        translationTask42.setTask(taskService.getTaskById(53L));

        translationTaskService.addTranslationTask(translationTask42);

        TranslationTask translationTask43 = new TranslationTask();
        translationTask43.setDescriptionLang("Comer fruta");
        translationTask43.setRecommendationLang("Alimentación saludable todos los días");
        translationTask43.setViewLinksLang("webviews.healty.app/es/fruits");
        translationTask43.setLanguage("spain");
        translationTask43.setLang("es");
        translationTask43.setTask(taskService.getTaskById(54L));

        translationTaskService.addTranslationTask(translationTask43);

        TranslationTask translationTask44 = new TranslationTask();
        translationTask44.setDescriptionLang("Haz tus ejercicios matutinos");
        translationTask44.setRecommendationLang("Haga ejercicio suavemente sin movimientos espasmódicos");
        translationTask44.setViewLinksLang("webviews.healty.app/es/work-out");
        translationTask44.setLanguage("spain");
        translationTask44.setLang("es");
        translationTask44.setTask(taskService.getTaskById(55L));

        translationTaskService.addTranslationTask(translationTask44);

        TranslationTask translationTask46 = new TranslationTask();
        translationTask46.setDescriptionLang("Camine 7000 pasos");
        translationTask46.setRecommendationLang("Movimiento vida");
        translationTask46.setLanguage("spain");
        translationTask46.setLang("es");
        translationTask46.setTask(taskService.getTaskById(57L));

        translationTaskService.addTranslationTask(translationTask46);

        //china
        TranslationTask translationTask51 = new TranslationTask();
        translationTask51.setDescriptionLang("晚上刷牙");
        translationTask51.setRecommendationLang("应该通过将牙刷从上到下移动来刷洗上部牙齿。 需要通过从底部到顶部移动牙刷来刷洗下部牙齿。");
        translationTask51.setViewLinksLang("webviews.healty.app/zh/teeth");
        translationTask51.setLanguage("china");
        translationTask51.setLang("zh");
        translationTask51.setTask(taskService.getTaskById(52L));

        translationTaskService.addTranslationTask(translationTask51);

        TranslationTask translationTask52 = new TranslationTask();
        translationTask52.setDescriptionLang("早上刷牙");
        translationTask52.setRecommendationLang("应该通过将牙刷从上到下移动来刷洗上部牙齿。 需要通过从底部到顶部移动牙刷来刷洗下部牙齿。");
        translationTask52.setViewLinksLang("webviews.healty.app/zh/teeth");
        translationTask52.setLanguage("china");
        translationTask52.setLang("zh");
        translationTask52.setTask(taskService.getTaskById(53L));

        translationTaskService.addTranslationTask(translationTask52);

        TranslationTask translationTask53 = new TranslationTask();
        translationTask53.setDescriptionLang("吃水果");
        translationTask53.setRecommendationLang("每天健康饮食");
        translationTask53.setViewLinksLang("webviews.healty.app/zh/fruits");
        translationTask53.setLanguage("china");
        translationTask53.setLang("zh");
        translationTask53.setTask(taskService.getTaskById(54L));

        translationTaskService.addTranslationTask(translationTask53);

        TranslationTask translationTask54 = new TranslationTask();
        translationTask54.setDescriptionLang("做早操");
        translationTask54.setRecommendationLang("平稳运动而无剧烈运动");
        translationTask54.setViewLinksLang("webviews.healty.app/zh/work-out");
        translationTask54.setLanguage("china");
        translationTask54.setLang("zh");
        translationTask54.setTask(taskService.getTaskById(55L));

        translationTaskService.addTranslationTask(translationTask54);


        TranslationTask translationTask56 = new TranslationTask();
        translationTask56.setDescriptionLang("完成 7000 个步骤");
        translationTask56.setRecommendationLang("运动寿命");
        translationTask56.setLanguage("china");
        translationTask56.setLang("zh");
        translationTask56.setTask(taskService.getTaskById(57L));

        translationTaskService.addTranslationTask(translationTask56);

        //korea
        TranslationTask translationTask61 = new TranslationTask();
        translationTask61.setDescriptionLang("저녁에 양치질");
        translationTask61.setRecommendationLang("칫솔을 위에서 아래로 움직여 윗니를 닦아야합니다. 아래 치아는 칫솔을 아래에서 위로 움직여서 닦을 필요가 있습니다.");
        translationTask61.setViewLinksLang("webviews.healty.app/ko/teeth");
        translationTask61.setLanguage("korea");
        translationTask61.setLang("ko");
        translationTask61.setTask(taskService.getTaskById(52L));

        translationTaskService.addTranslationTask(translationTask61);

        TranslationTask translationTask62 = new TranslationTask();
        translationTask62.setDescriptionLang("아침에 양치질");
        translationTask62.setRecommendationLang("칫솔을 위에서 아래로 움직여 윗니를 닦아야합니다. 아래 치아는 칫솔을 아래에서 위로 움직여서 닦을 필요가 있습니다.");
        translationTask62.setViewLinksLang("webviews.healty.app/ko/teeth");
        translationTask62.setLanguage("korea");
        translationTask62.setLang("ko");
        translationTask62.setTask(taskService.getTaskById(53L));

        translationTaskService.addTranslationTask(translationTask62);

        TranslationTask translationTask63 = new TranslationTask();
        translationTask63.setDescriptionLang("과일 먹기");
        translationTask63.setRecommendationLang("매일 건강한 식생활");
        translationTask63.setViewLinksLang("webviews.healty.app/ko/fruits");
        translationTask63.setLanguage("korea");
        translationTask63.setLang("ko");
        translationTask63.setTask(taskService.getTaskById(54L));

        translationTaskService.addTranslationTask(translationTask63);

        TranslationTask translationTask64 = new TranslationTask();
        translationTask64.setDescriptionLang("아침 운동을하십시오");
        translationTask64.setRecommendationLang("갑작스러운 움직임없이 부드럽게 운동");
        translationTask64.setViewLinksLang("webviews.healty.app/ko/work-out");
        translationTask64.setLanguage("korea");
        translationTask64.setLang("ko");
        translationTask64.setTask(taskService.getTaskById(55L));

        translationTaskService.addTranslationTask(translationTask64);

        TranslationTask translationTask66 = new TranslationTask();
        translationTask66.setDescriptionLang("7000 단계 완료");
        translationTask66.setRecommendationLang("운동 생활");
        translationTask66.setLanguage("korea");
        translationTask66.setLang("ko");
        translationTask66.setTask(taskService.getTaskById(57L));

        translationTaskService.addTranslationTask(translationTask66);

        //portugal
        TranslationTask translationTask71 = new TranslationTask();
        translationTask71.setDescriptionLang("Escove os dentes à noite");
        translationTask71.setRecommendationLang("Os dentes superiores devem ser escovados movendo a escova de cima para baixo. " +
                "Os dentes inferiores precisam ser escovados movendo a escova de baixo para cima.");
        translationTask71.setViewLinksLang("webviews.healty.app/pt/teeth");
        translationTask71.setLanguage("portugal");
        translationTask71.setLang("pt");
        translationTask71.setTask(taskService.getTaskById(52L));

        translationTaskService.addTranslationTask(translationTask71);

        TranslationTask translationTask72 = new TranslationTask();
        translationTask72.setDescriptionLang("Escove os dentes de manhã");
        translationTask72.setRecommendationLang("Os dentes superiores devem ser escovados movendo a escova de cima para baixo. " +
                "Os dentes inferiores precisam ser escovados movendo a escova de baixo para cima.");
        translationTask72.setViewLinksLang("webviews.healty.app/pt/teeth");
        translationTask72.setLanguage("portugal");
        translationTask72.setLang("pt");
        translationTask72.setTask(taskService.getTaskById(53L));

        translationTaskService.addTranslationTask(translationTask72);

        TranslationTask translationTask73 = new TranslationTask();
        translationTask73.setDescriptionLang("Coma fruta");
        translationTask73.setRecommendationLang("Alimentação saudável todos os dias");
        translationTask73.setViewLinksLang("webviews.healty.app/pt/fruits");
        translationTask73.setLanguage("portugal");
        translationTask73.setLang("pt");
        translationTask73.setTask(taskService.getTaskById(54L));

        translationTaskService.addTranslationTask(translationTask73);

        TranslationTask translationTask74 = new TranslationTask();
        translationTask74.setDescriptionLang("Faça seus exercícios matinais");
        translationTask74.setRecommendationLang("Exercite-se suavemente, sem movimentos bruscos");
        translationTask74.setViewLinksLang("webviews.healty.app/pt/work-out");
        translationTask74.setLanguage("portugal");
        translationTask74.setLang("pt");
        translationTask74.setTask(taskService.getTaskById(55L));

        translationTaskService.addTranslationTask(translationTask74);

        TranslationTask translationTask76 = new TranslationTask();
        translationTask76.setDescriptionLang("Caminhe 7000 passos");
        translationTask76.setRecommendationLang("Movimento vida");
        translationTask76.setLanguage("portugal");
        translationTask76.setLang("pt");
        translationTask76.setTask(taskService.getTaskById(57L));

        translationTaskService.addTranslationTask(translationTask76);

        //hindi
        TranslationTask translationTask81 = new TranslationTask();
        translationTask81.setDescriptionLang("शाम को अपने दांतों को ब्रश करें");
        translationTask81.setRecommendationLang("ऊपरी दांतों को ऊपर से नीचे तक टूथब्रश को घुमाकर ब्रश करना चाहिए। निचले दांतों को नीचे से ऊपर तक टूथब्रश को घुमाकर ब्रश करने की आवश्यकता होती है।");
        translationTask81.setViewLinksLang("webviews.healty.app/hi/teeth");
        translationTask81.setLanguage("hindi");
        translationTask81.setLang("hi");
        translationTask81.setTask(taskService.getTaskById(52L));

        translationTaskService.addTranslationTask(translationTask81);

        TranslationTask translationTask82 = new TranslationTask();
        translationTask82.setDescriptionLang("सुबह अपने दांतों को ब्रश करें");
        translationTask82.setRecommendationLang("ऊपरी दांतों को ऊपर से नीचे तक टूथब्रश को घुमाकर ब्रश करना चाहिए। निचले दांतों को नीचे से ऊपर तक टूथब्रश को घुमाकर ब्रश करने की आवश्यकता होती है।");
        translationTask82.setViewLinksLang("webviews.healty.app/hi/teeth");
        translationTask82.setLanguage("hindi");
        translationTask82.setLang("hi");
        translationTask82.setTask(taskService.getTaskById(53L));

        translationTaskService.addTranslationTask(translationTask82);

        TranslationTask translationTask83 = new TranslationTask();
        translationTask83.setDescriptionLang("फल खाओ");
        translationTask83.setRecommendationLang("हर दिन स्वस्थ भोजन");
        translationTask83.setViewLinksLang("webviews.healty.app/hi/fruits");
        translationTask83.setLanguage("hindi");
        translationTask83.setLang("hi");
        translationTask83.setTask(taskService.getTaskById(54L));

        translationTaskService.addTranslationTask(translationTask83);

        TranslationTask translationTask84 = new TranslationTask();
        translationTask84.setDescriptionLang("अपनी सुबह व्यायाम करें");
        translationTask84.setRecommendationLang("झटकेदार आंदोलनों के बिना आसानी से व्यायाम करें");
        translationTask84.setViewLinksLang("webviews.healty.app/hi/work-out");
        translationTask84.setLanguage("hindi");
        translationTask84.setLang("hi");
        translationTask84.setTask(taskService.getTaskById(55L));

        translationTaskService.addTranslationTask(translationTask84);

        TranslationTask translationTask86 = new TranslationTask();
        translationTask86.setDescriptionLang("7000 चरणों को पूरा करें");
        translationTask86.setRecommendationLang("आंदोलन जीवन");
        translationTask86.setLanguage("hindi");
        translationTask86.setLang("hi");
        translationTask86.setTask(taskService.getTaskById(57L));

        translationTaskService.addTranslationTask(translationTask86);

        //arabian
        TranslationTask translationTask91 = new TranslationTask();
        translationTask91.setDescriptionLang("اغسل أسنانك بالفرشاة في المساء");
        translationTask91.setRecommendationLang("جب تنظيف الأسنان العلوية بتحريك فرشاة الأسنان من أعلى إلى أسفل. يجب تنظيف الأسنان السفلية عن طريق تحريك الفرشاة من الأسفل إلى الأعلى.");
        translationTask91.setViewLinksLang("webviews.healty.app/ar/teeth");
        translationTask91.setLanguage("arabian");
        translationTask91.setLang("ar");
        translationTask91.setTask(taskService.getTaskById(52L));

        translationTaskService.addTranslationTask(translationTask91);

        TranslationTask translationTask92 = new TranslationTask();
        translationTask92.setDescriptionLang("اغسل أسنانك بالفرشاة في الصباح");
        translationTask92.setRecommendationLang("جب تنظيف الأسنان العلوية بتحريك فرشاة الأسنان من أعلى إلى أسفل. يجب تنظيف الأسنان السفلية عن طريق تحريك الفرشاة من الأسفل إلى الأعلى.");
        translationTask92.setViewLinksLang("webviews.healty.app/ar/teeth");
        translationTask92.setLanguage("arabian");
        translationTask92.setLang("ar");
        translationTask92.setTask(taskService.getTaskById(53L));

        translationTaskService.addTranslationTask(translationTask92);

        TranslationTask translationTask93 = new TranslationTask();
        translationTask93.setDescriptionLang("أكل الفاكهة");
        translationTask93.setRecommendationLang("الأكل الصحي كل يوم");
        translationTask93.setViewLinksLang("webviews.healty.app/ar/fruits");
        translationTask93.setLanguage("arabian");
        translationTask93.setLang("ar");
        translationTask93.setTask(taskService.getTaskById(54L));

        translationTaskService.addTranslationTask(translationTask93);

        TranslationTask translationTask94 = new TranslationTask();
        translationTask94.setDescriptionLang("قم بتمارينك الصباحية");
        translationTask94.setRecommendationLang("تمرن بسلاسة دون حركات متشنجة");
        translationTask94.setViewLinksLang("webviews.healty.app/ar/work-out");
        translationTask94.setLanguage("arabian");
        translationTask94.setLang("ar");
        translationTask94.setTask(taskService.getTaskById(55L));

        translationTaskService.addTranslationTask(translationTask94);

        TranslationTask translationTask96 = new TranslationTask();
        translationTask96.setDescriptionLang("أكمل 7000 خطوة");
        translationTask96.setRecommendationLang("حركة الحياة");
        translationTask96.setLanguage("arabian");
        translationTask96.setLang("ar");
        translationTask96.setTask(taskService.getTaskById(57L));

        translationTaskService.addTranslationTask(translationTask96);

        //italian
        TranslationTask translationTask101 = new TranslationTask();
        translationTask101.setDescriptionLang("Lavarsi i denti la sera");
        translationTask101.setRecommendationLang("I denti superiori devono essere puliti spostando lo spazzolino da denti dall'alto verso il basso. " +
                "I denti inferiori devono essere puliti quando si muove lo spazzolino da denti dal basso verso l'alto");
        translationTask101.setViewLinksLang("webviews.healty.app/it/teeth");
        translationTask101.setLanguage("italian");
        translationTask101.setLang("it");
        translationTask101.setTask(taskService.getTaskById(52L));

        translationTaskService.addTranslationTask(translationTask101);

        TranslationTask translationTask102 = new TranslationTask();
        translationTask102.setDescriptionLang("Lavarsi i denti al mattino");
        translationTask102.setRecommendationLang("I denti superiori devono essere puliti spostando lo spazzolino da denti dall'alto verso il basso. " +
                "I denti inferiori devono essere puliti quando si muove lo spazzolino da denti dal basso verso l'alto");
        translationTask102.setViewLinksLang("webviews.healty.app/it/teeth");
        translationTask102.setLanguage("italian");
        translationTask102.setLang("it");
        translationTask102.setTask(taskService.getTaskById(53L));

        translationTaskService.addTranslationTask(translationTask102);

        TranslationTask translationTask103 = new TranslationTask();
        translationTask103.setDescriptionLang("Mangiare frutta");
        translationTask103.setRecommendationLang("Mangiare sano ogni giorno");
        translationTask103.setViewLinksLang("webviews.healty.app/it/fruits");
        translationTask103.setLanguage("italian");
        translationTask103.setLang("it");
        translationTask103.setTask(taskService.getTaskById(54L));

        translationTaskService.addTranslationTask(translationTask103);

        TranslationTask translationTask104 = new TranslationTask();
        translationTask104.setDescriptionLang("Fare la ricarica");
        translationTask104.setRecommendationLang("Esegui gli esercizi senza intoppi, senza movimenti bruschi");
        translationTask104.setViewLinksLang("webviews.healty.app/it/work-out");
        translationTask104.setLanguage("italian");
        translationTask104.setLang("it");
        translationTask104.setTask(taskService.getTaskById(55L));

        translationTaskService.addTranslationTask(translationTask104);

        TranslationTask translationTask106 = new TranslationTask();
        translationTask106.setDescriptionLang("Passi 7000 punti");
        translationTask106.setRecommendationLang("Movimento vita");
        translationTask106.setLanguage("italian");
        translationTask106.setLang("it");
        translationTask106.setTask(taskService.getTaskById(57L));

        translationTaskService.addTranslationTask(translationTask106);*/
    }
}
