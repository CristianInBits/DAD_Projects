# 📨 Ejemplo 1 - Comunicación asíncrona con RabbitMQ

Este proyecto muestra un ejemplo básico de comunicación entre aplicaciones mediante el patrón **Productor/Consumidor** usando **RabbitMQ** y **Spring Boot**. El productor genera mensajes de texto cada segundo y el consumidor los recibe e imprime por consola.

---

## 🚀 Tecnologías utilizadas

* Java 17+
* Spring Boot 3+
* Spring AMQP (RabbitMQ)
* RabbitMQ (Broker de mensajes)
* Docker (para lanzar RabbitMQ localmente)

---

## 📂 Estructura del proyecto

```bash
comunicacion-rabbitmq-ejem1-
├── producer/
│   ├── src/main/java/es/codeurjc/mastercloudapps/amqp/
│   │   ├── Application.java        # Configuración de la cola
│   │   └── Producer.java           # Enío de mensajes automático
├── consumer/
    ├── src/main/java/es/codeurjc/mastercloudapps/amqp/
    │   ├── Application.java        # Configuración de la cola
    │   └── Consumer.java           # Recepción de mensajes
```

---

## ⚙️ Configuración de RabbitMQ

Puedes lanzar un broker local de RabbitMQ con Docker:

```bash
docker run --rm -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

Accede a la consola de gestión:

* URL: [http://localhost:15672/](http://localhost:15672/)
* Usuario: `guest`  Contraseña: `guest`

---

## 🔁 Lógica de comunicación

* **Productor**: cada segundo envía un mensaje como "Data 0", "Data 1", ... a la cola `messages`.
* **Consumidor**: escucha la cola `messages` y muestra por consola el mensaje recibido.

Diagrama:

```mathematica
[Producer] -- "messages" --> [RabbitMQ Queue] -- "messages" --> [Consumer]
```

---

## ▶️ Ejecución

1. Asegúrate de que RabbitMQ está corriendo
2. Ejecuta primero el proyecto `producer`
3. Ejecuta luego el proyecto `consumer`
4. Observa los mensajes impresos por consola:

```bash
Message: Data 0
Message: Data 1
...
```

---

## 🧠 Conceptos aplicados

* Patrón de mensajes asíncronos (One-way Notification)
* Uso de colas en RabbitMQ
* Comunicación desacoplada entre aplicaciones
* Configuración de colas con `@Bean`
* Inyección de dependencias con Spring

---

## 📌 Dependencias clave

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
```

---

## 🧪 Posibles mejoras / ejercicios

* Hacer que la cola sea duradera (`new Queue("messages", true)`)
* Enviar objetos JSON en lugar de texto plano
* Añadir un `Exchange` con `routingKey`
* Escalar múltiples consumidores en paralelo
