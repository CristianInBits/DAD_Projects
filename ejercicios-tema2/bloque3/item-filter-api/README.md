# 🛒 Item Filter API

Este proyecto es una API REST construida con Spring Boot para gestionar una lista de Items, permitiendo operaciones CRUD y filtrado por precio.

## 🚀 Características

- Gestión de Items en memoria.
- Operaciones CRUD: crear, leer, borrar.
- Filtro por parámetro `priceBelow` para mostrar solo items con precio inferior al indicado.

## 🧪 Endpoints principales

| Método | Endpoint           | Descripción |
|--------|--------------------|-------------|
| GET    | /items/            | Obtener todos los items o filtrar por precio (`?priceBelow=5.0`) |
| GET    | /items/{id}        | Obtener un item específico por su ID |
| POST   | /items/            | Crear un nuevo item |
| DELETE | /items/{id}        | Borrar un item por su ID |

## 🔧 Requisitos

- Java 24+
- Maven
- Postman (para probar interactivamente los endpoints)

## ▶️ Ejecución

```bash
mvn spring-boot:run
```

## 📂 Estructura del proyecto

```
item-filter-api/
├── src/
│   └── main/
│       └── java/
│           └── es/chatgpt/code/itemfilterapi/
│               ├── ItemFilterApiApplication.java
│               ├── controller/
│               │   └── ItemController.java
│               ├── model/
│               │   └── Item.java
│               └── service/
│                   └── ItemService.java
├── pom.xml
└── README.md
```