package com.example.NotificacionesMicroservicio.eventos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;

public class ProgresoActualizadoEvento {

    private String tituloProyecto;
    private Long proyectoId;
    private String estadoAnterior;
    private String nuevoEstado;
    private LocalDateTime fechaActualizacion;
    private String usuarioSistema;
    private List<String> correosEquipo;

    // Constructor sin parámetros
    public ProgresoActualizadoEvento() {
    }

    // Constructor con parámetros y anotaciones para Jackson
    @JsonCreator
    public ProgresoActualizadoEvento(
            @JsonProperty("tituloProyecto") String tituloProyecto,
            @JsonProperty("proyectoId") Long proyectoId,
            @JsonProperty("estadoAnterior") String estadoAnterior,
            @JsonProperty("nuevoEstado") String nuevoEstado,
            @JsonProperty("fechaActualizacion") LocalDateTime fechaActualizacion,
            @JsonProperty("usuarioSistema") String usuarioSistema,
            @JsonProperty("correosEquipo") List<String> correosEquipo) {
        this.tituloProyecto = tituloProyecto;
        this.proyectoId = proyectoId;
        this.estadoAnterior = estadoAnterior;
        this.nuevoEstado = nuevoEstado;
        this.fechaActualizacion = fechaActualizacion;
        this.usuarioSistema = usuarioSistema;
        this.correosEquipo = correosEquipo;
    }

    // Getters y Setters
    public String getTituloProyecto() {
        return tituloProyecto;
    }

    public void setTituloProyecto(String tituloProyecto) {
        this.tituloProyecto = tituloProyecto;
    }

    public Long getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Long proyectoId) {
        this.proyectoId = proyectoId;
    }

    public String getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(String estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }

    public String getNuevoEstado() {
        return nuevoEstado;
    }

    public void setNuevoEstado(String nuevoEstado) {
        this.nuevoEstado = nuevoEstado;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getUsuarioSistema() {
        return usuarioSistema;
    }

    public void setUsuarioSistema(String usuarioSistema) {
        this.usuarioSistema = usuarioSistema;
    }

    public List<String> getCorreosEquipo() {
        return correosEquipo;
    }

    public void setCorreosEquipo(List<String> correosEquipo) {
        this.correosEquipo = correosEquipo;
    }
}
