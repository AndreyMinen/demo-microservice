#Демонстрация микросервисов на Spring Boot

##Запуск и сборка приложения
1. Установить Java 8 и Maven
2. Для запуска в директории приложения ввести ```mvnw```
3. Сборка ```mvnw clean package``` затем в директории target ввести ```java -jar {имя_приложения}.jar```

##Действия после запуска
1. Должна быть развёрнута база MySQL, в которой выполнить код из файла init.sql.
2. Вы должны прописать в файле application.yml в user-service, свои конфигурации для подключения к базе(хост, пароль, пользователь)
3. После запуска открыть в браузере http://localhost:8761, здесь указыны запущенные сервисы
PS Registry должен быть запущен в первую очередь
4. Перейти http://localhost:8080/user-service/users по этому адресу получите всех пользователей с ролями
5. http://localhost:8080/user-service/users/admin получить информацию о пользователях с логином admin