# 🖼️ Product Image API

Este proyecto es una API REST desarrollada con **Spring Boot** que permite gestionar un catálogo de productos tecnológicos. Cada producto puede tener una imagen asociada.

---

## ✨ Funcionalidades

- Consultar todos los productos
- Consultar un producto por ID
- Crear un nuevo producto
- Subir una imagen para un producto
- Descargar la imagen de un producto
- Eliminar la imagen asociada a un producto
- Eliminar un producto

---

## 🧪 Pruebas con Postman

Incluye una colección de Postman para probar los endpoints:

```
product-image-api.postman_collection.json
```

---

## 🚀 Cómo ejecutar

1. Abre el proyecto en tu IDE
2. Ejecuta la clase `Application.java`
3. Accede a `http://localhost:8080/products/`
4. Usa Postman para probar los endpoints disponibles

> Las imágenes se almacenan en una carpeta `images/products/` dentro del directorio del proyecto.

---

## ⚙️ Tecnologías usadas

- Java 24+
- Spring Boot
- Maven
- API REST + JSON
- Gestión de imágenes con `MultipartFile`