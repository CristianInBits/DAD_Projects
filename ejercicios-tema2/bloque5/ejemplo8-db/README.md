# ⚽ Ejemplo 8 – Relación 1 : N unidireccional (Team → Player)

Este proyecto muestra una relación **uno‑a‑muchos unidireccional** entre `Team` y `Player` usando Spring Boot, Spring Data JPA y una base de datos H2 en memoria. No hay cascada: los jugadores tienen ciclo de vida independiente del equipo.

---

## 💡 Funcionalidades

- Listar todos los equipos (GET `/teams/`)
- Listar todos los jugadores (GET `/players/`)
- Eliminar un equipo (DELETE `/teams/{id}`)  
  *No* elimina sus jugadores asociados.
- Eliminar un jugador (DELETE `/players/{id}`)  
  Solo posible si el jugador no pertenece a un equipo.

---

## 📁 Estructura del proyecto

```bash
ejemplo8-db/
├── src/main/java/es/chatgpt/code/ejemplo8_db/
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
├── postman/ejemplo8-db.postman_collection.json
├── pom.xml
└── README.md
```

---

## 🔢 Endpoints disponibles

| Método | Endpoint            | Descripción                                                   |
|:------:|:--------------------|:--------------------------------------------------------------|
| GET    | `/teams/`           | Devuelve la lista de equipos (incluye sus jugadores)          |
| GET    | `/players/`         | Devuelve la lista de todos los jugadores                      |
| DELETE | `/teams/{id}`       | Borra el equipo (los jugadores quedan huérfanos)              |
| DELETE | `/players/{id}`     | Borra un jugador (solo si no está asociado a un equipo)       |

---

## 🌐 Consola web H2

Disponible en: <http://localhost:8080/h2-console>

```properties
spring.h2.console.enabled=true
```

---

## 📊 Colección Postman

Importa las peticiones desde:

```bash
postman/ejemplo8-db.postman_collection.json
```

---

## 🛠️ Tecnologías utilizadas

- Java 24  
- Spring Boot  
- Spring Data JPA  
- H2 Database  
- Maven  
- Postman
