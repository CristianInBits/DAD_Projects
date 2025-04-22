# 📄 Ejemplo 18 - API REST con paginación y ordenación

Este proyecto demuestra cómo implementar **paginación** y **ordenación** en una API REST con **Spring Boot** y **Spring Data JPA**. Los datos se almacenan en una base de datos H2 en memoria.

---

## 💡 Funcionalidades

- Listar posts con paginación (`page` y `size`)
- Filtrar por usuario (`username`) combinando paginación
- Ordenar por cualquier campo (`sort=campo,dirección`)
- Respuesta JSON incluye metadatos como total de elementos, páginas, si es primera/última, etc.

---

## 📁 Estructura del proyecto

```bash
ejemplo18-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── chatgpt/
│       │           └── code/
│       │               └── ejemplo18_db/
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
│   └── ejemplo18-db.postman_collection.json
├── README.md
└── pom.xml
```

---

## 🔢 Endpoints disponibles

| Método | Endpoint         | Descripción                                                  |
|--------|------------------|--------------------------------------------------------------|
| GET    | `/posts/`        | Listar todos los posts con paginación y ordenación opcional |
| GET    | `/posts/?username=Pepe` | Listar los posts de un usuario concreto paginados   |

> Puedes añadir parámetros como `page=0&size=5&sort=title,asc` a las peticiones.

---

## 📊 Ejemplos de URL con paginación

- `http://localhost:8080/posts/?page=0&size=2` → Página 0 con 2 elementos
- `http://localhost:8080/posts/?username=Pepe&page=1&size=3` → Página 1 de los posts de Pepe
- `http://localhost:8080/posts/?sort=username,desc` → Todos los posts ordenados por nombre de usuario descendente

---

## 🌐 Consola web H2

Disponible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

> Asegúrate de tener activado en `application.properties`:

```properties
spring.h2.console.enabled=true
```

---

## 📂 Colección Postman

Ubicada en:

```bash
postman/ejemplo18-db.postman_collection.json
```

Incluye:

- Paginación básica
- Filtrado por `username`
- Ordenación descendente por `username`

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- H2 Database (en memoria)
- Maven
- Postman
