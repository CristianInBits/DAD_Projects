# ✅ Task Manager API

Este proyecto es una API REST sencilla desarrollada con Spring Boot para gestionar tareas.

## 🚀 Endpoints disponibles

| Método | Ruta               | Descripción                       |
|--------|--------------------|-----------------------------------|
| GET    | /tasks/            | Obtiene todas las tareas          |
| GET    | /tasks/{id}        | Obtiene una tarea específica      |
| POST   | /tasks/            | Crea una nueva tarea              |
| PUT    | /tasks/{id}        | Actualiza una tarea existente     |
| DELETE | /tasks/{id}        | Elimina una tarea existente       |

## 📦 Estructura del proyecto

- `Task.java`: Modelo con los atributos `id`, `title`, `description` y `done`
- `TaskService.java`: Servicio que gestiona las tareas en memoria
- `TaskController.java`: Controlador REST que expone los endpoints

## 🧪 Probar la API

Se puede usar Postman importando el archivo:
`Task-manager-api.postman_collection.json`


## 💻 Requisitos

- Java 17+
- Maven 3.6+
- Postman (opcional para pruebas)

---