# 📘 Posts SQL API

Este proyecto es una API REST construida con Spring Boot que utiliza **Spring Data JPA** para gestionar posts almacenados en una **base de datos H2 en memoria**.

---

## 📂 Estructura carpetas

```pgsql
ejemplo2-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── codeurjc/
│       │           └── postssqlapi/
│       │               ├── controller/
│       │               │   └── PostController.java
│       │               ├── model/
│       │               │   └── Post.java
│       │               ├── repository/
│       │               │   └── PostRepository.java
│       │               └── PostsSqlApiApplication.java
│       └── resources/
│           └── application.properties
├── postman
│   └── posts-sql-api.postman_collection.json
├── README.md
├── pom.xml
```

---

## 📦 Endpoints disponibles

| Método | Endpoint         | Descripción                              |
|--------|------------------|------------------------------------------|
| GET    | `/posts/`        | Lista todos los posts                    |
| GET    | `/posts/{id}`    | Recupera un post por su ID              |
| POST   | `/posts/`        | Crea un nuevo post                       |
| PUT    | `/posts/{id}`    | Reemplaza un post existente              |
| DELETE | `/posts/{id}`    | Elimina un post por ID                   |

---

## 🛠️ Tecnologías

- Java 24+
- Spring Boot 3.4+
- Spring Data JPA
- H2 Database (modo memoria)
- Postman para pruebas

---

## 🔍 Acceso a la consola H2

Puedes acceder a la consola web de la base de datos H2 desde:

```bash
http://localhost:8080/h2-console
```

- **Driver**: `org.h2.Driver`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **User**: `sa`
- **Password**: *(dejar en blanco)*

Asegúrate de tener esta línea en tu `application.properties`:

```properties
spring.h2.console.enabled=true
```

---

## ▶️ Cómo ejecutar

1. Ejecuta la clase `Application.java`
2. Utiliza Postman o el navegador para interactuar con la API
3. Puedes importar la colección Postman incluida (`posts-sql-api.postman_collection.json`) para probar todos los endpoints

---
