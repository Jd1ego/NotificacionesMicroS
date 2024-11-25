package com.example.NotificacionesMicroservicio.eventos;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    @Bean
    public Queue notificacionesQueue() {
        return new Queue("notificaciones_queue", true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("progreso_exchange");
    }

    @Bean
    public Binding binding(Queue notificacionesQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(notificacionesQueue).to(directExchange).with("progreso.actualizado");
    }

    // Configuración del MessageConverter para deserialización de JSON
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
