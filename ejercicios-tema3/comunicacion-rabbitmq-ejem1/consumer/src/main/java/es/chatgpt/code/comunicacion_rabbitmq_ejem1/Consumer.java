package es.chatgpt.code.comunicacion_rabbitmq_ejem1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = "messages", ackMode = "AUTO")
    public void received(String message) {
        System.out.println("Message: " + message);
    }
}
