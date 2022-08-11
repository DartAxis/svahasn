Проект социальной сети ориентированной на знакомства.

Основные сущности проекта:
1. UserProfile - Содержит в себе основную информацию о пользователе.
    1) userID - ссылка на сущность пользователя системы
    2) mainPhoto - ссылка на главную фотку профиля.
    3) photos - список ссылок на пользовательские фото
    4) userfeed - лента новостей пользователя.
    5) age - Возраст
    6) sex - пол
    7) about - Небольшой рассказ о себе
    8) interest - интересы
    9) growth - рост
    10) weight - вес
    11) kids - наличие детей
    12) telegram - ссылка на телеграм
    13) vk - ссылка на VK
    14) education - уровень образования
    15) city - город
    16) birthday - дата и время рождения
    17) phone - номер телефона
    18) purpose of dating - список целей знакомства 
    19) check status - статус проверки аккаунта
    20) subscription status - статус подписки на услуги
    21) subscription end date - дата окончания подписки
    22) who works  - кем работает
    23) who is looking for - кого ищет
    24) married status - статус состояния в браке



2. UserPhoto - ссылка на фотку.
    photouuid
    format
    userid

3. UserFeed
4. UserFriendList
5. UserDialog
   1) userid  - id пользователя с кем открыт диалог
   2) messages  - список сообщений c пользователем
6. Message
    1) userdialogid - принадлежность к диалогу
    2) userid - автор сообщения
    3) text - text
7. UserBlackList
    useridlist - список айдишников пользователей заблокированных пользователем.
8. UserSettings - 