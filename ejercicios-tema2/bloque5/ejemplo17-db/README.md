# 📌 Ejemplo 17 - API REST con QueryDSL y filtrado de relaciones

Este proyecto demuestra el uso de **QueryDSL** junto con **Spring Data JPA** para realizar consultas dinámicas sobre entidades relacionadas. En este caso, se filtran posts según el nombre de usuario de los comentarios asociados.

---

## 💡 Funcionalidades

- Obtener todos los posts o filtrarlos por el autor de un comentario (QueryDSL)
- Consultar un post por ID
- Crear, actualizar y borrar posts
- Añadir, consultar, actualizar y eliminar comentarios asociados a un post

---

## 📁 Estructura del proyecto

```bash
ejemplo17-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── chatgpt/
│       │           └── code/
│       │               └── ejemplo17_db/
│       │                   ├── controllers/
│       │                   │   ├── PostController.java
│       │                   │   └── advice/
│       │                   │       └── NoSuchElementExceptionCA.java
│       │                   ├── models/
│       │                   │   ├── Comment.java
│       │                   │   └── Post.java
│       │                   ├── repository/
│       │                   │   ├── CommentRepository.java
│       │                   │   └── PostRepository.java
│       │                   └── Application.java
│       └── resources/
│           └── application.properties
├── postman/
│   └── ejemplo17-db.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔢 Endpoints disponibles

| Método | Endpoint                            | Descripción                                         |
|--------|-------------------------------------|-----------------------------------------------------|
| GET    | `/posts/`                           | Listar todos los posts o filtrar por comentarios   |
| GET    | `/posts/{id}`                       | Obtener un post por ID                             |
| POST   | `/posts/`                           | Crear un nuevo post                                |
| PUT    | `/posts/{id}`                       | Reemplazar un post completo                        |
| DELETE | `/posts/{id}`                       | Eliminar un post y sus comentarios                 |
| GET    | `/posts/{idPost}/comments/{id}`     | Obtener un comentario específico                   |
| POST   | `/posts/{idPost}/comments/`         | Añadir un nuevo comentario a un post               |
| PUT    | `/posts/{idPost}/comments/{id}`     | Reemplazar un comentario                           |
| DELETE | `/posts/{idPost}/comments/{id}`     | Eliminar un comentario                             |

---

## 🌐 Consola web H2

Disponible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

> Asegúrate de tener esta propiedad en `application.properties`:

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Importa y prueba la API desde:

```bash
postman/ejemplo17-db.postman_collection.json
```

Incluye ejemplos de:

- Filtrado con parámetros
- Gestión completa de comentarios

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- QueryDSL
- H2 Database
- Maven
- Postman
