package com.example.NotificacionesMicroservicio.servicios;

import com.example.NotificacionesMicroservicio.eventos.ProgresoActualizadoEvento;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailNotificationService {

    @Autowired
    private JavaMailSender mailSender;


    @RabbitListener(queues = "notificaciones_queue")  // Escucha en la cola correcta
    public void recibirEvento(ProgresoActualizadoEvento evento) {
        System.out.println("Evento recibido: " + evento.getTituloProyecto());

        // Obtener la lista de correos de los miembros del equipo desde el evento
        List<String> correosEquipo = evento.getCorreosEquipo();

        // Enviar correo a cada uno de los destinatarios
        for (String destinatario : correosEquipo) {
            enviarCorreo(destinatario, "Notificación de Progreso - " + evento.getTituloProyecto(),
                    "El estado del proyecto ha cambiado. Estado anterior: " + evento.getEstadoAnterior() +
                            "\nNuevo estado: " + evento.getNuevoEstado() +
                            "\nFecha: " + evento.getFechaActualizacion());
        }
    }

    // Método para enviar el correo
    private void enviarCorreo(String destinatario, String asunto, String contenido) {
        try {
            SimpleMailMessage mensaje = new SimpleMailMessage();
            mensaje.setTo(destinatario);
            mensaje.setSubject(asunto);
            mensaje.setText(contenido);
            mailSender.send(mensaje);
            System.out.println("Correo enviado a: " + destinatario);
        } catch (Exception e) {
            System.err.println("Error al enviar correo: " + e.getMessage());
        }
    }
}
