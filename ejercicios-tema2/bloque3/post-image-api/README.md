# 🖼️ Post Image API

Este proyecto implementa una API REST para gestionar publicaciones que pueden incluir imágenes.

## Endpoints principales

- `GET /posts/` – Listar todas las publicaciones
- `POST /posts/` – Crear una nueva publicación
- `GET /posts/{id}` – Obtener detalles de una publicación
- `PUT /posts/{id}` – Reemplazar publicación
- `DELETE /posts/{id}` – Eliminar publicación (y su imagen)
- `POST /posts/{id}/image` – Subir imagen
- `GET /posts/{id}/image` – Descargar imagen
- `DELETE /posts/{id}/image` – Eliminar imagen

## Cómo subir una imagen con Postman

1. Selecciona `POST /posts/{id}/image`
2. En la pestaña **Body > form-data**, añade una clave llamada `imageFile`
3. Tipo: **File**
4. Carga la imagen desde tu sistema

## Tecnologías

- Java 24
- Spring Boot 3.4
- API REST con JSON
- Gestión de ficheros e imágenes con Multipart
