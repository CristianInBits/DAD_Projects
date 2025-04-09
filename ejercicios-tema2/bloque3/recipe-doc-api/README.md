# 📘 Recipe Doc API

Este proyecto implementa una API REST de gestión de recetas usando **Spring Boot** y está documentada automáticamente con **SpringDoc** y **Swagger UI**.

## 📌 Características

- Operaciones CRUD básicas para recetas (GET, POST, DELETE).
- Documentación OpenAPI generada automáticamente.
- Swagger UI disponible para pruebas interactivas de la API.
- Estructura modular con `Controller`, `Service` y modelo `Recipe`.

## ▶️ Cómo ejecutar

1. Abre el proyecto en tu IDE.
2. Ejecuta la clase `Application.java`.
3. Accede a:

```
http://localhost:8080/swagger-ui/index.html
```

## 🧱 Endpoints disponibles

| Método | Ruta           | Descripción                   |
|--------|----------------|-------------------------------|
| GET    | `/recipes`     | Obtiene todas las recetas     |
| GET    | `/recipes/{id}`| Obtiene una receta por ID     |
| POST   | `/recipes`     | Crea una nueva receta         |
| DELETE | `/recipes/{id}`| Elimina una receta por ID     |

## 🛠️ Dependencias clave

- `spring-boot-starter-web`
- `springdoc-openapi-starter-webmvc-ui`

## 📎 Requisitos

- Java 24+
- Maven 3.6+
