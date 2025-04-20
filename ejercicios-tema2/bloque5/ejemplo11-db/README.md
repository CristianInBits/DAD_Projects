# 🗨️ Ejemplo 11 – Relación 1 : N bidireccional con `cascade = ALL` + `orphanRemoval` (Post ↔ Comment)

Este ejemplo muestra cómo implementar y exponer una relación **uno‑a‑muchos bidireccional** entre `Post` y `Comment` usando Spring Boot, Spring Data JPA y H2 en memoria. Con `cascade = CascadeType.ALL` y `orphanRemoval = true` los comentarios se crean/borran junto con el post y nunca quedan huérfanos. Incluye un controlador REST con rutas anidadas para gestionar comentarios.

---

## 💡 Funcionalidades

| Método | Endpoint | Descripción |
|:------:|:---------|:------------|
| GET | `/posts/` | Listar todos los posts con sus comentarios |
| GET | `/posts/{id}` | Obtener un post por ID |
| POST | `/posts/` | Crear un post con (o sin) comentarios |
| PUT | `/posts/{id}` | Reemplazar un post (los comentarios existentes se conservan) |
| DELETE | `/posts/{id}` | Borrar un post y **todos** sus comentarios |
| GET | `/posts/{postId}/comments/{commentId}` | Obtener un comentario concreto |
| POST | `/posts/{postId}/comments` | Añadir un comentario a un post |
| PUT | `/posts/{postId}/comments/{commentId}` | Reemplazar un comentario |
| DELETE | `/posts/{postId}/comments/{commentId}` | Borrar un comentario |

---

## 📁 Estructura del proyecto

```bash
ejemplo11-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── chatgpt/
│       │           └── code/
│       │               └── ejemplo11_db/
│       │                   ├── controllers/
│       │                   │   ├── advice/NoSuchElementExceptionCA.java
│       │                   │   └── PostController.java
│       │                   ├── models/
│       │                   │   ├── Post.java
│       │                   │   └── Comment.java
│       │                   ├── repository/
│       │                   │   ├── PostRepository.java
│       │                   │   └── CommentRepository.java
│       │                   └── Application.java
│       └── resources/application.properties
├── postman/ejemplo11-db.postman_collection.json
├── pom.xml
└── README.md
```

---

## 🔧 Puntos técnicos destacados

- **Bidireccionalidad**: `Post` posee la colección y el lado inverso en `Comment` lleva `@ManyToOne` + `@JsonIgnore` para evitar ciclos JSON.
- **Cascade & orphanRemoval**: mantener la integridad de datos sin llamadas manuales extra.
- **Métodos helper** (`addComment`, `removeComment`) sincronizan ambos lados.
- **Rutas anidadas** para comentarios (`/posts/{id}/comments/...`).

---

## 🌐 Consola web H2

URL ▶ <http://localhost:8080/h2-console>

Añade en `application.properties`:

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Importa las peticiones desde:

```bash
postman/ejemplo11-db.postman_collection.json
```

---

## 🛠️ Tecnologías usadas

- Java 24  
- Spring Boot & Spring Data JPA  
- H2 Database (en memoria)  
- Maven  
- Postman
