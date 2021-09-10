# WebDriver

При выполнении задания необходимо использовать возможности Selenium WebDriver,
юнит-тест фреймворка и концепцию Page Object. Автоматизировать следующий сценарий:

1. Открыть https://cloud.google.com/
2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска"Google Cloud Platform Pricing Calculator"
3. Запустить поиск, нажав кнопку поиска.
4. В результатах поиска кликнуть "Google Cloud Platform Pricing Calculator" и перейти на страницу калькулятора.
5. Активировать раздел COMPUTE ENGINE вверху страницы
6. Заполнить форму следующими данными:
    * Number of instances: 4
    * What are these instances for?: оставить пустым
    * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
    * VM Class: Regular
    * Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
    * Выбрать Add GPUs
        * Number of GPUs: 1
        * GPU type: NVIDIA Tesla V100
    * Local SSD: 2x375 Gb
    * Datacenter location: Frankfurt (europe-west3)
    * Committed usage: 1 Year
7. Нажать Add to Estimate
8. Проверить соответствие данных следующих полей: VM Class, Instance type, Region, local SSD, commitment term
9. Проверить что сумма аренды в месяц совпадает с суммой получаемой при ручном прохождении теста.

  
# Hardcore
При выполнении задания необходимо использовать возможности Selenium WebDriver,
юнит-тест фреймворка и концепцию Page Object. Автоматизировать следующий сценарий:

1. Открыть https://cloud.google.com/
2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска"Google Cloud Platform Pricing Calculator"
3. Запустить поиск, нажав кнопку поиска.
4. В результатах поиска кликнуть "Google Cloud Platform Pricing Calculator" и перейти на страницу калькулятора.
5. Активировать раздел COMPUTE ENGINE вверху страницы
6. Заполнить форму следующими данными:
    * Number of instances: 4
    * What are these instances for?: оставить пустым
    * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
    * VM Class: Regular
    * Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
    * Выбрать Add GPUs
        * Number of GPUs: 1
        * GPU type: NVIDIA Tesla V100
    * Local SSD: 2x375 Gb
    * Datacenter location: Frankfurt (europe-west3)
    * Commited usage: 1 Year
7. Нажать Add to Estimate
8. Выбрать пункт EMAIL ESTIMATE
9. В новой вкладке открыть https://10minutemail.com или аналогичный сервис для генерации временных email'ов
10. Скопировать почтовый адрес сгенерированный в 10minutemail
11. Вернуться в калькулятор, в поле Email ввести адрес из предыдущего пункта
12. Нажать SEND EMAIL
13. Дождаться письма с рассчетом стоимости и проверить что Total Estimated Monthly Cost в письме совпадает с тем, что отображается в калькуляторе
