-- 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”

CREATE DATABASE Friends_of_Humans;

USE Friends_of_Humans;


-- 8. Создать таблицы с иерархией из диаграммы в БД

CREATE TABLE Domestic_Animals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    command VARCHAR(255),
    birth_date DATE
);


CREATE TABLE Horses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    command VARCHAR(255),
    birth_date DATE
);


CREATE TABLE Camels (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    command VARCHAR(255),
    birth_date DATE
);


CREATE TABLE Donkeys (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    command VARCHAR(255),
    birth_date DATE
);


-- 9. Заполнить низкоуровневые таблицы именами(животных), командами
-- которые они выполняют и датами рождения

INSERT INTO Domestic_Animals (name, command, birth_date)
VALUES
    ('Rex', 'Follow the owner', '2019-05-15'),
    ('Whiskers', 'Hunting mice', '2020-02-20'),
    ('Buddy', 'Fetching', '2018-11-10'),
    ('Fluffy', 'Couch comfort', '2017-08-05');


INSERT INTO Camels (name, command, birth_date)
VALUES
    ('Alpha', 'Cargo transport', '2016-06-30'),
    ('Beta', 'Desert travels', '2017-02-15');

INSERT INTO Donkeys (name, command, birth_date)
VALUES
    ('Pear', 'Cargo transport', '2019-08-10'),
    ('Apple', 'Farm assistance', '2020-05-05');

-- 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
-- питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

DELETE FROM Camels WHERE name = 'Alpha' OR name = 'Beta';

CREATE TABLE Pack_Animals AS
SELECT * FROM Horses
UNION ALL
SELECT * FROM Donkeys;

-- 11.Создать новую таблицу “молодые животные” в которую попадут все
-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- до месяца подсчитать возраст животных в новой таблице

CREATE TABLE Young_Animals AS
SELECT *,
       TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) AS age_years,
       MONTH(CURDATE()) - MONTH(birth_date) + 12 * (YEAR(CURDATE()) - YEAR(birth_date)) AS age_months
FROM All_Animals
WHERE TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) >= 1 AND TIMESTAMPDIFF(YEAR, birth_date, CURDATE()) < 3;


-- 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
-- прошлую принадлежность к старым таблицам.

CREATE TABLE All_Animals AS
SELECT 'Domestic Animals' AS belonging, id, name, command, birth_date FROM Domestic_Animals
UNION ALL
SELECT 'Pack Animals' AS belonging, id, name, command, birth_date FROM Pack_Animals
UNION ALL
SELECT 'Young Animals' AS belonging, id, name, command, birth_date, age_years, age_months FROM Young_An>








