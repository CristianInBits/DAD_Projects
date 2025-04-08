# 📚 Book Client (Model-based)

Este proyecto utiliza **RestTemplate** de Spring Boot junto con clases Java para consumir la API pública de libros de Google Books.

---

## 🌐 Endpoint disponible

- `GET /booktitles?title=java`  
  Devuelve una lista de títulos de libros que contienen "java" en su título.

---

## 🧠 ¿Cómo funciona?

- Se realiza una petición `GET` a:  
  `https://www.googleapis.com/books/v1/volumes?q=intitle:{title}`

- Se deserializa la respuesta JSON directamente en clases Java (`BooksResponse`, `Book`, `VolumeInfo`).

---

## 📦 Tecnologías

- Java 17+
- Spring Boot
- `RestTemplate`
- Jackson (para deserialización automática de JSON)

---

## ▶️ Ejecución

1. Ejecuta `Application.java`
2. Accede a:  
   `http://localhost:8080/booktitles?title=spring`
