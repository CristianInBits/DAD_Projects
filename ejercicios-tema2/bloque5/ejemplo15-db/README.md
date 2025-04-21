# 🗨️ Ejemplo 15 - API REST con comentarios y consulta JPQL

Este proyecto es una API REST desarrollada con **Spring Boot** que permite gestionar **posts con comentarios** asociados. Utiliza **Spring Data JPA** con base de datos H2 en memoria. Incluye una consulta **JPQL** para obtener los posts según el usuario que ha comentado.

---

## 💡 Funcionalidades

- Crear, consultar, actualizar y eliminar posts
- Añadir, consultar, actualizar y eliminar comentarios asociados a un post
- Filtrar posts por usuario que haya comentado (`JPQL`)

---

## 📁 Estructura del proyecto

```bash
ejemplo15-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── codeurjc/
│       │           └── example15_db/
│       │               ├── controllers/
│       │               │   ├── PostController.java
│       │               │   └── advice/
│       │               │       └── NoSuchElementExceptionCA.java
│       │               ├── models/
│       │               │   ├── Comment.java
│       │               │   └── Post.java
│       │               ├── repository/
│       │               │   ├── CommentRespository.java
│       │               │   └── PostRepository.java
│       │               └── Application.java
│       └── resources/
│           └── application.properties
├── postman/
│   └── ejemplo15-db.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔢 Endpoints disponibles

| Método | Endpoint                               | Descripción                                      |
|--------|----------------------------------------|--------------------------------------------------|
| GET    | `/posts/`                              | Listar todos los posts o filtrar por usuario     |
| GET    | `/posts/{id}`                          | Obtener un post por ID                           |
| POST   | `/posts/`                              | Crear un nuevo post                              |
| PUT    | `/posts/{id}`                          | Reemplazar un post                               |
| DELETE | `/posts/{id}`                          | Borrar un post                                   |
| GET    | `/posts/{postId}/comments/{commentId}`| Obtener un comentario de un post                 |
| POST   | `/posts/{postId}/comments/`            | Añadir comentario a un post                      |
| PUT    | `/posts/{postId}/comments/{commentId}` | Reemplazar comentario                            |
| DELETE | `/posts/{postId}/comments/{commentId}` | Borrar comentario                                |

---

## 🌐 Consola web H2

Disponible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

> Para activarla asegúrate de tener esta propiedad:

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

La colección para probar todos los endpoints está en:

```bash
postman/ejemplo15-db.postman_collection.json
```

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- H2 Database (en memoria)
- JPQL (Java Persistence Query Language)
- Maven
- Postman
