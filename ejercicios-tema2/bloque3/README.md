# 🧩 Bloque 3 - APIs REST con Spring

Este bloque contiene una serie de proyectos prácticos centrados en la creación y consumo de **APIs RESTful** utilizando **Spring Boot**. Cada subcarpeta representa un proyecto independiente que se puede ejecutar por separado.

---

## 📁 Proyectos incluidos

| Carpeta       | Descripción                                                            |
|---------------|------------------------------------------------------------------------|
| `book-api/` | API REST para gestionar libros favoritos (GET, POST, PUT, DELETE).|
| `bookclient-model/` | Cliente REST que consume Google Books API usando clases modelo. |
| `bookclient-node/`  | Cliente REST que consume Google Books API usando nodos JSON (JsonNode). |
| `contact-api/` | API REST para gestionar contactos (GET, POST, PUT, DELETE).|
| `dog-api/` | Cliente REST que consume Dog API usando FeignClient |
| `item-api/` | API REST para gestionar items de la compra (GET, POST, PUT, DELETE).|
| `library-api` | API REST con Spring Boot que gestiona libros y autores, usando `@JsonView` |
| `movie-api/` | API REST para gestionar películas favoritas (GET, POST, PUT, DELETE).|
| `recipe-api` | API REST para gestionar recetas de cocina (GET, POST, PUT, DELETE). |
| `recipe-doc-api` | API REST que gestiona recetas y está documentada con SpringDoc y Swagger UI |
| `studentcourse-api` | API REST con Spring Boot que gestiona estudiantes y cursos, usando `@JsonView` |
| `tasks-api/`| API REST para gestionar una lista de tareas (GET, POST, PUT, DELETE).|
| `tvseries-api` | API REST con Spring Boot que gestiona series y actores, usando `@JsonView` |
| _..._ | Se irán añadiendo más ejercicios próximamente.|

---

## ⚙️ Tecnologías utilizadas

- Java 17+
- Spring Boot
- Maven
- JSON como formato de intercambio
- Postman para pruebas interactivas de las APIs

---

## ▶️ Cómo ejecutar un ejercicio

1. Entra en la carpeta del ejercicio, por ejemplo `book-api/`
2. Ejecuta la clase `Application.java`
3. Accede a `http://localhost:8080` o utiliza Postman según el caso

> Cada proyecto debe ejecutarse por separado (un solo servidor a la vez).

---

## 📝 Propósito

Estos ejercicios están diseñados para reforzar el conocimiento de:

- Arquitectura REST
- Mapeo de objetos a JSON
- Operaciones CRUD sobre recursos
- Buenas prácticas con rutas y métodos HTTP
- Desarrollo y prueba de endpoints

---