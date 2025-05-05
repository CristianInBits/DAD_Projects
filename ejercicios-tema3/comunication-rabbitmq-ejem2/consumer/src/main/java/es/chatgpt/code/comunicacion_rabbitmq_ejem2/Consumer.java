package es.chatgpt.code.comunicacion_rabbitmq_ejem2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues = "messagesJson", ackMode = "AUTO")
    public void received(ExampleData data) {
        System.out.println(data);
    }
}
