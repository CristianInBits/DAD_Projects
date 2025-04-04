# 📚 Book API - Bloque 3

Este proyecto es una API REST simple para gestionar una colección de libros favoritos. Ha sido desarrollado como parte del **Bloque 3** del curso: *APIs REST con Spring Boot*.

---

## 📌 Endpoints disponibles

| Método | Ruta         | Descripción                        |
|--------|--------------|------------------------------------|
| GET    | `/books/`    | Obtener todos los libros           |
| GET    | `/books/{id}`| Obtener un libro por ID            |
| POST   | `/books/`    | Añadir un nuevo libro              |
| PUT    | `/books/{id}`| Reemplazar un libro por su ID      |
| DELETE | `/books/{id}`| Eliminar un libro por su ID        |

---

## ▶️ Ejemplo de JSON para `POST` o `PUT`

```json
{
  "title": "El nombre del viento",
  "author": "Patrick Rothfuss",
  "rating": 5
}