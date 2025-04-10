# 🧾 Ejemplo 4 - API REST con ResponseEntity.of()

Este proyecto es un ejemplo de una API REST desarrollada con Spring Boot que utiliza una base de datos H2 en memoria. Se centra en el uso de `ResponseEntity.of(Optional)` para gestionar la existencia de recursos de forma más concisa.

---

## 💡 Funcionalidades

- Obtener todos los posts (GET /posts/)
- Obtener un post por id (GET /posts/{id})
- Crear un nuevo post (POST /posts/)
- Actualizar un post existente (PUT /posts/{id})
- Eliminar un post existente (DELETE /posts/{id})

---

## 📁 Estructura del proyecto

```bash
ejemplo4-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── codeurjc/
│       │           └── board/
│       │               ├── controllers/
│       │               │   └── PostController.java
│       │               ├── models/
│       │               │   └── Post.java
│       │               └── repository/
│       │                   └── PostRepository.java
│       └── resources/
│           └── application.properties
├── postman/
│   └── ejemplo4-db.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔢 Endpoints disponibles

| Método | Endpoint         | Descripción                          |
|--------|------------------|--------------------------------------|
| GET    | `/posts/`        | Listar todos los posts               |
| GET    | `/posts/{id}`    | Obtener post por ID                  |
| POST   | `/posts/`        | Crear un nuevo post                  |
| PUT    | `/posts/{id}`    | Reemplazar un post por ID            |
| DELETE | `/posts/{id}`    | Borrar un post por ID                |

---

## 🌐 Consola web H2

Disponible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

> Para activarla asegúrate de tener esta propiedad:

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Puedes importar la colección desde el archivo:

```bash
postman/ejemplo4-db.postman_collection.json
```

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman
