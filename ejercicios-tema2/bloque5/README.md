# 📂 Bloque 5 - Bases de Datos SQL en Spring

Este bloque contiene ejercicios prácticos sobre integración de **bases de datos relacionales** en aplicaciones **Spring Boot**, utilizando **Spring Data JPA**. Cada carpeta representa un proyecto independiente centrado en conceptos como persistencia de entidades, repositorios, consultas, relaciones y mapeo objeto-relacional (ORM).

---

## 📁 Proyectos incluidos

| Carpeta              | Descripción                                                               |
|----------------------|-----------------------------------------------------------------------------|
| `ejemplo1-db/`       | Uso básico de JPA con repositorio y operaciones CRUD por consola Java.     |
| _..._                | Se irán añadiendo nuevos ejemplos con más funcionalidades y relaciones.     |

---

## ⚙️ Tecnologías utilizadas

- Java 24+
- Spring Boot
- Spring Data JPA
- H2 Database (en memoria)
- Maven

---

## ▶️ Ejecución de los ejercicios

1. Abre la carpeta del ejercicio (por ejemplo, `ejemplo1-db/`)
2. Ejecuta la clase `Application.java` o la clase que implemente `CommandLineRunner`
3. Observa la salida por consola o accede a la interfaz HTTP si está disponible

> En algunos ejercicios se puede acceder a la consola web de H2 en: `http://localhost:8080/h2-console`

---

## 📋 Objetivos del bloque

- Comprender el modelo de entidades en JPA
- Configurar una base de datos relacional en Spring Boot
- Usar repositorios para acceder a los datos
- Realizar operaciones CRUD sobre entidades
- Aprender a trabajar con consultas derivadas del nombre de métodos
- Acceder y modificar datos desde controladores o servicios

---