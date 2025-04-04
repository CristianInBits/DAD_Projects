
# 🧾 Items API - API REST CRUD en memoria

Este proyecto implementa una API REST sencilla en Java con Spring Boot para gestionar una lista de items (tipo lista de la compra).

## 📌 Endpoints disponibles

| Método | Endpoint           | Descripción                        |
|--------|--------------------|------------------------------------|
| GET    | `/items/`          | Listar todos los items             |
| GET    | `/items/{id}`      | Obtener un item por ID             |
| POST   | `/items/`          | Crear un nuevo item                |
| PUT    | `/items/{id}`      | Reemplazar un item existente       |
| DELETE | `/items/{id}`      | Eliminar un item por ID            |

## 🧪 Ejemplo de JSON (POST/PUT)

```json
{
  "description": "Pan integral",
  "checked": false
}
```

## 🚀 Cómo ejecutar

```bash
mvn spring-boot:run
```

Accede a `http://localhost:8080/items/` para probar la API con herramientas como **Postman**.

## 🧰 Tecnologías

- Java 17+
- Spring Boot
- Maven
- Postman (para testing)