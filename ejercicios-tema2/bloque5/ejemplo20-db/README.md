# 🧾 Ejemplo 20 - Gestión del esquema con MySQL

Este proyecto muestra cómo integrar una base de datos **MySQL** en una aplicación Spring Boot y cómo gestionar el esquema de la base de datos mediante la propiedad `spring.jpa.hibernate.ddl-auto`.

---

## 💡 Funcionalidades

- Integración de base de datos MySQL con JPA
- Paginación de resultados con Spring Data
- Consulta de posts por usuario
- Gestión del esquema con `ddl-auto=validate`

---

## ⚙️ Configuración del esquema

- **Base de datos**: MySQL (requiere tener un esquema `posts` creado previamente)
- **Modo de esquema**: `validate` (verifica que el esquema coincide con las entidades JPA)

---

## 📁 Estructura del proyecto

```bash
ejemplo20-db/
├── src/
│   └── main/
│       ├── java/
│       │   └── es/
│       │       └── chatgpt/
│       │           └── code/
│       │               └── ejemplo20_db/
│       │                   ├── controller/
│       │                   │   └── PostController.java
│       │                   ├── model/
│       │                   │   └── Post.java
│       │                   ├── repository/
│       │                   │   └── PostRepository.java
│       │                   └── Application.java
│       └── resources/
│           └── application.properties
├── README.md
└── pom.xml
```

---

## 🔌 Configuración de conexión MySQL

```properties
spring.datasource.url=jdbc:mysql://localhost/posts
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=validate
```

> El esquema `posts` debe existir en MySQL y contener las tablas adecuadas.

---

## 🔢 Endpoints disponibles

| Método | Endpoint     | Descripción                               |
|--------|--------------|-------------------------------------------|
| GET    | `/posts/`    | Lista paginada de todos los posts         |
| GET    | `/posts/?user=Pepe` | Lista paginada filtrando por nombre de usuario |

---

## 📦 Dependencias necesarias

En `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

---

## 🛠️ Tecnologías utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

---

## 📝 Notas

- En este ejemplo no se genera el esquema automáticamente.
- Si el esquema no coincide, la aplicación no arrancará.
- Se recomienda usar este modo (`validate`) en entornos de producción para garantizar integridad.
