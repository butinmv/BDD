Feature: Разработка минимального функционала для POS-системы
  Scenario: Инициализация продукта
    Given У продукта есть цена 100 рублей
    Given У продукта есть название "Молоко"
    When Мы создаем продукт с данной ценной и названием
    Then Мы можем узнать цену продукта равной 100 рублей
    And Мы можем узнать название продукта равным "Молоко"

  Scenario: Инициализация стола
    Given У стола есть номер 3
    When Мы создаем стол с данным номером
    Then Мы можем узнать номер стола равной 3

  Scenario: Инициализация заказа
    Given У заказа есть номер столика 3
    Given У заказа есть 2 "Кофе" и 1 "Цезарь"
    Given У заказа есть общая сумма заказа равная 600 рублям
    When Мы создаем заказ с данным столиком и продуктами
    Then Мы можем узнать номер столика заказа равному 3
    And Мы можем узнать товары 2 "Кофе" и 1 "Цезарь"
    And Мы можем узнать сумму заказа равную 600 рублям