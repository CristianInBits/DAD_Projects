# 🐶 Dog Image API (Feign Client)

Este proyecto es una aplicación Spring Boot que actúa como **cliente REST** utilizando **Feign** para consumir la API pública de [Dog API](https://dog.ceo/dog-api/), la cual devuelve imágenes aleatorias de perros.

## 📌 Objetivo

- Aprender a consumir APIs REST externas desde el servidor usando Feign.
- Familiarizarse con la anotación `@FeignClient` y la inyección de servicios.
- Practicar el mapeo automático de respuestas JSON con clases modelo.

## 🔧 Tecnologías

- Java 24
- Spring Boot
- Spring Cloud OpenFeign
- REST API
- JSON
- Maven

## 🚀 Ejecución

1. Ejecuta la clase `DogImageApiApplication.java`
2. Abre Postman o tu navegador en:

```
GET http://localhost:8080/dog-image
```

👉 Te devolverá directamente la **URL de una imagen aleatoria de perro** como texto plano.

## 🧱 Estructura del proyecto

```
dog-image-api/
├── controller/      # Lógica web (controlador)
├── model/           # Clase Java para mapear el JSON
├── service/         # Interfaz Feign para consumir la API
├── application.properties
└── DogImageApiApplication.java
```

## 🧠 Qué se ha practicado

- Uso de `@FeignClient` para declarar un cliente REST
- Configuración de Spring Boot para trabajar con servicios externos
- Desacoplamiento de lógica de red a través de interfaces
- Inyección de dependencias con constructor

---

© Proyecto de aprendizaje con fines educativos. 😄