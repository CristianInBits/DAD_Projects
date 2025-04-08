# 📚 Book Client (JsonNode-based)

Este proyecto utiliza **RestTemplate** y **JsonNode** (Jackson) para procesar manualmente la respuesta de la API de Google Books.

---

## 🌐 Endpoint disponible

- `GET /booktitles-json?title=java`  
  Devuelve una lista de títulos de libros que contienen "java" en su título.

---

## 🧠 ¿Cómo funciona?

- Se realiza una petición `GET` a:  
  `https://www.googleapis.com/books/v1/volumes?q=intitle:{title}`

- En lugar de mapear la respuesta a clases Java, se accede directamente a los nodos JSON usando `JsonNode` y `ArrayNode`.

---

## 📦 Tecnologías

- Java 24+
- Spring Boot
- `RestTemplate`
- Jackson (manipulación de nodos JSON)

---

## ▶️ Ejecución

1. Ejecuta `Application.java`
2. Accede a:  
   `http://localhost:8080/booktitles-json?title=spring`
