# 🗃️ Bloque 5 - Bases de Datos SQL en Spring

Este bloque contiene ejercicios prácticos sobre integración de **bases de datos relacionales** en aplicaciones **Spring Boot**, utilizando **Spring Data JPA**. Cada carpeta representa un proyecto independiente centrado en conceptos como persistencia de entidades, repositorios, consultas, relaciones y mapeo objeto‑relacional (ORM).

---

## 📁 Proyectos incluidos

| Carpeta                  | Descripción                                                                                                   |
|--------------------------|---------------------------------------------------------------------------------------------------------------|
| `comparativa-consultas/` | Comparativa entre métodos derivados y consultas JPQL (con y sin parámetros opcionales) |
| `ejemplo1-db/`           | Uso básico de JPA con repositorio y operaciones CRUD por consola Java.                                        |
| `ejemplo2-db/`           | API REST CRUD para gestionar posts persistentes con JPA + H2 + Postman.                                       |
| `ejemplo3-db/`           | API REST con H2 y manejo global de errores con `@ControllerAdvice`.                                           |
| `ejemplo4-db/`           | API REST con JPA y manejo conciso de `Optional` usando `ResponseEntity.of()`.                                 |
| `ejemplo5-db/`           | API REST que ilustra una relación 1:1 unidireccional (`Student` → `Project`) sin cascada, con H2 y Postman.   |
| `ejemplo6-db/`           | API REST con relación 1:1 unidireccional y `cascade = ALL` (Student ↔ Project)                                |
| `ejemplo7-db/`           | API REST con relación 1:1 bidireccional usando `@JsonView` para controlar la salida JSON                      |
| `ejemplo8-db/`           | API REST con relación 1:N unidireccional (Team → Player) sin cascada                                          |
| `ejemplo9-db/`           | API REST con relación 1:N unidireccional (Blog → Comment) y eliminación en cascada                            |
| `ejemplo10-db/`          | API REST con relación 1:N bidireccional (Team ↔ Player) y serialización segura con `@JsonIgnore`              |
| `ejemplo11-db/`          | API REST con relación 1:N bidireccional (Post ↔ Comment) usando cascada y orphanRemoval                       |
| `ejemplo12-db/`          | API REST con relación M:N bidireccional (Team ↔ Player) y proyecciones `@JsonView`                            |
| `ejemplo13-db/`      | API REST con consultas derivadas (`findByUsername`, `findByTitle`) y filtro opcional en URL |
| `ejemplo14-db/`      | Relación M:N bidireccional entre Player y Team con `@JsonView` y filtro con `@Query` |
| `ejemplo15-db/`        | Gestión de posts y comentarios con relaciones 1:N, JPQL y cascada + orphan removal |
| `ejemplo16-db/`       | Consultas JPQL avanzadas sobre relaciones indirectas entre equipos, partidos y torneos. |
| `ejemplo17-db/`       | API REST con relación 1:N y consultas dinámicas usando QueryDSL para filtrar por comentarios. |
| `ejemplo18-db/`       | API REST con paginación y ordenación utilizando Spring Data JPA y Pageable. |
| `item-manager-db-api/`   | API REST para gestionar items con base de datos H2, JPA y manejo de errores.                                  |
| `example19-db/`         | API REST con paginación + serialización personalizada de objetos Page en JSON.       |
| `ejemplo20-db/`         | API REST conectada a base de datos MySQL con paginación y generación de esquema validada.   |
| `library-manager-api/`   | API REST para gestionar libros en una biblioteca con filtros por autor y persistencia con JPA.                |
| `movie-manager-db-api/`  | API REST para gestionar películas, usando JPA + H2 + `@ControllerAdvice`.                                     |
| `pagination10-posts-db/` | API REST con paginación de resultados usando Spring Data `Pageable`. |
| `post-pagination-web/`  | Aplicación web con Mustache para mostrar posts con paginación desde Spring Data JPA.        |
| _..._                    | Se irán añadiendo nuevos ejemplos con más funcionalidades y relaciones.                                       |

---

## ⚙️ Tecnologías utilizadas

- Java 24+
- Spring Boot
- Spring Data JPA
- H2 Database (en memoria)
- Maven

---

## ▶️ Ejecución de los ejercicios

1. Abre la carpeta del ejercicio (por ejemplo, `ejemplo1-db/`).
2. Ejecuta la clase `Application.java` o la clase que implemente `CommandLineRunner`.
3. Observa la salida por consola o accede a la interfaz HTTP si está disponible.

---

## 🛠️ Consola web H2

En algunos proyectos, puedes acceder a la consola web de H2 para inspeccionar la base de datos:

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Driver: `org.h2.Driver`
- User: `sa` (por defecto)

Para activarla asegúrate de tener en `application.properties`:

```properties
spring.h2.console.enabled=true
```

---

## 📋 Objetivos del bloque

- Comprender el modelo de entidades en JPA
- Configurar una base de datos relacional en Spring Boot
- Usar repositorios para acceder a los datos
- Realizar operaciones CRUD sobre entidades
- Aprender a trabajar con consultas derivadas del nombre de métodos
- Acceder y modificar datos desde controladores o servicios
