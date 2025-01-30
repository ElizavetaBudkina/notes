package org.example.notes.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.example.notes.domain.dto.request.UserRequestDto;
import org.example.notes.logging.Loggable;
import org.example.notes.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Loggable
public class RabbitConsumer {

    private final UserService userService;

    @RabbitListener(queues = "queueUser")
    public void processQueueUser(UserRequestDto userRequestDto) {

        try {
            userService.save(userRequestDto);
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
