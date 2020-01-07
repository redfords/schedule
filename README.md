# Schedule App

A Spring Boot app to manage the schedule, workshops and speakers of a conference.

Packages used:
- Gradle
- Spring Core
- Spring Data & Hibernate
- MySQL
- Thymeleaf

Preview:

![preview](https://i.imgur.com/X8VkStI.gif)

## Installation 
The project is created with Gradle, so you just need to import it to your IDE and build the project to resolve the dependencies.

## Database configuration 
Create a MySQL database and replace the name and credentials in `/resources/application.properties`:

```
spring.datasource.url = jdbc:mysql://127.0.0.1:33060/demo?useUnicode=true&serverTimezone=UTC
spring.datasource.username = root
spring.datasource.password =
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
```

## Usage 
To build the executable jar you can run this command:

```
./gradlew bootJar
```

Then run the executable jar located in the build/libs directory:

```
java -jar build/libs/gradle-spring-boot-project.jar
```

You can also run the app with the following command:

```
./gradlew bootRun
```

The application will run on the default port 8080 directly: [http://localhost:8080](http://localhost:8080).

