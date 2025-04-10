# 📘 Ejemplo 3 - API REST con JPA y manejo de errores

Este proyecto muestra cómo implementar una API REST usando **Spring Boot** y **Spring Data JPA**, con una gestión profesional de errores mediante `@ControllerAdvice`.

---

## ✅ Características principales

- Gestión de entidades `Post` persistidas en base de datos H2.
- Endpoints REST completos: crear, obtener, actualizar y eliminar.
- Uso de `Optional.orElseThrow()` para manejar recursos no encontrados.
- Conversión automática de `NoSuchElementException` en respuesta `404 Not Found` gracias al controlador de excepciones global.

---

## 🧱 Estructura

```pgsql
ejemplo3-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── codeurjc/
│       │           └── board/
│       │               ├── models/
│       │               │   └── Post.java
│       │               ├── repository/
│       │               │   └── PostRepository.java
│       │               ├── controllers/
│       │               │   └── PostController.java
│       │               └── exception/
│       │                   └── NoSuchElementExceptionCA.java
│       └── resources/
│           └── application.properties
├── postman/
│   └── ejemplo3-db.postman_collection.json
├── README.md
├── pom.xml

```

- `Post.java`: entidad JPA que representa un post.
- `PostRepository.java`: interfaz que extiende `JpaRepository`.
- `PostController.java`: controlador REST con endpoints CRUD.
- `NoSuchElementExceptionCA.java`: manejo de excepciones.
- `application.properties`: configuración de consola H2 y logs SQL.

---

## 🌐 Consola Web de H2

Disponible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

- **JDBC URL**: `jdbc:h2:mem:testdb`
- **User**: `sa`
- **Password**: *(dejar vacío)*

---

## ▶️ Cómo probar

1. Ejecuta `Application.java`
2. Usa Postman o navegador para interactuar con la API.
3. Importa el archivo `ejemplo3-db-postman-collection.json` en Postman para probar los endpoints.

---

## 📦 Dependencias

- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- H2 Database
