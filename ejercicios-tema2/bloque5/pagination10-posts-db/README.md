# 🧾 Posts API con Paginación (`pagination10-posts-db`)

Este proyecto implementa una API REST en Spring Boot para gestionar posts y demostrar el uso de **paginación** con `Pageable`. Permite consultar publicaciones de forma paginada mediante parámetros `page` y `size`.

---

## 💡 Funcionalidades

- Inicializa 10 publicaciones por defecto.
- Obtener publicaciones paginadas (`GET /posts/?page=...&size=...`)
- Filtrado opcional por usuario (`?username=...`)
- Soporte para ordenación (parámetro `sort`, opcional)

---

## 📁 Estructura del proyecto

```bash
pagination10-posts-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── chatgpt/
│       │           └── code/
│       │               └── pagination10_posts_db/
│       │                   ├── controllers/
│       │                   │   └── PostController.java
│       │                   ├── models/
│       │                   │   └── Post.java
│       │                   ├── repository/
│       │                   │   └── PostRepository.java
│       │                   └── Application.java
│       └── resources/
│           └── application.properties
├── postman/
│   └── pagination10-posts-db.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔢 Endpoints disponibles

| Método | Endpoint        | Descripción                                     |
|--------|------------------|-------------------------------------------------|
| GET    | `/posts/`        | Obtener todos los posts (paginado y filtrado)  |

> Puedes añadir los siguientes parámetros:

- `page`: Número de página (comienza en 0)
- `size`: Número de resultados por página
- `username`: Filtro opcional por nombre de usuario
- `sort`: Campo y orden para ordenación (por ejemplo `sort=username,asc`)

---

## 🌐 Consola web H2

Disponible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

La colección para probar los distintos endpoints paginados se encuentra en:

```bash
postman/pagination10-posts-db.postman_collection.json
```

Incluye ejemplos para:

- Página 0 (`page=0&size=3`)
- Página 1
- Página 2
- Página 3

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman
