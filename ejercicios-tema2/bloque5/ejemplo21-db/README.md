# 🧩 ejemplo21-db - Posts API con arquitectura de servicios

Este proyecto muestra cómo estructurar una API REST usando **Spring Boot** y **Spring Data JPA**, aplicando una **arquitectura basada en servicios**. La API permite gestionar posts y sus comentarios, con lógica de negocio separada en clases `@Service`.

---

## 💡 Funcionalidades

- Obtener todos los posts
- Obtener posts filtrados por autor de comentarios
- Obtener un post por ID
- Crear un nuevo post
- Actualizar un post (sin afectar a sus comentarios)
- Eliminar un post (junto con sus comentarios)
- Añadir un comentario a un post
- Obtener un comentario por ID
- Actualizar un comentario
- Eliminar un comentario

---

## 📁 Estructura del proyecto

```bash
ejemplo21-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── chatgpt/
│       │           └── code/
│       │               └── ejemplo21_db/
│       │                   ├── controller/
│       │                   │   └── PostController.java
│       │                   ├── model/
│       │                   │   ├── Comment.java
│       │                   │   └── Post.java
│       │                   ├── repository/
│       │                   │   ├── CommentRepository.java
│       │                   │   └── PostRepository.java
│       │                   ├── service/
│       │                   │   ├── CommentService.java
│       │                   │   ├── PostService.java
│       │                   │   └── SampleDaraService.java
│       │                   └── advice/
│       │                       └── NoSuchElementExceptionCA.java
│       └── resources/
│           └── application.properties
├── postman/
│   └── ejemplo21-db.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔢 Endpoints disponibles

| Método | Endpoint                         | Descripción                                      |
|--------|----------------------------------|--------------------------------------------------|
| GET    | `/posts/`                        | Listar todos los posts o filtrarlos por usuario |
| GET    | `/posts/{id}`                    | Obtener post por ID                              |
| POST   | `/posts/`                        | Crear un nuevo post                              |
| PUT    | `/posts/{id}`                    | Reemplazar un post sin alterar sus comentarios   |
| DELETE | `/posts/{id}`                    | Eliminar un post junto con sus comentarios       |
| GET    | `/posts/{idPost}/comments/{id}`  | Obtener un comentario por ID                     |
| POST   | `/posts/{idPost}/comments`       | Añadir un comentario a un post                   |
| PUT    | `/posts/{idPost}/comments/{id}`  | Actualizar un comentario                         |
| DELETE | `/posts/{idPost}/comments/{id}`  | Eliminar un comentario                           |

---

## 🌐 Consola web H2

Accesible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

> Asegúrate de tener esta propiedad activa:

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Puedes importar la colección desde el archivo:

```bash
postman/ejemplo21-db.postman_collection.json
```

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- Spring Web
- Arquitectura por capas (Servicios + Controladores)
- H2 Database
- Postman
