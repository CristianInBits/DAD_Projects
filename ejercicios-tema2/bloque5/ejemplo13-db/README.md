# ✉️ Ejemplo 13 – Consultas derivadas con parámetros opcionales

Este proyecto ilustra cómo usar **métodos derivados por nombre** en Spring Data JPA para filtrar resultados mediante un parámetro opcional de consulta (`username`). Incluye una entidad `Post`, un `PostRepository` con dos consultas (`findByUsername`, `findByTitle`) y un controlador REST minimalista.

---

## 💡 Funcionalidades

| Método | Endpoint | Parámetros | Descripción |
|:------:|:---------|:-----------|:------------|
| GET | `/` | `username` (opcional) | Devuelve todos los posts o solo los creados por un usuario específico |

---

## 📁 Estructura del proyecto

```bash
ejemplo13-db/
├── src/main/java/es/chatgpt/code/ejemplo13_db/
│   ├── models/
│   │   └── Post.java
│   ├── repository/
│   │   └── PostRepository.java
│   ├── controllers/
│   │   └── PostController.java
│   └── Application.java
├── src/main/resources/application.properties
├── postman/ejemplo13-db.postman_collection.json
├── pom.xml
└── README.md
```

---

## 🌐 Consola H2

Disponible en: <http://localhost:8080/h2-console>

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Importa las peticiones desde:

```bash
postman/ejemplo13-db.postman_collection.json
```

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman
