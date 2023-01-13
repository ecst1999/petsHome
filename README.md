# La estructura de carpetas se encuentra de la siguiente manera

Se debe traer los siguientes paquetes del spring boot initializer
```
PostGresSql Driver | Spring Data JPA | Lombok | Spring web | Spring Boot Dev Tools | Thymeleaf
```

    +---BACKEND 
    |
    |   +--controlador
    |       Se almacena los controladores 
    |
    |   +--modelo
    |       
    |        +--entidades
    |           Se almacena las clases a utilizar
    |        +--repositorio
    |           Se almacena la herencia del JPARepository extends JpaRepository<T, Integer>


    +---Estructura de cadena de configuracion application.properties
    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/base
    spring.datasource.username=
    spring.datasource.password=
    spring.datasource.dbcp2.driver-class-name=org.postgresql.Driver
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

    logging.level.org.hibernate.sql=debug
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update

    log4j.rootLogger=DEBUG, console
    ``` 

