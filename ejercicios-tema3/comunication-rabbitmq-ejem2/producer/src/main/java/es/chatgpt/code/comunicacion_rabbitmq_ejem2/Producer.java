package es.chatgpt.code.comunicacion_rabbitmq_ejem2;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbit) {
        super();
        this.rabbitTemplate = rabbit;
    }

    private int numData;

    @Scheduled(fixedRate = 1000)
    public void sendData() {

        ExampleData data = new ExampleData("data " + numData, numData, numData % 2 == 0);
        
        numData++;

        System.out.println("publishToQueue: " + data);

        rabbitTemplate.convertAndSend("messagesJson", data);
    }
}