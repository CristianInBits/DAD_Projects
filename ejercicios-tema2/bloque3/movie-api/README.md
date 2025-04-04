# 🎬 Movie API

API REST básica para gestionar un catálogo de películas usando Spring Boot.

## 🛠️ Endpoints

- `GET /movies/` → Lista todas las películas
- `GET /movies/{id}` → Consulta una película por ID
- `POST /movies/` → Crea una nueva película
- `PUT /movies/{id}` → Modifica una película existente
- `DELETE /movies/{id}` → Elimina una película

## 🎯 Modelo

```json
{
  "title": "Inception",
  "director": "Christopher Nolan",
  "genre": "Sci-Fi",
  "year": 2010
}