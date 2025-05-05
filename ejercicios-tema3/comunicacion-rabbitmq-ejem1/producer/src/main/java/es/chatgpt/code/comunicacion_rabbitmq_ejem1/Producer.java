package es.chatgpt.code.comunicacion_rabbitmq_ejem1;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        super();
        this.rabbitTemplate = rabbitTemplate;
    }

    private int numData;

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {

        String data = "Data " + numData++;

        System.out.println("publishToQueue '" + data + "'");

        rabbitTemplate.convertAndSend("messages", data);
    }
}
