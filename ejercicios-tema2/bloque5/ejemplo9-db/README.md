# 📝 Ejemplo 9 – Relación 1 : N unidireccional con `cascade = ALL` (Blog → Comment)

Este proyecto ejemplifica cómo modelar y exponer vía API REST una relación **uno‑a‑muchos unidireccional** entre `Blog` y `Comment` en Spring Boot, aprovechando `cascade = CascadeType.ALL` para que los comentarios se persistan/eliminan junto al blog. Incluye manejo de errores 404 mediante `@ControllerAdvice`.

---

## 💡 Funcionalidades

- Listar todos los blogs con sus comentarios – **GET** `/blogs/`
- Eliminar un blog (y sus comentarios) – **DELETE** `/blogs/{id}`
- Eliminar un comentario vinculado a un blog – **DELETE** `/blog/{blogId}/comments/{commentId}`
- Eliminar comentario sin blog asociado – **DELETE** `/comments/{id}` *(solo si no pertenece a un blog)*

---

## 📁 Estructura del proyecto

```bash
ejemplo9-db/
├── src/main/java/es/chatgpt/code/ejemplo9_db/
│   ├── controllers/
│   │   ├── advice/NoSuchElementExceptionCA.java
│   │   └── BlogController.java
│   ├── models/
│   │   ├── Blog.java
│   │   └── Comment.java
│   ├── repository/
│   │   ├── BlogRepository.java
│   │   └── CommentRepository.java
│   └── Application.java
├── src/main/resources/application.properties
├── postman/ejemplo9-db.postman_collection.json
├── pom.xml
└── README.md
```

---

## 🔢 Endpoints disponibles

| Método | Endpoint                                      | Descripción                                                         |
|:------:|:----------------------------------------------|:--------------------------------------------------------------------|
| GET    | `/blogs/`                                     | Obtiene todos los blogs con su lista de comentarios                 |
| DELETE | `/blogs/{id}`                                 | Borra el blog y todos sus comentarios (operación en cascada)        |
| DELETE | `/blog/{blogId}/comments/{commentId}`         | Borra un comentario concreto de un blog                             |
| DELETE | `/comments/{id}`                              | Borra comentario sin blog (fallará si la FK sigue activa)           |

---

## 🌐 Consola web H2

Disponible en: <http://localhost:8080/h2-console>

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Se encuentra en el archivo:

```bash
postman/ejemplo9-db.postman_collection.json
```

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- H2 Database (en memoria)
- Maven
- Postman
