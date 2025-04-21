# ⚽ Ejemplo 14 – Relación M:N bidireccional + Filtro con @Query

Este proyecto demuestra una relación **muchos a muchos bidireccional** entre `Player` y `Team`, junto con el uso de `@JsonView` para control de proyecciones JSON y una consulta personalizada con `@Query`.

---

## 💡 Funcionalidades

| Método | Endpoint | Parámetros | Descripción |
|--------|----------|-------------|-------------|
| GET    | `/teams/` | `name` (opcional) | Lista los equipos (todos o filtrados por nombre) |
| GET    | `/players/{id}` | - | Muestra un jugador y sus equipos |

---

## 📁 Estructura del proyecto

```bash
ejemplo14-db/
├── src/main/java/es/chatgpt/code/ejemplo14_db/
│   ├── controllers/
│   │   └── TeamController.java
│   ├── models/
│   │   ├── Player.java
│   │   └── Team.java
│   ├── repository/
│   │   ├── PlayerRepository.java
│   │   └── TeamRepository.java
│   └── Application.java
├── src/main/resources/application.properties
├── postman/ejemplo14-db.postman_collection.json
├── pom.xml
└── README.md
```

---

## 🔢 Endpoints disponibles

- `GET /teams/` → Lista de equipos, con posibilidad de filtro por `?name=`
- `GET /players/{id}` → Datos del jugador + equipos a los que pertenece

---

## 🌐 Consola H2

Disponible en: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Importa las peticiones desde:

```bash
postman/ejemplo14-db.postman_collection.json
```

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- Postman
