# 🍽️ Recipe API

Una API REST sencilla para gestionar recetas de cocina. Permite realizar operaciones CRUD completas.

---

## 📌 Endpoints

| Método | Ruta               | Descripción                    |
|--------|--------------------|--------------------------------|
| GET    | `/recipes/`        | Listar todas las recetas       |
| GET    | `/recipes/{id}`    | Obtener una receta concreta    |
| POST   | `/recipes/`        | Crear una nueva receta         |
| PUT    | `/recipes/{id}`    | Reemplazar una receta existente|
| DELETE | `/recipes/{id}`    | Eliminar una receta            |

---

## 📦 Ejemplo de receta (JSON)

```json
{
  "title": "Brownie de chocolate",
  "ingredients": "Chocolate, huevos, mantequilla, azúcar",
  "instructions": "Mezclar y hornear 25 minutos",
  "readyInMinutes": 30
}