# 📚 Library API - Spring REST + JsonView

Este proyecto expone una API REST con Spring Boot que gestiona libros y autores, usando `@JsonView` para evitar referencias circulares en la conversión a JSON.

## 🔍 Endpoints

| Método | Ruta              | Descripción                                  |
|--------|-------------------|----------------------------------------------|
| GET    | /libros           | Lista básica de libros                       |
| GET    | /libros/{id}      | Detalle de libro + autores (sin sus libros) |
| GET    | /autores          | Lista básica de autores                      |
| GET    | /autores/{id}     | Detalle de autor + libros (sin sus autores) |

## 🛠️ Tecnologías

- Java 24+
- Spring Boot
- Jackson (`@JsonView`)